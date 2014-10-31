
package se.riv.ehr.log.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActivityTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActivityTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Läsa"/>
 *     &lt;enumeration value="Skriva"/>
 *     &lt;enumeration value="Signera"/>
 *     &lt;enumeration value="Utskrift"/>
 *     &lt;enumeration value="Vidimera"/>
 *     &lt;enumeration value="Radera"/>
 *     &lt;enumeration value="Nödöppning"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActivityTypeType")
@XmlEnum
public enum ActivityTypeType {


    /**
     * 
     * 				        En läsning av data har utförts.
     * 				    
     * 
     */
    @XmlEnumValue("L\u00e4sa")
    LÄSA("L\u00e4sa"),

    /**
     * 
     * 				        En aktivitet där något läggs till.
     * 				    
     * 
     */
    @XmlEnumValue("Skriva")
    SKRIVA("Skriva"),

    /**
     * 
     * 				        Signering har utförts.
     * 				    
     * 
     */
    @XmlEnumValue("Signera")
    SIGNERA("Signera"),

    /**
     * 
     * 				        En utskrift har utförts.
     * 				    
     * 
     */
    @XmlEnumValue("Utskrift")
    UTSKRIFT("Utskrift"),

    /**
     * 
     * 				        En autentisering har utförts.
     * 				    
     * 
     */
    @XmlEnumValue("Vidimera")
    VIDIMERA("Vidimera"),

    /**
     * 
     * 				        Något har raderats.
     * 				    
     * 
     */
    @XmlEnumValue("Radera")
    RADERA("Radera"),

    /**
     * 
     * 				        Nödöppning har gjorts.
     * 				    
     * 
     */
    @XmlEnumValue("N\u00f6d\u00f6ppning")
    NÖDÖPPNING("N\u00f6d\u00f6ppning");
    private final String value;

    ActivityTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ActivityTypeType fromValue(String v) {
        for (ActivityTypeType c: ActivityTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
