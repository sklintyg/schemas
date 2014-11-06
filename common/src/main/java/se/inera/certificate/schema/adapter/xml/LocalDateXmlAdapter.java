package se.inera.certificate.schema.adapter.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.LocalDate;

import se.inera.certificate.schema.adapter.LocalDateAdapter;

public class LocalDateXmlAdapter extends XmlAdapter<String, LocalDate> {

	public LocalDate unmarshal(String value) {
		return (LocalDateAdapter.parseDate(value));
	}

	public String marshal(LocalDate value) {
		return (LocalDateAdapter.printDate(value));
	}

}
