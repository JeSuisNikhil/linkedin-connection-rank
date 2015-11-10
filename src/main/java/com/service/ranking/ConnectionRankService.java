package com.service.ranking;

import com.model.Connections;
import com.model.Person;

/**
 * @author nikhilagarwal
 */
public interface ConnectionRankService {

	/**
	 * Sorts the connections for given user in a pre-decided order of importance
	 *
	 * @param user
	 * @param connections
	 */
	Connections sortedCopy(final Person user, final Connections connections);
}
