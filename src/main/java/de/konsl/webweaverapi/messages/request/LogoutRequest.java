package de.konsl.webweaverapi.messages.request;

import com.google.gson.JsonObject;
import de.konsl.webweaverapi.messages.response.LogoutResponse;

import java.util.function.Supplier;

public class LogoutRequest extends Request<LogoutResponse> {
    @Override
    public String getMethodID() {
        return "logout";
    }

    @Override
    public JsonObject encodeParams() {
        return new JsonObject();
    }

    @Override
    public Supplier<LogoutResponse> getResponseSupplier() {
        return LogoutResponse::new;
    }
}
