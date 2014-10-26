package com.service.linkedin;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.LinkedInApi;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

import com.constants.KeyConstants;
import com.request.linkedin.LinkedInRequest;
import com.service.token.TokenService;

/**
 * @author nikhilagarwal
 */
public class LinkedInService {
	private OAuthService oauthService;
	private Token token;
	private TokenService tokenService;

	LinkedInService() {
		super();
	}

	public OAuthService getOauthService() {
		return this.oauthService;
	}

	private Token getToken() {
		return this.token;
	}

	public TokenService getTokenService() {
		return this.tokenService;
	}

	public void initiateService(final String scope) {
		this.setOauthService(new ServiceBuilder().provider(LinkedInApi.withScopes(scope)).apiKey(KeyConstants.API_KEY)
				.apiSecret(KeyConstants.API_SECRET).build());
		this.setToken(this.getTokenService().getToken(this.getOauthService()));
	}

	private void setOauthService(final OAuthService oauthService) {
		this.oauthService = oauthService;
	}

	private void setToken(final Token token) {
		this.token = token;
	}

	void setTokenService(final TokenService tokenService) {
		this.tokenService = tokenService;
	}

	public void signRequest(final LinkedInRequest linkedInRequest) {
		this.getOauthService().signRequest(this.getToken(), linkedInRequest.getRequest());
	}
}
