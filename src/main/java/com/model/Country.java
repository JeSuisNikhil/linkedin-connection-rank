package com.model;

/**
 * @author nikhilagarwal
 */
public class Country {
	private String code;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Country)) return false;

		Country country = (Country) o;

		return !(getCode() != null ? !getCode().equals(country.getCode()) : country.getCode() != null);
	}

	@Override
	public int hashCode() {
		return getCode() != null ? getCode().hashCode() : 0;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(final String code) {
		this.code = code;
	}

}