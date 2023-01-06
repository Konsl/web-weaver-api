package de.konsl.webweaverapi.messages.request.calendar;

import com.google.gson.JsonObject;
import de.konsl.webweaverapi.messages.request.Request;
import de.konsl.webweaverapi.messages.response.calendar.GetEntriesResponse;

import java.util.function.Supplier;

public class GetEntriesRequest extends Request<GetEntriesResponse> {
    @Override
    public String getMethodID() {
        return "get_entries";
    }

    @Override
    public JsonObject encodeParams() {
        return new JsonObject();
    }

    @Override
    public Supplier<GetEntriesResponse> getResponseSupplier() {
        return GetEntriesResponse::new;
    }
}
