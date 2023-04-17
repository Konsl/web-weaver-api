package de.konsl.webweaverapi.messages.response;

import com.google.gson.JsonObject;

public class ErrorResponse extends Response {
    private String method;
    private String returnCode;
    private String error;
    private String errno;

    public ErrorResponse() {
        method = "";
        returnCode = "";
        error = "";
        errno = "";
    }

    public ErrorResponse(String method, String returnCode, String error, String errno) {
        this.method = method;
        this.returnCode = returnCode;
        this.error = error;
        this.errno = errno;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrno() {
        return errno;
    }

    public void setErrno(String errno) {
        this.errno = errno;
    }

    @Override
    public void decode(JsonObject response) {
        if (response.has("method"))
            method = response.get("method").getAsString();
        else method = "";

        returnCode = response.get("return").getAsString();
        error = response.get("error").getAsString();
        errno = response.get("errno").getAsString();
    }

    @Override
    public boolean isError() {
        return true;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "method='" + method + '\'' +
                ", returnCode='" + returnCode + '\'' +
                ", error='" + error + '\'' +
                ", errno='" + errno + '\'' +
                '}';
    }
}
