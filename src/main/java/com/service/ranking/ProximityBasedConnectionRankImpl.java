package com.service.ranking;

import java.util.List;

import com.google.common.collect.Ordering;
import com.model.Connections;
import com.model.Person;

/**
 * Sorting is based on industry and location of the connection with respect to the user. Ideally one would use some sort of mechanism to determine the
 * proximity of the industry and location of the person1 from the user and then compare the proximity of the person2. Here we are only checking for
 * equality.
 *
 * @author nikhilagarwal
 */
public class ProximityBasedConnectionRankImpl implements ConnectionRankService {

	private static volatile ProximityBasedConnectionRankImpl instance;

	public static ProximityBasedConnectionRankImpl getInstance() {
		if (ProximityBasedConnectionRankImpl.instance == null) {
			synchronized (ProximityBasedConnectionRankImpl.class) {
				if (ProximityBasedConnectionRankImpl.instance == null) {
					ProximityBasedConnectionRankImpl.instance = new ProximityBasedConnectionRankImpl();
				}
			}
		}

		return ProximityBasedConnectionRankImpl.instance;
	}

	private ProximityBasedConnectionRankImpl() {
		super();
	}

	@Override
	public Connections sortedCopy(final Person user, final Connections connections) {
		final Connections sortedConnections = new Connections();
		sortedConnections.setCount(connections.getCount());
		sortedConnections.setStart(connections.getStart());
		sortedConnections.setTotal(connections.getTotal());
		final List<Person> people = Ordering.from(new DefaultProximityComparator(user)).reverse().sortedCopy(connections.getPersons());
		sortedConnections.setPersons(people);
		return sortedConnections;
	}
}
