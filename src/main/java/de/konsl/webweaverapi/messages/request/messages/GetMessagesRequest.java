package de.konsl.webweaverapi.messages.request.messages;

import com.google.gson.JsonObject;
import de.konsl.webweaverapi.messages.request.Request;
import de.konsl.webweaverapi.messages.response.messages.GetMessagesResponse;

import java.util.function.Supplier;

public class GetMessagesRequest extends Request<GetMessagesResponse> {

    private boolean peek;
    private Integer startID;

    public GetMessagesRequest(boolean peek) {
        this.peek = peek;
        this.startID = null;
    }

    public GetMessagesRequest(boolean peek, Integer startID) {
        this.peek = peek;
        this.startID = startID;
    }

    public boolean getPeek() {
        return peek;
    }

    public void setPeek(boolean peek) {
        this.peek = peek;
    }

    public Integer getStartID() {
        return startID;
    }

    public void setStartID(Integer startID) {
        this.startID = startID;
    }

    @Override
    public String getMethodID() {
        return "get_messages";
    }

    @Override
    public JsonObject encodeParams() {
        JsonObject obj = new JsonObject();

        obj.addProperty("peek", peek);

        if(startID != null)
            obj.addProperty("start_id", startID);

        return obj;
    }

    @Override
    public Supplier<GetMessagesResponse> getResponseSupplier() {
        return GetMessagesResponse::new;
    }
}
