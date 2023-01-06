package de.konsl.webweaverapi.messages.response;

import com.google.gson.JsonObject;

public class GetNonceResponse extends Response {
    private String id;
    private String key;

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public void decode(JsonObject response) {
        id = response.getAsJsonObject("nonce").get("id").getAsString();
        key = response.getAsJsonObject("nonce").get("key").getAsString();
    }
}
