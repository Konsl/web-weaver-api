package de.konsl.webweaverapi.messages.request.messenger;

import com.google.gson.JsonObject;
import de.konsl.webweaverapi.messages.request.Request;
import de.konsl.webweaverapi.messages.response.messenger.GetProfileResponse;

import java.util.function.Supplier;

public class GetProfileRequest extends Request<GetProfileResponse> {
    private final String login;
    private final Boolean exportImage;

    public GetProfileRequest() {
        this.login = null;
        this.exportImage = null;
    }

    public GetProfileRequest(String login) {
        this.login = login;
        this.exportImage = null;
    }

    public GetProfileRequest(String login, Boolean exportImage) {
        this.login = login;
        this.exportImage = exportImage;
    }

    @Override
    public String getMethodID() {
        return "get_profile";
    }

    @Override
    public JsonObject encodeParams() {
        JsonObject obj = new JsonObject();

        obj.addProperty("login", login);

        if (exportImage != null)
            obj.addProperty("export_image", exportImage);

        return obj;
    }

    @Override
    public Supplier<GetProfileResponse> getResponseSupplier() {
        return GetProfileResponse::new;
    }
}
