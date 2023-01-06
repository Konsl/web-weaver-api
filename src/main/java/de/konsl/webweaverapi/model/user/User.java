package de.konsl.webweaverapi.model.user;

import com.google.gson.JsonObject;

public class User {
    private String login;
    private String name;
    private int type;
    private Boolean isOnline;
    private Miniature miniature;

    public User() {
        login = "";
        name = "";
        type = 0;
        isOnline = null;
        miniature = null;
    }

    public User(String login, String name, int type, Boolean isOnline, Miniature miniature) {
        this.login = login;
        this.name = name;
        this.type = type;
        this.isOnline = isOnline;
        this.miniature = miniature;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }

    public Miniature getMiniature() {
        return miniature;
    }

    public void setMiniature(Miniature miniature) {
        this.miniature = miniature;
    }

    public static User decode(JsonObject json) {
        return new User(
                json.get("login").getAsString(),
                json.get("name_hr").getAsString(),
                json.get("type").getAsInt(),
                json.has("is_online") ? json.get("is_online").getAsInt() != 0 : null,
                json.has("miniature") ? Miniature.decode(json.get("miniature").getAsJsonObject()) : null
        );
    }
}
