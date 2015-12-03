package se.inera.intyg.schemas.support.adapter.xml;

import org.joda.time.LocalDateTime;
import se.inera.intyg.schemas.support.adapter.LocalDateAdapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateTimeXmlAdapter extends XmlAdapter<String, LocalDateTime> {

    public LocalDateTime unmarshal(String value) {
        return (LocalDateAdapter.parseDateTime(value));
    }

    public String marshal(LocalDateTime value) {
        return (LocalDateAdapter.printDateTime(value));
    }
}
