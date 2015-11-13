package com.cornholio.linkedin.connectionrank.model.utils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.cornholio.linkedin.connectionrank.model.Person;

/**
 * @author nikhilagarwal
 */
public class PersonParser {

	public static String marshall(final Person Person) throws JAXBException {
		final JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
		final Marshaller marshaller = jaxbContext.createMarshaller();
		final StringWriter writer = new StringWriter();
		marshaller.marshal(Person, writer);
		return writer.toString();
	}

	public static Person parse(final String xml) throws JAXBException {
		final JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
		final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		return (Person) unmarshaller.unmarshal(new StringReader(xml));
	}
}
