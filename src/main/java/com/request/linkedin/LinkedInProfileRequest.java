package com.request.linkedin;

import javax.xml.bind.JAXBException;

import com.constants.URLConstants;
import com.model.Person;
import com.model.utils.PersonParser;

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