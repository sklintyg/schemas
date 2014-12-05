package se.inera.certificate.schema.adapter.xml;

import org.joda.time.Partial;
import se.inera.certificate.schema.adapter.PartialAdapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class PartialDateXmlAdapter extends XmlAdapter<String, Partial> {

    @Override
    public Partial unmarshal(String dateString) throws Exception {
        return PartialAdapter.parsePartial(dateString);
    }

    @Override
    public String marshal(Partial partial) throws Exception {
        return PartialAdapter.printPartial(partial);
    }
}
