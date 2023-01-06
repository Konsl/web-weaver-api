package de.konsl.webweaverapi.scopes;

import de.konsl.webweaverapi.WebWeaverClient;
import de.konsl.webweaverapi.WebWeaverException;
import de.konsl.webweaverapi.messages.request.messenger.GetProfileRequest;
import de.konsl.webweaverapi.messages.response.messenger.GetProfileResponse;
import de.konsl.webweaverapi.model.FocusObject;

public class MessengerScope extends Scope {
    public MessengerScope(WebWeaverClient client) {
        super(client);
    }

    public GetProfileResponse getProfile(String login) throws WebWeaverException {
        return getClient().request(new GetProfileRequest(login), FocusObject.MESSENGER);
    }
}
