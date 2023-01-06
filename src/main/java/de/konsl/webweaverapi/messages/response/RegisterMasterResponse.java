package de.konsl.webweaverapi.messages.response;

import com.google.gson.JsonObject;

public class RegisterMasterResponse extends Response{
    private String token;

    public RegisterMasterResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public void decode(JsonObject response) {
        token = response.get("trust").getAsJsonObject().get("token").getAsString();
    }
}
