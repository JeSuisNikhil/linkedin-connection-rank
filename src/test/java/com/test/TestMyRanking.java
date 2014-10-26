package com.test;

import org.junit.Assert;
import org.junit.Test;

import com.model.Connections;
import com.model.Person;
import com.model.utils.ConnectionsParser;
import com.request.linkedin.LinkedInConnectionsRequest;
import com.request.linkedin.LinkedInProfileRequest;
import com.service.linkedin.LinkedInServiceBuilder;
import com.service.ranking.ConnectionRankService;
import com.service.ranking.ProximityBasedConnectionRankImpl;
import com.service.token.ConsoleTokenService;

public class TestMyRanking {

	@Test
	public void test() {
		try {
			final LinkedInProfileRequest linkedInProfileRequest = new LinkedInProfileRequest();
			final LinkedInConnectionsRequest linkedInConnectionsRequest = new LinkedInConnectionsRequest();

			LinkedInServiceBuilder.newLinkedInService().with(linkedInProfileRequest).with(linkedInConnectionsRequest).with(new ConsoleTokenService())
					.signAllRequests();

			final Person user = linkedInProfileRequest.getProfile();
			final Connections connections = linkedInConnectionsRequest.getConnections();

			final ConnectionRankService rankService = ProximityBasedConnectionRankImpl.getInstance();
			final Connections sortedConnections = rankService.sortedCopy(user, connections);

			System.out.println(ConnectionsParser.marshall(sortedConnections));

			final Person topContact = sortedConnections.getPersons().get(0);
			Assert.assertTrue("", topContact.getIndustry().equals(user.getIndustry()));
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail("Connection error");
		}
	}
}
