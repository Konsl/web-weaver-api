package de.konsl.webweaverapi.messages.response.messages;

import com.google.gson.JsonObject;
import de.konsl.webweaverapi.messages.response.Response;
import de.konsl.webweaverapi.model.messages.Message;

import java.util.List;
import java.util.stream.StreamSupport;

public class GetMessagesResponse extends Response {

    private List<Message> messages;

    public GetMessagesResponse() {
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public void decode(JsonObject response) {
        messages = StreamSupport.stream(response.get("messages").getAsJsonArray().spliterator(), false)
                .map(e -> Message.decode(e.getAsJsonObject())).toList();
    }
}
