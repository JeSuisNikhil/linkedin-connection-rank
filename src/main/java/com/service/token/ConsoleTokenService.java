package com.service.token;

import java.util.Scanner;

import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

/**
 * A console token service. You will need to copy the URL printed and do the thing with the browser and then copy the authentication code and paste it
 * back here.
 *
 * @author nikhilagarwal
 */
public class ConsoleTokenService implements TokenService {

	public ConsoleTokenService() {
		super();
	}

	@Override
	public Token getToken(final OAuthService service) {

		final Token requestToken = service.getRequestToken();

		System.out.println("This service uses the scribe-java api for OAuth.\n"
				+ "Privacy Note: The service is stateless. In it's current form the service doesn't store or send the info to me or anyone.\n"
				+ "The information is printed to the console which is in your test environment.\n"
				+ "To authorize this service to get information from your profile,\n"
				+ "go to URL and paste the authentication code at the prompt:\n");
		System.out.println(service.getAuthorizationUrl(requestToken));

		System.out.print(">>");
		final Scanner in = new Scanner(System.in);
		final Verifier verifier = new Verifier(in.nextLine());
		System.out.println();

		return service.getAccessToken(requestToken, verifier);
	}
}