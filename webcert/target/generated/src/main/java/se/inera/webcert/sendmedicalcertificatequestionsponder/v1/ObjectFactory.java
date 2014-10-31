
package se.inera.webcert.sendmedicalcertificatequestionsponder.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the se.inera.webcert.sendmedicalcertificatequestionsponder.v1 package. 
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

    private final static QName _Question_QNAME = new QName("urn:riv:insuranceprocess:healthreporting:SendMedicalCertificateQuestionResponder:1", "Question");
    private final static QName _SendMedicalCertificateQuestionResponse_QNAME = new QName("urn:riv:insuranceprocess:healthreporting:SendMedicalCertificateQuestionResponder:1", "SendMedicalCertificateQuestionResponse");
    private final static QName _SendMedicalCertificateQuestion_QNAME = new QName("urn:riv:insuranceprocess:healthreporting:SendMedicalCertificateQuestionResponder:1", "SendMedicalCertificateQuestion");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: se.inera.webcert.sendmedicalcertificatequestionsponder.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendMedicalCertificateQuestionType }
     * 
     */
    public SendMedicalCertificateQuestionType createSendMedicalCertificateQuestionType() {
        return new SendMedicalCertificateQuestionType();
    }

    /**
     * Create an instance of {@link SendMedicalCertificateQuestionResponseType }
     * 
     */
    public SendMedicalCertificateQuestionResponseType createSendMedicalCertificateQuestionResponseType() {
        return new SendMedicalCertificateQuestionResponseType();
    }

    /**
     * Create an instance of {@link QuestionToFkType }
     * 
     */
    public QuestionToFkType createQuestionToFkType() {
        return new QuestionToFkType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionToFkType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:riv:insuranceprocess:healthreporting:SendMedicalCertificateQuestionResponder:1", name = "Question")
    public JAXBElement<QuestionToFkType> createQuestion(QuestionToFkType value) {
        return new JAXBElement<QuestionToFkType>(_Question_QNAME, QuestionToFkType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMedicalCertificateQuestionResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:riv:insuranceprocess:healthreporting:SendMedicalCertificateQuestionResponder:1", name = "SendMedicalCertificateQuestionResponse")
    public JAXBElement<SendMedicalCertificateQuestionResponseType> createSendMedicalCertificateQuestionResponse(SendMedicalCertificateQuestionResponseType value) {
        return new JAXBElement<SendMedicalCertificateQuestionResponseType>(_SendMedicalCertificateQuestionResponse_QNAME, SendMedicalCertificateQuestionResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMedicalCertificateQuestionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:riv:insuranceprocess:healthreporting:SendMedicalCertificateQuestionResponder:1", name = "SendMedicalCertificateQuestion")
    public JAXBElement<SendMedicalCertificateQuestionType> createSendMedicalCertificateQuestion(SendMedicalCertificateQuestionType value) {
        return new JAXBElement<SendMedicalCertificateQuestionType>(_SendMedicalCertificateQuestion_QNAME, SendMedicalCertificateQuestionType.class, null, value);
    }

}
