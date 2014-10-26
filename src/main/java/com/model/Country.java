package com.model;

/**
 * @author nikhilagarwal
 */
public class Country {
	private String code;

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Country)) {
			return false;
		}
		final Country other = (Country) obj;
		if (this.code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!this.code.equals(other.code)) {
			return false;
		}
		return true;
	}

	public String getCode() {
		return this.code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.code == null) ? 0 : this.code.hashCode());
		return result;
	}

	public void setCode(final String code) {
		this.code = code;
	}

}