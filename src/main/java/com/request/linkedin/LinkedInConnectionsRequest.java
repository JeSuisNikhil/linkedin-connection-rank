package com.request.linkedin;

import javax.xml.bind.JAXBException;

import com.constants.URLConstants;
import com.model.Connections;
import com.model.utils.ConnectionsParser;

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