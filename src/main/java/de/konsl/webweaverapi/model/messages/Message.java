package de.konsl.webweaverapi.model.messages;

import com.google.gson.JsonObject;
import de.konsl.webweaverapi.model.user.User;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;

public class Message {
    private String id;
    private MessageType type;
    private OffsetDateTime date;
    private String message;
    private String data;
    private User fromUser;
    private User fromGroup;
    private boolean isUnread;
    private String object;

    public Message() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getFromGroup() {
        return fromGroup;
    }

    public void setFromGroup(User fromGroup) {
        this.fromGroup = fromGroup;
    }

    public boolean isUnread() {
        return isUnread;
    }

    public void setUnread(boolean unread) {
        isUnread = unread;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public static Message decode(JsonObject json) {
        Message msg = new Message();

        msg.id = json.get("id").getAsString();
        msg.type = MessageType.of(json.get("message").getAsString());
        msg.date = OffsetDateTime.ofInstant(Instant.ofEpochSecond(
                Integer.parseInt(json.get("date").getAsString())
        ), ZoneId.systemDefault());
        msg.message = json.get("message_hr").getAsString();
        msg.data = json.get("data").getAsString();
        msg.fromUser = User.decode(json.get("from_user").getAsJsonObject());
        msg.fromGroup = User.decode(json.get("from_group").getAsJsonObject());
        msg.isUnread = json.get("is_unread").getAsInt() != 0;
        msg.object = json.get("object").getAsString();

        return msg;
    }
}
