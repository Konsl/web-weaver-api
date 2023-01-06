package de.konsl.webweaverapi.model.user;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class MemberInfo {
    private String login;
    private String name;
    private int type;
    private List<Right> baseRights;
    private List<Right> memberRights;
    private List<Right> effectiveRights;

    public MemberInfo() {
        login = "";
        name = "";
        type = 0;
        baseRights = new ArrayList<>();
        memberRights = new ArrayList<>();
        effectiveRights = new ArrayList<>();
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

    public List<Right> getBaseRights() {
        return baseRights;
    }

    public List<Right> getMemberRights() {
        return memberRights;
    }

    public List<Right> getEffectiveRights() {
        return effectiveRights;
    }

    public static MemberInfo decode(JsonObject json) {
        MemberInfo info = new MemberInfo();
        info.setLogin(json.get("login").getAsString());
        info.setName(json.get("name_hr").getAsString());
        info.setType(json.get("type").getAsInt());
        info.baseRights = StreamSupport.stream(json.get("base_rights").getAsJsonArray().spliterator(), false)
                .map(v -> Right.of(v.getAsString())).toList();
        info.memberRights = StreamSupport.stream(json.get("member_rights").getAsJsonArray().spliterator(), false)
                .map(v -> Right.of(v.getAsString())).toList();
        info.effectiveRights = StreamSupport.stream(json.get("effective_rights").getAsJsonArray().spliterator(), false)
                .map(v -> Right.of(v.getAsString())).toList();
        return info;
    }
}
