package se.inera.intyg.schemas.support.adapter.xml;

import org.joda.time.LocalDate;
import se.inera.intyg.schemas.support.adapter.LocalDateAdapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

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
