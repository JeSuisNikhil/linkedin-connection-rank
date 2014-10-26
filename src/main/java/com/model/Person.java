package com.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nikhilagarwal
 */
@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

	@XmlElement(name = "first-name")
	private String firstName;
	private String id;
	private String industry;
	@XmlElement(name = "last-name")
	private String lastName;
	private Location location;

	public String getFirstName() {
		return this.firstName;
	}

	public String getId() {
		return this.id;
	}

	public String getIndustry() {
		return this.industry;
	}

	public String getLastName() {
		return this.lastName;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public void setIndustry(final String industry) {
		this.industry = industry;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public void setLocation(final Location location) {
		this.location = location;
	}
}