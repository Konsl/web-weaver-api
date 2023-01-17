package de.konsl.webweaverapi;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.konsl.webweaverapi.messages.request.*;
import de.konsl.webweaverapi.messages.response.*;
import de.konsl.webweaverapi.model.auth.CreateTrustInfo;
import de.konsl.webweaverapi.model.auth.Credentials;
import de.konsl.webweaverapi.model.FocusObject;
import de.konsl.webweaverapi.model.auth.LoginResult;
import de.konsl.webweaverapi.scopes.CalendarScope;
import de.konsl.webweaverapi.scopes.MembersScope;
import de.konsl.webweaverapi.scopes.MessagesScope;
import de.konsl.webweaverapi.scopes.MessengerScope;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class WebWeaverClient {
    static final Logger logger = LoggerFactory.getLogger(WebWeaverClient.class.getName());

    private final CloseableHttpClient httpClient;
    private int incrementalID = 0;

    private String endPoint;
    private String remoteHost;
    private String sessionID;

    public WebWeaverClient() {
        httpClient = HttpClients.createDefault();
    }

    public LoginResult login(Credentials credentials) {
        return login(credentials, null);
    }

    public LoginResult login(Credentials credentials, CreateTrustInfo createTrustInfo) {
        endPoint = resolveEndPoint(credentials.getEmail());

        List<Request<?>> requests = new ArrayList<>();
        requests.add(credentials.encode(this));

        if (createTrustInfo != null) {
            requests.add(new SetFocusRequest(FocusObject.TRUSTS));
            requests.add(new RegisterMasterRequest(createTrustInfo.getTitle(), createTrustInfo.getApplication(), createTrustInfo.getIdentity()));
        }

        requests.add(new GetInformationRequest());

        List<Response> responses = requestInternal(requests, false);

        assert responses != null;
        assert allSuccess(responses);

        sessionID = Objects.requireNonNull(findResponse(responses, GetInformationResponse.class)).getSessionID();
        return new LoginResult(findResponse(responses, LoginResponse.class),
                createTrustInfo != null ?
                        Objects.requireNonNull(findResponse(responses, RegisterMasterResponse.class)).getToken() :
                        null);
    }

    public void logout() {
        List<Response> responses = request(List.of(
                new SetSessionRequest(sessionID),
                new LogoutRequest()
        ));

        assert responses != null;
        assert allSuccess(responses);
    }

    public GetNonceResponse getNonce() {
        return findResponse(Objects.requireNonNull(requestInternal(List.of(new GetNonceRequest()), false)),
                GetNonceResponse.class);
    }

    public MessagesScope getMessagesScope() {
        return new MessagesScope(this);
    }

    public MembersScope getMembersScope(String login) {
        return new MembersScope(this, login);
    }

    public MessengerScope getMessengerScope() {
        return new MessengerScope(this);
    }

    public CalendarScope getCalendarScope() {
        return new CalendarScope(this);
    }

    public <T extends Response, U extends Request<T>> T request(U request, FocusObject focus) throws WebWeaverException {
        return request(request, focus, null);
    }

    public <T extends Response, U extends Request<T>> T request(U request, FocusObject focus, String focusLogin) throws WebWeaverException {
        List<Request<?>> requests = new ArrayList<>();
        requests.add(new SetSessionRequest(sessionID));

        if (focus != FocusObject.GLOBAL)
            requests.add(new SetFocusRequest(focus, focusLogin));

        requests.add(request);

        List<Response> responses = request(requests);
        assert responses != null;
        assert allSuccess(responses);

        Response mainResponse = responses.get(focus == FocusObject.GLOBAL ? 1 : 2);
        if (mainResponse.isError())
            throw new WebWeaverException(mainResponse.as());

        return mainResponse.as();
    }

    public List<Response> request(List<Request<?>> requests) {
        return requestInternal(requests, true);
    }

    private List<Response> requestInternal(List<Request<?>> requests, boolean loginRequired) {
        if (loginRequired)
            ensureLoggedIn();

        HttpPost req = new HttpPost(endPoint);
        req.addHeader("Accept", "application/json");
        req.addHeader("Content-Type", "application/json");

        JsonArray encoded = new JsonArray();
        for (Request<?> msg : requests)
            encoded.add(encodeRequest(msg));

        req.setEntity(new StringEntity(encoded.toString(), StandardCharsets.UTF_8));

        try {
            return httpClient.execute(req, response -> {
                String content = EntityUtils.toString(response.getEntity());
                response.close();

                JsonArray responseArray = JsonParser.parseString(content).getAsJsonArray();

                List<Response> responses = new ArrayList<>();
                for (int i = 0; i < responseArray.size(); i++)
                    responses.add(decodeResponse(responseArray.get(i).getAsJsonObject(), requests.get(i).getResponseSupplier()));
                return responses;
            });
        } catch (IOException e) {
            logger.error("Could not perform requests: " + encoded);
            return null;
        }
    }

    private void ensureLoggedIn() {
        if (endPoint == null || endPoint.isEmpty() || sessionID == null || sessionID.isEmpty()) {
            logger.error("Error: Not logged in");
            throw new IllegalStateException("Not logged in");
        }
    }

    private JsonObject encodeRequest(Request<?> msg) {
        JsonObject obj = new JsonObject();

        obj.addProperty("jsonrpc", "2.0");
        obj.addProperty("method", msg.getMethodID());
        obj.addProperty("id", incrementalID++);
        obj.add("params", msg.encodeParams());

        return obj;
    }

    private Response decodeResponse(JsonObject response, Supplier<? extends Response> constructor) {
        if (!response.has("result"))
            return new ErrorResponse("", "FATAL", "Unknown error", "-1");

        JsonObject result = response.getAsJsonObject("result");

        boolean isError = (result.has("return") && !result.get("return").getAsString().equalsIgnoreCase("ok")) ||
                result.has("error") ||
                result.has("errno");

        if (isError) {
            ErrorResponse decoded = new ErrorResponse();
            decoded.decode(result);

            return decoded;
        }

        try {
            Response decoded = constructor.get();
            decoded.decode(result);
            return decoded;
        } catch (Exception e) {
            logger.error("Could not decode response: " + response, e);
            return null;
        }
    }

    private String resolveEndPoint(String email) {
        HttpPost req = new HttpPost("https://fork.webweaver.de/service/get_responsible_host.php");
        req.setEntity(new UrlEncodedFormEntity(List.of(new BasicNameValuePair("login", email))));

        try {
            return httpClient.execute(req, response -> {
                String stringContent = EntityUtils.toString(response.getEntity());
                response.close();

                int start = stringContent.indexOf("<host>");
                int end = stringContent.indexOf("</host>");
                remoteHost = stringContent.substring(start, end).substring(6);
                return "https://" + remoteHost + "/jsonrpc.php";
            });
        } catch (IOException | IndexOutOfBoundsException e) {
            logger.error("Could not resolve end point for: " + email, e);
            return null;
        }
    }

    public String getRemoteHost() {
        return remoteHost;
    }

    public static boolean allSuccess(List<Response> responses) {
        return responses.stream().noneMatch(Response::isError);
    }

    public static <T extends Response> T findResponse(List<Response> responses, Class<T> type) {
        for (Response response : responses)
            if (response.is(type))
                return response.as();

        return null;
    }
}
