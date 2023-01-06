package de.konsl.webweaverapi.messages.response.members;

import com.google.gson.JsonObject;
import de.konsl.webweaverapi.messages.response.Response;
import de.konsl.webweaverapi.model.user.User;

import java.util.List;
import java.util.stream.StreamSupport;

public class GetUsersResponse extends Response {
    private List<User> users;

    public GetUsersResponse() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public void decode(JsonObject response) {
        users = StreamSupport.stream(response.get("users").getAsJsonArray().spliterator(), false)
                .map(u -> User.decode(u.getAsJsonObject())).toList();
    }
}
