package com.cornholio.linkedin.connectionrank.model;

/**
 * @author nikhilagarwal
 */
public class Location {
	private Country country;
	private String name;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Location)) return false;

		Location location = (Location) o;

		if (getCountry() != null ? !getCountry().equals(location.getCountry()) : location.getCountry() != null)
			return false;
		return !(getName() != null ? !getName().equals(location.getName()) : location.getName() != null);
	}

	@Override
	public int hashCode() {
		int result = getCountry() != null ? getCountry().hashCode() : 0;
		result = 31 * result + (getName() != null ? getName().hashCode() : 0);
		return result;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(final Country country) {
		this.country = country;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}
}