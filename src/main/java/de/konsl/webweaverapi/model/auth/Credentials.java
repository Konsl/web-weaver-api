package de.konsl.webweaverapi.model.auth;

import de.konsl.webweaverapi.WebWeaverClient;
import de.konsl.webweaverapi.messages.request.LoginRequest;
import de.konsl.webweaverapi.messages.response.GetNonceResponse;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Formatter;

public class Credentials {
    public static final int TYPE_PASSWORD = 0;
    public static final int TYPE_TRUST = 1;

    private int type;
    private String email;
    private String password;
    private String token;
    private String application;

    public Credentials(String email, String password) {
        type = TYPE_PASSWORD;

        this.email = email;
        this.password = password;
    }

    public Credentials(String email, String token, String application) {
        type = TYPE_TRUST;

        this.email = email;
        this.token = token;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public LoginRequest encode(WebWeaverClient client) {
        if (type == TYPE_PASSWORD) {
            return new LoginRequest(email, password);
        }
        if (type == TYPE_TRUST) {
            try {
                GetNonceResponse nonce = client.getNonce();
                assert nonce != null;

                StringBuilder salt = new StringBuilder();
                char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
                SecureRandom random = new SecureRandom();
                int size = random.nextInt(5) + 8;
                for (int i = 0; i < size; i++)
                    salt.append(chars[random.nextInt(chars.length)]);

                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                digest.reset();
                digest.update((nonce.getKey() + salt + token).getBytes(StandardCharsets.UTF_8));
                byte[] hash = digest.digest();
                Formatter formatter = new Formatter();
                for (byte b : hash) formatter.format("%02x", b);

                return new LoginRequest(email, DigestAlgorithm.SHA256, nonce.getID(), salt.toString(), formatter.toString(), application);
            } catch (NoSuchAlgorithmException ignored) {
            }
        }

        return null;
    }
}
