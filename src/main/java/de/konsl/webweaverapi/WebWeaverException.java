package de.konsl.webweaverapi;

import de.konsl.webweaverapi.messages.response.ErrorResponse;

import java.lang.Exception;

public class WebWeaverException extends Exception {
    private final ErrorResponse response;

    public WebWeaverException(ErrorResponse response) {
        this.response = response;
    }

    public WebWeaverException(String message, ErrorResponse response) {
        super(message);
        this.response = response;
    }

    public WebWeaverException(String message, Throwable cause, ErrorResponse response) {
        super(message, cause);
        this.response = response;
    }

    public WebWeaverException(Throwable cause, ErrorResponse response) {
        super(cause);
        this.response = response;
    }

    public WebWeaverException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorResponse response) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.response = response;
    }

    public ErrorResponse getResponse() {
        return response;
    }
}
