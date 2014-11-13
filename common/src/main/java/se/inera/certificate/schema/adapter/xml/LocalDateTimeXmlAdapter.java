package se.inera.certificate.schema.adapter.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.LocalDateTime;

import se.inera.certificate.schema.adapter.LocalDateAdapter;

public class LocalDateTimeXmlAdapter extends XmlAdapter<String, LocalDateTime> {

	public LocalDateTime unmarshal(String value) {
		return (LocalDateAdapter.parseDateTime(value));
	}

	public String marshal(LocalDateTime value) {
		return (LocalDateAdapter.printDateTime(value));
	}

}
