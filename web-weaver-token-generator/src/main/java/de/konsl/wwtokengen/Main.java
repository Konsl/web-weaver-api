package de.konsl.wwtokengen;

import de.konsl.webweaverapi.WebWeaverClient;
import de.konsl.webweaverapi.model.auth.CreateTrustInfo;
import de.konsl.webweaverapi.model.auth.Credentials;
import de.konsl.webweaverapi.model.auth.LoginResult;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("E-Mail: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Application: ");
        String application = scanner.nextLine();
        System.out.print("Identity: ");
        String identity = scanner.nextLine();
        if(identity.length() == 0)
            identity = null;

        WebWeaverClient client = new WebWeaverClient();
        Credentials credentials = new Credentials(email, password);
        LoginResult result = client.login(credentials, new CreateTrustInfo(title, application, identity));

        System.out.println("Token: \"" + result.getToken() + "\"");

        client.logout();
    }
}
