package de.konsl.webweaverapi.scopes;

import de.konsl.webweaverapi.WebWeaverClient;
import de.konsl.webweaverapi.WebWeaverException;
import de.konsl.webweaverapi.messages.request.messages.GetMessagesRequest;
import de.konsl.webweaverapi.model.FocusObject;
import de.konsl.webweaverapi.model.messages.Message;

import java.util.List;

public class MessagesScope extends Scope {
    public MessagesScope(WebWeaverClient client) {
        super(client);
    }

    public List<Message> getMessages() throws WebWeaverException {
        return getMessages(true, null);
    }

    public List<Message> getMessages(boolean peek) throws WebWeaverException {
        return getMessages(peek, null);
    }

    public List<Message> getMessages(Integer startID) throws WebWeaverException {
        return getMessages(true, startID);
    }

    public List<Message> getMessages(boolean peek, Integer startID) throws WebWeaverException {
        return getClient().request(new GetMessagesRequest(peek, startID), FocusObject.MESSAGES).getMessages();
    }
}
