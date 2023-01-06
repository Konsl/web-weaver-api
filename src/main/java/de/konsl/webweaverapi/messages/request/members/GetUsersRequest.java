package de.konsl.webweaverapi.messages.request.members;

import com.google.gson.JsonObject;
import de.konsl.webweaverapi.messages.request.Request;
import de.konsl.webweaverapi.messages.response.members.GetUsersResponse;

import java.util.function.Supplier;

public class GetUsersRequest extends Request<GetUsersResponse> {
    private boolean onlyOnline;
    private boolean getMiniatures;

    public GetUsersRequest() {
        this.onlyOnline = false;
        this.getMiniatures = false;
    }

    public GetUsersRequest(boolean onlyOnline, boolean getMiniatures) {
        this.onlyOnline = onlyOnline;
        this.getMiniatures = getMiniatures;
    }

    public boolean getOnlyOnline() {
        return onlyOnline;
    }

    public void setOnlyOnline(boolean onlyOnline) {
        this.onlyOnline = onlyOnline;
    }

    public boolean getGetMiniatures() {
        return getMiniatures;
    }

    public void setGetMiniatures(boolean getMiniatures) {
        this.getMiniatures = getMiniatures;
    }

    @Override
    public String getMethodID() {
        return "get_users";
    }

    @Override
    public JsonObject encodeParams() {
        JsonObject obj = new JsonObject();

        if (onlyOnline)
            obj.addProperty("only_online", true);
        if (getMiniatures)
            obj.addProperty("get_miniatures", true);

        return obj;
    }

    @Override
    public Supplier<GetUsersResponse> getResponseSupplier() {
        return GetUsersResponse::new;
    }
}
