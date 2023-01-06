package de.konsl.webweaverapi.model.auth;

public class CreateTrustInfo {
    private String title;
    private String application;
    private String identity;

    public CreateTrustInfo(String title, String application, String identity) {
        this.title = title;
        this.application = application;
        this.identity = identity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
