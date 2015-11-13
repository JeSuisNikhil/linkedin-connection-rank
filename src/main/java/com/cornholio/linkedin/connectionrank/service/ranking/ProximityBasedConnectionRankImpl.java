package com.cornholio.linkedin.connectionrank.service.ranking;

import java.util.List;
import java.util.stream.Collectors;

import com.cornholio.linkedin.connectionrank.model.Connections;
import com.cornholio.linkedin.connectionrank.model.Person;

/**
 * Sorting is based on industry and location of the connection with respect to the user. Ideally one would use some sort of mechanism to determine the
 * proximity of the industry and location of the person1 from the user and then compare the proximity of the person2. Here we are only checking for
 * equality.
 *
 * @author nikhilagarwal
 */
public class ProximityBasedConnectionRankImpl implements ConnectionRankService {

    private static ProximityBasedConnectionRankImpl instance;

    private ProximityBasedConnectionRankImpl() {
        super();
    }

    public static ProximityBasedConnectionRankImpl getInstance() {
        if (instance == null) {
            instance = new ProximityBasedConnectionRankImpl();
        }

        return instance;
    }

    @Override
    public Connections sortedCopy(final Person user, final Connections connections) {
        final Connections sortedConnections = new Connections();
        sortedConnections.setCount(connections.getCount());
        sortedConnections.setStart(connections.getStart());
        sortedConnections.setTotal(connections.getTotal());
        final List<Person> people = connections.getPersons()
        		.stream()
        		.sorted(new DefaultProximityComparator(user)
        				.reversed())
        		.collect(Collectors.toList());
        sortedConnections.setPersons(people);
        return sortedConnections;
    }
}
