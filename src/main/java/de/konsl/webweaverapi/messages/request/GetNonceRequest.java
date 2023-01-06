package de.konsl.webweaverapi.messages.request;

import com.google.gson.JsonObject;
import de.konsl.webweaverapi.messages.response.GetNonceResponse;

import java.util.function.Supplier;

public class GetNonceRequest extends Request<GetNonceResponse> {
    @Override
    public String getMethodID() {
        return "get_nonce";
    }

    @Override
    public JsonObject encodeParams() {
        return new JsonObject();
    }

    @Override
    public Supplier<GetNonceResponse> getResponseSupplier() {
        return GetNonceResponse::new;
    }
}
