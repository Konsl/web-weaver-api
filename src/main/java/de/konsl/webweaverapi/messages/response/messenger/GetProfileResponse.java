package de.konsl.webweaverapi.messages.response.messenger;

import com.google.gson.JsonObject;
import de.konsl.webweaverapi.messages.response.Response;

public class GetProfileResponse extends Response {
    private JsonObject unknown;

    public GetProfileResponse() {
    }

    public JsonObject getUnknown() {
        return unknown;
    }

    @Override
    public void decode(JsonObject response) {
        unknown = response.deepCopy();
    }
}
