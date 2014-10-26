package com.test;

import org.junit.Assert;
import org.junit.Test;

import com.model.Connections;
import com.model.utils.ConnectionsParser;
import com.request.linkedin.LinkedInConnectionsRequest;
import com.service.linkedin.LinkedInServiceBuilder;
import com.service.token.ConsoleTokenService;

public class TestLinkedInConnectionsAPI {

	@Test
	public void test() {
		try {
			final LinkedInConnectionsRequest linkedInRequest = new LinkedInConnectionsRequest();
			LinkedInServiceBuilder.newLinkedInService().with(linkedInRequest).with(new ConsoleTokenService()).signAllRequests();

			final Connections connections = linkedInRequest.getConnections();
			System.out.println(ConnectionsParser.marshall(connections));

			Assert.assertTrue("No contacts found", connections.getPersons().size() > 0);
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail("Connection error");
		}
	}
}
