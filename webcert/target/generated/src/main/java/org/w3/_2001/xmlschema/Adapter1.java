
package org.w3._2001.xmlschema;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.joda.time.LocalDateTime;

public class Adapter1
    extends XmlAdapter<String, LocalDateTime>
{


    public LocalDateTime unmarshal(String value) {
        return (se.inera.certificate.schema.adapter.LocalDateAdapter.parseDateTime(value));
    }

    public String marshal(LocalDateTime value) {
        return (se.inera.certificate.schema.adapter.LocalDateAdapter.printDateTime(value));
    }

}
