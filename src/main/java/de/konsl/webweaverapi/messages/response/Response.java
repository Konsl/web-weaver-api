package de.konsl.webweaverapi.messages.response;

import com.google.gson.JsonObject;

public abstract class Response {
    public Response() {
    }

    public abstract void decode(JsonObject response);

    @SuppressWarnings("unchecked")
    public <T extends Response> T as() {
        try {
            return (T) this;
        } catch (ClassCastException e) {
            return null;
        }
    }

    public boolean is(Class<? extends Response> type) {
        return type.isInstance(this);
    }

    public boolean isError() {
        return false;
    }
}
