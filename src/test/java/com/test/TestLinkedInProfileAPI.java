package com.test;

import org.junit.Assert;
import org.junit.Test;

import com.model.Person;
import com.model.utils.PersonParser;
import com.request.linkedin.LinkedInProfileRequest;
import com.service.linkedin.LinkedInServiceBuilder;
import com.service.token.ConsoleTokenService;

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
