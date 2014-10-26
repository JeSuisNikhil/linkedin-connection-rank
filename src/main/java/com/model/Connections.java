package com.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nikhilagarwal
 */
@XmlRootElement(name = "connections")
@XmlAccessorType(XmlAccessType.FIELD)
public class Connections {

	private int count;
	@XmlElement(name = "person")
	private List<Person> persons;
	private int start;
	private int total;

	public int getCount() {
		return this.count;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public int getStart() {
		return this.start;
	}

	public int getTotal() {
		return this.total;
	}

	public void setCount(final int count) {
		this.count = count;
	}

	public void setPersons(final List<Person> persons) {
		this.persons = persons;
	}

	public void setStart(final int start) {
		this.start = start;
	}

	public void setTotal(final int total) {
		this.total = total;
	}
}
