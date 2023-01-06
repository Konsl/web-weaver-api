package de.konsl.webweaverapi.messages.request;

import com.google.gson.JsonObject;
import de.konsl.webweaverapi.messages.response.LoginResponse;
import de.konsl.webweaverapi.model.auth.DigestAlgorithm;

import java.util.function.Supplier;

public class LoginRequest extends Request<LoginResponse> {
    public static final int TYPE_PASSWORD = 0;
    public static final int TYPE_TRUST = 1;

    private int type;
    private String email;
    private String password;
    private DigestAlgorithm algorithm;
    private String nonceID;
    private String salt;
    private String hash;
    private String application;

    public LoginRequest(String email, String password){
        type = TYPE_PASSWORD;

        this.email = email;
        this.password = password;
    }

    public LoginRequest(String email, DigestAlgorithm algorithm, String nonceID, String salt, String hash, String application) {
        type = TYPE_TRUST;

        this.email = email;
        this.algorithm = algorithm;
        this.nonceID = nonceID;
        this.salt = salt;
        this.hash = hash;
        this.application = application;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DigestAlgorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(DigestAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String getNonceID() {
        return nonceID;
    }

    public void setNonceID(String nonceID) {
        this.nonceID = nonceID;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    @Override
    public String getMethodID() {
        return "login";
    }

    @Override
    public JsonObject encodeParams() {
        JsonObject obj = new JsonObject();

        if (type == TYPE_PASSWORD) {
            obj.addProperty("login", email);
            obj.addProperty("password", password);
        }
        if(type == TYPE_TRUST){
            obj.addProperty("login", email);
            obj.addProperty("algorithm", algorithm.getValue());
            obj.addProperty("nonce_id", nonceID);
            obj.addProperty("salt", salt);
            obj.addProperty("hash", hash);
            obj.addProperty("application", application);
        }

        return obj;
    }

    @Override
    public Supplier<LoginResponse> getResponseSupplier() {
        return LoginResponse::new;
    }
}
