package de.konsl.webweaverapi.messages.response;

import com.google.gson.JsonObject;

public class AutologinResponse extends Response {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void decode(JsonObject response) {
        url = response.getAsJsonObject().get("url").getAsString();
    }
}
