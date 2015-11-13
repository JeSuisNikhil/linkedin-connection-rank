package com.cornholio.linkedin.connectionrank.model.utils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.cornholio.linkedin.connectionrank.model.Connections;

/**
 * @author nikhilagarwal
 */
public class ConnectionsParser {

	public static String marshall(final Connections connections) throws JAXBException {
		final JAXBContext jaxbContext = JAXBContext.newInstance(Connections.class);
		final Marshaller marshaller = jaxbContext.createMarshaller();
		final StringWriter writer = new StringWriter();
		marshaller.marshal(connections, writer);
		return writer.toString();
	}

	public static Connections parse(final String xml) throws JAXBException {
		final JAXBContext jaxbContext = JAXBContext.newInstance(Connections.class);
		final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		return (Connections) unmarshaller.unmarshal(new StringReader(xml));
	}
}
