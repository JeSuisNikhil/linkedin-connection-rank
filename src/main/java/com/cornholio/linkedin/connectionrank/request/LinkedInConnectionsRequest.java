package com.cornholio.linkedin.connectionrank.request;

import javax.xml.bind.JAXBException;

import com.cornholio.linkedin.connectionrank.constants.URLConstants;
import com.cornholio.linkedin.connectionrank.model.Connections;
import com.cornholio.linkedin.connectionrank.model.utils.ConnectionsParser;

/**
 * @author nikhilagarwal
 */
public class LinkedInConnectionsRequest extends LinkedInRequest {

	public LinkedInConnectionsRequest() {
		super();
	}

	public Connections getConnections() throws JAXBException {
		return ConnectionsParser.parse(this.getResponse().getBody());
	}

	@Override
	public String getScope() {
		return "r_network";
	}

	@Override
	protected String getUrl() {
		return URLConstants.PROTECTED_CONNECTION_RESOURCE_URL;
	}
}