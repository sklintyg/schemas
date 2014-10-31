
package se.riv.ehr.log.store.storelog.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the se.riv.ehr.log.store.storelog.v1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _StoreLogResponse_QNAME = new QName("urn:riv:ehr:log:store:StoreLogResponder:1", "StoreLogResponse");
    private final static QName _StoreLogRequest_QNAME = new QName("urn:riv:ehr:log:store:StoreLogResponder:1", "StoreLogRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: se.riv.ehr.log.store.storelog.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StoreLogResponseType }
     * 
     */
    public StoreLogResponseType createStoreLogResponseType() {
        return new StoreLogResponseType();
    }

    /**
     * Create an instance of {@link StoreLogRequestType }
     * 
     */
    public StoreLogRequestType createStoreLogRequestType() {
        return new StoreLogRequestType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StoreLogResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:riv:ehr:log:store:StoreLogResponder:1", name = "StoreLogResponse")
    public JAXBElement<StoreLogResponseType> createStoreLogResponse(StoreLogResponseType value) {
        return new JAXBElement<StoreLogResponseType>(_StoreLogResponse_QNAME, StoreLogResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StoreLogRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:riv:ehr:log:store:StoreLogResponder:1", name = "StoreLogRequest")
    public JAXBElement<StoreLogRequestType> createStoreLogRequest(StoreLogRequestType value) {
        return new JAXBElement<StoreLogRequestType>(_StoreLogRequest_QNAME, StoreLogRequestType.class, null, value);
    }

}
