package de.konsl.webweaverapi.scopes;

import de.konsl.webweaverapi.WebWeaverClient;

public abstract class Scope {
    private final WebWeaverClient client;

    public Scope(WebWeaverClient client) {
        this.client = client;
    }

    public WebWeaverClient getClient() {
        return client;
    }
}
