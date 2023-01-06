package de.konsl.webweaverapi.messages.request;

import com.google.gson.JsonObject;
import de.konsl.webweaverapi.messages.response.SetFocusResponse;
import de.konsl.webweaverapi.model.FocusObject;

import java.util.function.Supplier;

public class SetFocusRequest extends Request<SetFocusResponse> {

    private FocusObject object;
    private String login;
    private String uid;

    public SetFocusRequest(FocusObject object) {
        this.object = object;
        this.login = null;
        this.uid = null;
    }

    public SetFocusRequest(FocusObject object, String login) {
        this.object = object;
        this.login = login;
        this.uid = null;
    }

    public SetFocusRequest(FocusObject object, String login, String uid) {
        this.object = object;
        this.login = login;
        this.uid = uid;
    }

    public FocusObject getObject() {
        return object;
    }

    public void setObject(FocusObject object) {
        this.object = object;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String getMethodID() {
        return "set_focus";
    }

    @Override
    public JsonObject encodeParams() {
        JsonObject obj = new JsonObject();

        obj.addProperty("object", object.getValue());

        if (login != null)
            obj.addProperty("login", login);
        if (uid != null)
            obj.addProperty("uid", uid);

        return obj;
    }

    @Override
    public Supplier<SetFocusResponse> getResponseSupplier() {
        return SetFocusResponse::new;
    }
}
