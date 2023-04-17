package de.konsl.webweaverapi.scopes;

import de.konsl.webweaverapi.WebWeaverClient;
import de.konsl.webweaverapi.WebWeaverException;
import de.konsl.webweaverapi.messages.request.calendar.GetEntriesRequest;
import de.konsl.webweaverapi.messages.response.calendar.GetEntriesResponse;
import de.konsl.webweaverapi.model.FocusObject;

import java.io.IOException;

public class CalendarScope extends Scope{
    public CalendarScope(WebWeaverClient client) {
        super(client);
    }

    public GetEntriesResponse getEntries() throws WebWeaverException, IOException {
        return getClient().request(new GetEntriesRequest(), FocusObject.CALENDAR, "2017b@manos-dresden.lernsax.de");
    }
}
