package de.konsl.webweaverapi.messages.request;

import com.google.gson.JsonObject;
import de.konsl.webweaverapi.messages.response.Response;

import java.util.function.Supplier;

public abstract class Request<T extends Response> {
    public abstract String getMethodID();
    public abstract JsonObject encodeParams();

    public abstract Supplier<T> getResponseSupplier();
}
