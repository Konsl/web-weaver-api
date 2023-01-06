package de.konsl.webweaverapi.messages.request;

import com.google.gson.JsonObject;
import de.konsl.webweaverapi.messages.response.SetSessionResponse;

import java.util.function.Supplier;

public class SetSessionRequest extends Request<SetSessionResponse> {
    private String sessionID;

    public SetSessionRequest(String sessionID){
        this.sessionID = sessionID;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    @Override
    public String getMethodID() {
        return "set_session";
    }

    @Override
    public JsonObject encodeParams() {
        JsonObject obj = new JsonObject();
        obj.addProperty("session_id", sessionID);
        return obj;
    }

    @Override
    public Supplier<SetSessionResponse> getResponseSupplier() {
        return SetSessionResponse::new;
    }
}
