package com.cornholio.linkedin.connectionrank.request;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;

/**
 * @author nikhilagarwal
 */
public abstract class LinkedInRequest {

	private OAuthRequest request;
	private Response response;

	protected LinkedInRequest() {
		super();
		this.buildRequest();
	}

	protected void buildRequest() {
		this.request = new OAuthRequest(Verb.GET, this.getUrl());
	}

	public OAuthRequest getRequest() {
		return this.request;
	}

	protected Response getResponse() {
		if (this.response == null) {
			this.response = this.request.send();
		}
		return this.response;
	}

	public abstract String getScope();

	protected abstract String getUrl();
}