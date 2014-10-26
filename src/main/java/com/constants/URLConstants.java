package com.constants;

/**
 * Standard URLs provided by LinkedIn api.
 *
 * @author nikhilagarwal
 */
public class URLConstants {

	public static final String PROTECTED_CONNECTION_RESOURCE_URL =
			"http://api.linkedin.com/v1/people/~/connections:(id,first-name,last-name,location,industry)";
	public static final String PROTECTED_PROFILE_CONNECTIONS_RESOURCE_URL =
			"http://api.linkedin.com/v1/people/~:(id,first-name,last-name,location,industry,connections:(id,first-name,last-name,location,industry))";
	public static final String PROTECTED_PROFILE_RESOURCE_URL = "http://api.linkedin.com/v1/people/~:(id,first-name,last-name,location,industry)";

}
