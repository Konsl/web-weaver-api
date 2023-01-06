package de.konsl.webweaverapi.model.auth;

import de.konsl.webweaverapi.messages.response.LoginResponse;

public class LoginResult {
    private LoginResponse response;
    private String token;

    public LoginResult(LoginResponse response, String token) {
        this.response = response;
        this.token = token;
    }

    public LoginResponse getResponse() {
        return response;
    }

    public void setResponse(LoginResponse response) {
        this.response = response;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
