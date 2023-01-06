package de.konsl.webweaverapi.messages.request;

import com.google.gson.JsonObject;
import de.konsl.webweaverapi.messages.response.RegisterMasterResponse;

import java.util.function.Supplier;

public class RegisterMasterRequest extends Request<RegisterMasterResponse> {

    private String remoteTitle;
    private String remoteApplication;
    private String remoteIdentity;

    public RegisterMasterRequest(String remoteTitle, String remoteApplication, String remoteIdentity) {
        this.remoteTitle = remoteTitle;
        this.remoteApplication = remoteApplication;
        this.remoteIdentity = remoteIdentity;
    }

    public String getRemoteTitle() {
        return remoteTitle;
    }

    public void setRemoteTitle(String remoteTitle) {
        this.remoteTitle = remoteTitle;
    }

    public String getRemoteApplication() {
        return remoteApplication;
    }

    public void setRemoteApplication(String remoteApplication) {
        this.remoteApplication = remoteApplication;
    }

    public String getRemoteIdentity() {
        return remoteIdentity;
    }

    public void setRemoteIdentity(String remoteIdentity) {
        this.remoteIdentity = remoteIdentity;
    }

    @Override
    public String getMethodID() {
        return "register_master";
    }

    @Override
    public JsonObject encodeParams() {
        JsonObject obj = new JsonObject();

        obj.addProperty("remote_title", remoteTitle);
        obj.addProperty("remote_application", remoteApplication);

        if(remoteIdentity != null)
            obj.addProperty("remote_ident", remoteIdentity);

        return obj;
    }

    @Override
    public Supplier<RegisterMasterResponse> getResponseSupplier() {
        return RegisterMasterResponse::new;
    }
}
