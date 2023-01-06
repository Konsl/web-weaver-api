package de.konsl.webweaverapi.messages.response.calendar;

import com.google.gson.JsonObject;
import de.konsl.webweaverapi.messages.response.Response;

public class GetEntriesResponse extends Response {
    private JsonObject unknown;

    public GetEntriesResponse() {
    }

    public JsonObject getUnknown() {
        return unknown;
    }

    @Override
    public void decode(JsonObject response) {
        unknown = response.deepCopy();
    }
}
