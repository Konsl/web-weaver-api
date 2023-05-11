package de.konsl.webweaverapi.messages.request;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.konsl.webweaverapi.messages.response.AutologinResponse;

import java.util.function.Supplier;

public class SelfAutologinRequest extends Request<AutologinResponse> {
    private Boolean disableLogout;
    private Boolean disableReceptionOfQuickMessages;
    private String locale;
    private Boolean pingMaster;
    private Boolean secondarySession;
    private Integer sessionTimeout;
    private JsonElement targetData;
    private Boolean targetIframes;
    private String targetLogin;
    private String targetObject;
    private String targetOpen;
    private String targetUrlPath;

    public SelfAutologinRequest() {
    }

    public SelfAutologinRequest(String targetLogin, String targetObject, String targetOpen) {
        this.targetLogin = targetLogin;
        this.targetObject = targetObject;
        this.targetOpen = targetOpen;
    }

    public Boolean getDisableLogout() {
        return disableLogout;
    }

    public void setDisableLogout(Boolean disableLogout) {
        this.disableLogout = disableLogout;
    }

    public Boolean getDisableReceptionOfQuickMessages() {
        return disableReceptionOfQuickMessages;
    }

    public void setDisableReceptionOfQuickMessages(Boolean disableReceptionOfQuickMessages) {
        this.disableReceptionOfQuickMessages = disableReceptionOfQuickMessages;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Boolean getPingMaster() {
        return pingMaster;
    }

    public void setPingMaster(Boolean pingMaster) {
        this.pingMaster = pingMaster;
    }

    public Boolean getSecondarySession() {
        return secondarySession;
    }

    public void setSecondarySession(Boolean secondarySession) {
        this.secondarySession = secondarySession;
    }

    public Integer getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Integer sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public JsonElement getTargetData() {
        return targetData;
    }

    public void setTargetData(JsonElement targetData) {
        this.targetData = targetData;
    }

    public Boolean getTargetIframes() {
        return targetIframes;
    }

    public void setTargetIframes(Boolean targetIframes) {
        this.targetIframes = targetIframes;
    }

    public String getTargetLogin() {
        return targetLogin;
    }

    public void setTargetLogin(String targetLogin) {
        this.targetLogin = targetLogin;
    }

    public String getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(String targetObject) {
        this.targetObject = targetObject;
    }

    public String getTargetOpen() {
        return targetOpen;
    }

    public void setTargetOpen(String targetOpen) {
        this.targetOpen = targetOpen;
    }

    public String getTargetUrlPath() {
        return targetUrlPath;
    }

    public void setTargetUrlPath(String targetUrlPath) {
        this.targetUrlPath = targetUrlPath;
    }

    @Override
    public String getMethodID() {
        return "get_url_for_autologin";
    }

    @Override
    public JsonObject encodeParams() {
        JsonObject obj = new JsonObject();

        if (disableLogout != null) obj.addProperty("disable_logout", disableLogout);
        if (disableReceptionOfQuickMessages != null)
            obj.addProperty("disable_reception_of_quick_messages", disableReceptionOfQuickMessages);
        if (locale != null) obj.addProperty("locale", locale);
        if (pingMaster != null) obj.addProperty("ping_master", pingMaster);
        if (secondarySession != null) obj.addProperty("secondary_session", secondarySession);
        if (sessionTimeout != null) obj.addProperty("session_timeout", sessionTimeout);
        if (targetData != null) obj.add("target_data", targetData);
        if (targetIframes != null) obj.addProperty("target_iframes", targetIframes);
        if (targetLogin != null) obj.addProperty("target_login", targetLogin);
        if (targetObject != null) obj.addProperty("target_object", targetObject);
        if (targetOpen != null) obj.addProperty("target_open", targetOpen);
        if (targetUrlPath != null) obj.addProperty("target_url_path", targetUrlPath);

        return obj;
    }

    @Override
    public Supplier<AutologinResponse> getResponseSupplier() {
        return AutologinResponse::new;
    }
}
