package se.inera.certificate.schema.adapter.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.LocalDateTime;

import se.inera.certificate.schema.adapter.LocalDateAdapter;

public class IsoDateTimeXmlAdapter extends XmlAdapter<String, LocalDateTime> {

	@Override
	public LocalDateTime unmarshal(String isoDateTimeString) throws Exception {

		return LocalDateAdapter.parseIsoDateTime(isoDateTimeString);
	}

	@Override
	public String marshal(LocalDateTime dateValue) throws Exception {
		return LocalDateAdapter.printIsoDateTime(dateValue);
	}

}