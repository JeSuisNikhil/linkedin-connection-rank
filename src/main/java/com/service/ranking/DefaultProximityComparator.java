package com.service.ranking;

import java.util.Comparator;

import com.model.Location;
import com.model.Person;

/**
 * @author nikhilagarwal
 */
public class DefaultProximityComparator implements Comparator<Person> {

	// proximity is higher if the industry is a match than if the location is a match
	private static int WEIGHT_INDUSTRY = 1000;
	private static int WEIGHT_LOCATION = 10;

	/**
	 * Proximity calculator
	 *
	 * @param person1
	 * @param person2
	 * @return
	 */
	private static int calculateProximityBetween(final Person person1, final Person person2) {
		int proximityScore = 0;
		final String industry1 = person1.getIndustry();
		final Location location1 = person1.getLocation();

		final String industry2 = person2.getIndustry();
		final Location location2 = person2.getLocation();

		if ((industry1 != null) && (industry2 != null) && industry1.equals(industry2)) {
			proximityScore += DefaultProximityComparator.WEIGHT_INDUSTRY;
		}

		if ((location1 != null) && (location2 != null) && location1.equals(location2)) {
			proximityScore += DefaultProximityComparator.WEIGHT_LOCATION;
		}

		return proximityScore;
	}

	private Person user;

	public DefaultProximityComparator(final Person user) {
		super();
		this.user = user;
	}

	@Override
	public int compare(final Person person1, final Person person2) {
		final Integer proximity1 = DefaultProximityComparator.calculateProximityBetween(this.getUser(), person1);
		final Integer proximity2 = DefaultProximityComparator.calculateProximityBetween(this.getUser(), person2);

		return proximity1.compareTo(proximity2);
	}

	public Person getUser() {
		return this.user;
	}

	public void setUser(final Person user) {
		this.user = user;
	}
}
