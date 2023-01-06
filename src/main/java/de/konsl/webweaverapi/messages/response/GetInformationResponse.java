package de.konsl.webweaverapi.messages.response;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class GetInformationResponse extends Response{
    private String sessionID;
    private String serverVersion;
    private String clientVersion;
    private String clientURL;
    private long postMaxSize;
    private String timezone;
    private String locale;
    private String customTranslationsURL;
    private String customSkinningURL;
    private List<Integer> adminTypes;

    public GetInformationResponse() {
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getServerVersion() {
        return serverVersion;
    }

    public void setServerVersion(String serverVersion) {
        this.serverVersion = serverVersion;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public String getClientURL() {
        return clientURL;
    }

    public void setClientURL(String clientURL) {
        this.clientURL = clientURL;
    }

    public long getPostMaxSize() {
        return postMaxSize;
    }

    public void setPostMaxSize(long postMaxSize) {
        this.postMaxSize = postMaxSize;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getCustomTranslationsURL() {
        return customTranslationsURL;
    }

    public void setCustomTranslationsURL(String customTranslationsURL) {
        this.customTranslationsURL = customTranslationsURL;
    }

    public String getCustomSkinningURL() {
        return customSkinningURL;
    }

    public void setCustomSkinningURL(String customSkinningURL) {
        this.customSkinningURL = customSkinningURL;
    }

    public List<Integer> getAdminTypes() {
        return adminTypes;
    }

    public void setAdminTypes(List<Integer> adminTypes) {
        this.adminTypes = adminTypes;
    }

    @Override
    public void decode(JsonObject response) {
        sessionID = response.get("session_id").getAsString();
        serverVersion = response.get("server_version").getAsString();
        clientVersion = response.get("client_version").getAsString();
        clientURL = response.get("client_url").getAsString();
        postMaxSize = response.get("post_max_size").getAsLong();
        timezone = response.get("timezone").getAsString();
        locale = response.get("locale").getAsString();
        customTranslationsURL = response.get("custom_translations_url").getAsString();
        customSkinningURL = response.get("custom_skinning_url").getAsString();
        adminTypes = new ArrayList<>();
        for(JsonElement entry : response.get("admin_types").getAsJsonArray()){
            adminTypes.add(entry.getAsInt());
        }
    }
}
