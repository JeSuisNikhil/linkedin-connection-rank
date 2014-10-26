package com.model;

/**
 * @author nikhilagarwal
 */
public class Location {
	private Country country;
	private String name;

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Location)) {
			return false;
		}
		final Location other = (Location) obj;
		if (this.country == null) {
			if (other.country != null) {
				return false;
			}
		} else if (!this.country.equals(other.country)) {
			return false;
		}
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		return true;
	}

	public Country getCountry() {
		return this.country;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.country == null) ? 0 : this.country.hashCode());
		result = (prime * result) + ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}

	public void setCountry(final Country country) {
		this.country = country;
	}

	public void setName(final String name) {
		this.name = name;
	}
}