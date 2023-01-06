package de.konsl.webweaverapi.messages.request;

import com.google.gson.JsonObject;
import de.konsl.webweaverapi.messages.response.GetInformationResponse;

import java.util.function.Supplier;

public class GetInformationRequest extends Request<GetInformationResponse> {
    @Override
    public String getMethodID() {
        return "get_information";
    }

    @Override
    public JsonObject encodeParams() {
        return new JsonObject();
    }

    @Override
    public Supplier<GetInformationResponse> getResponseSupplier() {
        return GetInformationResponse::new;
    }
}
