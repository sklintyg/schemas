
package se.riv.ehr.log.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResultCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ResultCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OK"/>
 *     &lt;enumeration value="INFO"/>
 *     &lt;enumeration value="ERROR"/>
 *     &lt;enumeration value="VALIDATION_ERROR"/>
 *     &lt;enumeration value="ACCESSDENIED"/>
 *     &lt;enumeration value="REPORT_ON_QUEUE"/>
 *     &lt;enumeration value="REPORT_IN_PROCESS"/>
 *     &lt;enumeration value="REPORT_NOT_FOUND"/>
 *     &lt;enumeration value="MAX_QUERY_RESULT_EXCEEDED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ResultCodeType")
@XmlEnum
public enum ResultCodeType {


    /**
     * 
     * 				        Transaktionen har utförts enligt uppdraget.
     * 				    
     * 
     */
    OK,

    /**
     * 
     * 				        Transaktionen har utförts enligt begäran, men det finns ett meddelande som konsumenten måste visa upp för användaren (om tillämpbart). Exempel på detta kan vara &quot;kom fastande&quot;.
     * 				    
     * 
     */
    INFO,

    /**
     * 
     * 				        Transaktionen har INTE kunnat utföras p.g.a ett logiskt fel. Det finns ett meddelande som konsumenten måste visa upp. Exempel på detta kan vara &quot;tiden har bokats av annan patient&quot;.
     * 				    
     * 
     */
    ERROR,

    /**
     * 
     * 				        En eller flera inparametrar innehåller felaktiga värden. Angiven tjänst utfördes ej.
     * 				    
     * 
     */
    VALIDATION_ERROR,

    /**
     * 
     * 				        Behörighet saknas för att utföra begärd tjänst. Angiven tjänst utfördes ej.
     * 				    
     * 
     */
    ACCESSDENIED,

    /**
     * 
     * 				        Angiven rapport är ej klar. Rapporten ligger på kö för att genereras. Ytterligere anrop kan göras för att kontrollera om jobbet är klart.
     * 				    
     * 
     */
    REPORT_ON_QUEUE,

    /**
     * 
     * 				        Angiven rapport är ej klar. Rapporten är under uppbyggnad. Ytterligere anrop kan göras för att kontrollera om jobbet är klart.
     * 				    
     * 
     */
    REPORT_IN_PROCESS,

    /**
     * 
     * 				        Felaktig id angivet. Angiven tjänst ej kan hitta rapport med angivet id som är skapad eller rapport som ligger på kö för att skapas.
     * 				    
     * 
     */
    REPORT_NOT_FOUND,

    /**
     * 
     * 				        Max antal loggposter som tjänsten kan returnera har överstigits. Ändra sökparametrar för att begränsa rapportuttaget.
     * 				    
     * 
     */
    MAX_QUERY_RESULT_EXCEEDED;

    public String value() {
        return name();
    }

    public static ResultCodeType fromValue(String v) {
        return valueOf(v);
    }

}
