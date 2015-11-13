package com.cornholio.linkedin.connectionrank.service.token;

import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

/**
 * @author nikhilagarwal
 */
public interface TokenService {

	Token getToken(final OAuthService service);
}