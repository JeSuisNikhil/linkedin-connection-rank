package com.cornholio.linkedin.connectionrank;

import org.junit.Assert;
import org.junit.Test;

import com.cornholio.linkedin.connectionrank.model.Person;
import com.cornholio.linkedin.connectionrank.model.utils.PersonParser;
import com.cornholio.linkedin.connectionrank.request.LinkedInProfileRequest;
import com.cornholio.linkedin.connectionrank.service.LinkedInServiceBuilder;
import com.cornholio.linkedin.connectionrank.service.token.ConsoleTokenService;

public class TestLinkedInProfileAPI {

	@Test
	public void test() {
		try {
			final LinkedInProfileRequest linkedInRequest = new LinkedInProfileRequest();
			LinkedInServiceBuilder.newLinkedInService().with(linkedInRequest).with(new ConsoleTokenService()).signAllRequests();

			final Person person = linkedInRequest.getProfile();
			System.out.println(PersonParser.marshall(person));

			Assert.assertTrue("No contacts found", (person != null) && (person.getFirstName() != null) && (person.getFirstName().length() > 0));
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail("Connection error");
		}
	}
}
