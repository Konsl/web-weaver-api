package de.konsl.webweaverapi.messages.response;

import com.google.gson.JsonObject;
import de.konsl.webweaverapi.model.GTAC;
import de.konsl.webweaverapi.model.user.MemberInfo;
import de.konsl.webweaverapi.model.user.Right;
import de.konsl.webweaverapi.model.user.User;

import java.util.List;
import java.util.stream.StreamSupport;

public class LoginResponse extends Response {
    private String login;
    private String name;
    private int type;
    private List<Right> baseRights;
    private User baseUser;
    private String fullName;
    private GTAC gtac;
    private boolean passwordMustChange;
    private List<Right> effectiveRights;
    private List<MemberInfo> member;

    public LoginResponse() {
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

    public void setBaseRights(List<Right> baseRights) {
        this.baseRights = baseRights;
    }

    public User getBaseUser() {
        return baseUser;
    }

    public void setBaseUser(User baseUser) {
        this.baseUser = baseUser;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public GTAC getGTAC() {
        return gtac;
    }

    public void setGTAC(GTAC gtac) {
        this.gtac = gtac;
    }

    public boolean getPasswordMustChange() {
        return passwordMustChange;
    }

    public void setPasswordMustChange(boolean passwordMustChange) {
        this.passwordMustChange = passwordMustChange;
    }

    public List<Right> getEffectiveRights() {
        return effectiveRights;
    }

    public void setEffectiveRights(List<Right> effectiveRights) {
        this.effectiveRights = effectiveRights;
    }

    public List<MemberInfo> getMember() {
        return member;
    }

    public void setMember(List<MemberInfo> member) {
        this.member = member;
    }

    @Override
    public void decode(JsonObject response) {
        JsonObject userObj = response.get("user").getAsJsonObject();
        login = userObj.get("login").getAsString();
        name = userObj.get("name_hr").getAsString();
        type = userObj.get("type").getAsInt();
        baseRights = StreamSupport.stream(userObj.get("base_rights").getAsJsonArray().spliterator(), false)
                .map(v -> Right.of(v.getAsString())).toList();
        baseUser = User.decode(userObj.get("base_user").getAsJsonObject());
        fullName = userObj.get("fullname").getAsString();
        gtac = GTAC.decode(userObj.get("gtac").getAsJsonObject());
        passwordMustChange = userObj.get("password_must_change").getAsInt() != 0;
        effectiveRights = StreamSupport.stream(userObj.get("effective_rights").getAsJsonArray().spliterator(), false)
                .map(v -> Right.of(v.getAsString())).toList();

        member = StreamSupport.stream(response.get("member").getAsJsonArray().spliterator(), false)
                .map(e -> MemberInfo.decode(e.getAsJsonObject())).toList();
    }
}
