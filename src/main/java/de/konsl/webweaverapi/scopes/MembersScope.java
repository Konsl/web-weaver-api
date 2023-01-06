package de.konsl.webweaverapi.scopes;

import de.konsl.webweaverapi.WebWeaverClient;
import de.konsl.webweaverapi.WebWeaverException;
import de.konsl.webweaverapi.messages.request.members.GetUsersRequest;
import de.konsl.webweaverapi.model.FocusObject;
import de.konsl.webweaverapi.model.user.User;

import java.util.List;

public class MembersScope extends Scope {

    private String login;

    public MembersScope(WebWeaverClient client, String login) {
        super(client);

        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<User> getUsers() throws WebWeaverException {
        return getUsers(false, false);
    }

    public List<User> getUsers(boolean onlyOnline) throws WebWeaverException {
        return getUsers(false, onlyOnline);
    }

    public List<User> getUsers(boolean onlyOnline, boolean getMiniatures) throws WebWeaverException {
        return getClient().request(new GetUsersRequest(onlyOnline, getMiniatures), FocusObject.MEMBERS, login).getUsers();
    }
}
