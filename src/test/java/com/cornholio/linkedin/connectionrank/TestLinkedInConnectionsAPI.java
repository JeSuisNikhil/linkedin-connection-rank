package com.cornholio.linkedin.connectionrank;

import org.junit.Assert;
import org.junit.Test;

import com.cornholio.linkedin.connectionrank.model.Connections;
import com.cornholio.linkedin.connectionrank.model.utils.ConnectionsParser;
import com.cornholio.linkedin.connectionrank.request.LinkedInConnectionsRequest;
import com.cornholio.linkedin.connectionrank.service.LinkedInServiceBuilder;
import com.cornholio.linkedin.connectionrank.service.token.ConsoleTokenService;

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
