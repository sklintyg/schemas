package se.inera.webcert.sendmedicalcertificatequestion.v1.rivtabp20;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.5
 * 2014-10-31T14:33:12.611+01:00
 * Generated source version: 2.7.5
 * 
 */
@WebService(targetNamespace = "urn:riv:insuranceprocess:healthreporting:SendMedicalCertificateQuestion:1:rivtabp20", name = "SendMedicalCertificateQuestionResponderInterface")
@XmlSeeAlso({org.w3.wsaddressing10.ObjectFactory.class, se.inera.webcert.medcertqa.v1.ObjectFactory.class, se.inera.ifv.insuranceprocess.healthreporting.v2.ObjectFactory.class, iso.v21090.dt.v1.ObjectFactory.class, se.inera.webcert.sendmedicalcertificatequestionsponder.v1.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface SendMedicalCertificateQuestionResponderInterface {

    @WebResult(name = "SendMedicalCertificateQuestionResponse", targetNamespace = "urn:riv:insuranceprocess:healthreporting:SendMedicalCertificateQuestionResponder:1", partName = "parameters")
    @WebMethod(operationName = "SendMedicalCertificateQuestion", action = "urn:riv:insuranceprocess:healthreporting:SendMedicalCertificateQuestionResponder:1")
    public se.inera.webcert.sendmedicalcertificatequestionsponder.v1.SendMedicalCertificateQuestionResponseType sendMedicalCertificateQuestion(
        @WebParam(partName = "LogicalAddress", name = "To", targetNamespace = "http://www.w3.org/2005/08/addressing", header = true)
        org.w3.wsaddressing10.AttributedURIType logicalAddress,
        @WebParam(partName = "parameters", name = "SendMedicalCertificateQuestion", targetNamespace = "urn:riv:insuranceprocess:healthreporting:SendMedicalCertificateQuestionResponder:1")
        se.inera.webcert.sendmedicalcertificatequestionsponder.v1.SendMedicalCertificateQuestionType parameters
    );
}
