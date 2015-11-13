package com.cornholio.linkedin.connectionrank;

import org.junit.Assert;
import org.junit.Test;

import com.cornholio.linkedin.connectionrank.model.Connections;
import com.cornholio.linkedin.connectionrank.model.Person;
import com.cornholio.linkedin.connectionrank.model.utils.ConnectionsParser;
import com.cornholio.linkedin.connectionrank.request.LinkedInConnectionsRequest;
import com.cornholio.linkedin.connectionrank.request.LinkedInProfileRequest;
import com.cornholio.linkedin.connectionrank.service.LinkedInServiceBuilder;
import com.cornholio.linkedin.connectionrank.service.ranking.ConnectionRankService;
import com.cornholio.linkedin.connectionrank.service.ranking.ProximityBasedConnectionRankImpl;
import com.cornholio.linkedin.connectionrank.service.token.ConsoleTokenService;

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
