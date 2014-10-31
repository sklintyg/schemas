package se.riv.itintegration.monitoring.rivtabp21.v1;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.5
 * 2014-10-31T14:33:12.833+01:00
 * Generated source version: 2.7.5
 * 
 */
@WebService(targetNamespace = "urn:riv:itintegration:monitoring:PingForConfiguration:1:rivtabp21", name = "PingForConfigurationResponderInterface")
@XmlSeeAlso({se.riv.itintegration.registry.v1.ObjectFactory.class, se.riv.itintegration.monitoring.v1.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface PingForConfigurationResponderInterface {

    @WebResult(name = "PingForConfigurationResponse", targetNamespace = "urn:riv:itintegration:monitoring:PingForConfigurationResponder:1", partName = "parameters")
    @WebMethod(operationName = "PingForConfiguration", action = "urn:riv:itintegration:monitoring:PingForConfigurationResponder:1:PingForConfiguration")
    public se.riv.itintegration.monitoring.v1.PingForConfigurationResponseType pingForConfiguration(
        @WebParam(partName = "LogicalAddress", name = "LogicalAddress", targetNamespace = "urn:riv:itintegration:registry:1", header = true)
        java.lang.String logicalAddress,
        @WebParam(partName = "parameters", name = "PingForConfiguration", targetNamespace = "urn:riv:itintegration:monitoring:PingForConfigurationResponder:1")
        se.riv.itintegration.monitoring.v1.PingForConfigurationType parameters
    );
}
