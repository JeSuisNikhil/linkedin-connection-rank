package com.cornholio.linkedin.connectionrank.request;

import javax.xml.bind.JAXBException;

import com.cornholio.linkedin.connectionrank.constants.URLConstants;
import com.cornholio.linkedin.connectionrank.model.Person;
import com.cornholio.linkedin.connectionrank.model.utils.PersonParser;

/**
 * @author nikhilagarwal
 */
public class LinkedInProfileRequest extends LinkedInRequest {

	public LinkedInProfileRequest() {
		super();
	}

	public Person getProfile() throws JAXBException {
		return PersonParser.parse(this.getResponse().getBody());
	}

	@Override
	public String getScope() {
		return "r_basicprofile";
	}

	@Override
	protected String getUrl() {
		return URLConstants.PROTECTED_PROFILE_RESOURCE_URL;
	}
}