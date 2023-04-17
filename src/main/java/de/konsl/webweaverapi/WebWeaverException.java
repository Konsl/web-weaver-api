package de.konsl.webweaverapi;

import de.konsl.webweaverapi.messages.response.Response;

import java.util.List;

public class WebWeaverException extends Exception {
    private final List<Response> responses;

    public WebWeaverException(List<Response> responses) {
        this.responses = responses;
    }

    public WebWeaverException(String message, List<Response> responses) {
        super(message);
        this.responses = responses;
    }

    public WebWeaverException(String message, Throwable cause, List<Response> responses) {
        super(message, cause);
        this.responses = responses;
    }

    public WebWeaverException(Throwable cause, List<Response> responses) {
        super(cause);
        this.responses = responses;
    }

    public WebWeaverException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, List<Response> responses) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.responses = responses;
    }

    public List<Response> getResponses() {
        return responses;
    }
}
