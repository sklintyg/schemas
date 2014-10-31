
package se.inera.webcert.sendmedicalcertificateanswerresponder.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the se.inera.webcert.sendmedicalcertificateanswerresponder.v1 package. 
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

    private final static QName _SendMedicalCertificateAnswerResponse_QNAME = new QName("urn:riv:insuranceprocess:healthreporting:SendMedicalCertificateAnswerResponder:1", "SendMedicalCertificateAnswerResponse");
    private final static QName _SendMedicalCertificateAnswer_QNAME = new QName("urn:riv:insuranceprocess:healthreporting:SendMedicalCertificateAnswerResponder:1", "SendMedicalCertificateAnswer");
    private final static QName _Answer_QNAME = new QName("urn:riv:insuranceprocess:healthreporting:SendMedicalCertificateAnswerResponder:1", "Answer");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: se.inera.webcert.sendmedicalcertificateanswerresponder.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AnswerToFkType }
     * 
     */
    public AnswerToFkType createAnswerToFkType() {
        return new AnswerToFkType();
    }

    /**
     * Create an instance of {@link SendMedicalCertificateAnswerType }
     * 
     */
    public SendMedicalCertificateAnswerType createSendMedicalCertificateAnswerType() {
        return new SendMedicalCertificateAnswerType();
    }

    /**
     * Create an instance of {@link SendMedicalCertificateAnswerResponseType }
     * 
     */
    public SendMedicalCertificateAnswerResponseType createSendMedicalCertificateAnswerResponseType() {
        return new SendMedicalCertificateAnswerResponseType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMedicalCertificateAnswerResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:riv:insuranceprocess:healthreporting:SendMedicalCertificateAnswerResponder:1", name = "SendMedicalCertificateAnswerResponse")
    public JAXBElement<SendMedicalCertificateAnswerResponseType> createSendMedicalCertificateAnswerResponse(SendMedicalCertificateAnswerResponseType value) {
        return new JAXBElement<SendMedicalCertificateAnswerResponseType>(_SendMedicalCertificateAnswerResponse_QNAME, SendMedicalCertificateAnswerResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMedicalCertificateAnswerType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:riv:insuranceprocess:healthreporting:SendMedicalCertificateAnswerResponder:1", name = "SendMedicalCertificateAnswer")
    public JAXBElement<SendMedicalCertificateAnswerType> createSendMedicalCertificateAnswer(SendMedicalCertificateAnswerType value) {
        return new JAXBElement<SendMedicalCertificateAnswerType>(_SendMedicalCertificateAnswer_QNAME, SendMedicalCertificateAnswerType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnswerToFkType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:riv:insuranceprocess:healthreporting:SendMedicalCertificateAnswerResponder:1", name = "Answer")
    public JAXBElement<AnswerToFkType> createAnswer(AnswerToFkType value) {
        return new JAXBElement<AnswerToFkType>(_Answer_QNAME, AnswerToFkType.class, null, value);
    }

}
