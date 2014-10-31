
package org.w3._2001.xmlschema;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.joda.time.LocalDate;

public class Adapter2
    extends XmlAdapter<String, LocalDate>
{


    public LocalDate unmarshal(String value) {
        return (se.inera.certificate.schema.adapter.LocalDateAdapter.parseDate(value));
    }

    public String marshal(LocalDate value) {
        return (se.inera.certificate.schema.adapter.LocalDateAdapter.printDate(value));
    }

}
