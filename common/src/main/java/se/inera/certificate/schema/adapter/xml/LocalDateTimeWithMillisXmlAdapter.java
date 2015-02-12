package se.inera.certificate.schema.adapter.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.LocalDateTime;

import se.inera.certificate.schema.adapter.LocalDateTimeWithMillisAdapter;

public class LocalDateTimeWithMillisXmlAdapter extends XmlAdapter<String, LocalDateTime> {

    public LocalDateTime unmarshal(String value) {
        return (LocalDateTimeWithMillisAdapter.parseDateTime(value));
    }

    public String marshal(LocalDateTime value) {
        return (LocalDateTimeWithMillisAdapter.printDateTime(value));
    }
}
