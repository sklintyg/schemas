package se.inera.certificate.schema.adapter.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.LocalDate;

import se.inera.certificate.schema.adapter.LocalDateAdapter;

public class IsoDateXmlAdapter extends XmlAdapter<String, LocalDate> {

	@Override
	public LocalDate unmarshal(String isoDateString) throws Exception {

		return LocalDateAdapter.parseIsoDate(isoDateString);
	}

	@Override
	public String marshal(LocalDate dateValue) throws Exception {
		return LocalDateAdapter.printIsoDate(dateValue);
	}

}
