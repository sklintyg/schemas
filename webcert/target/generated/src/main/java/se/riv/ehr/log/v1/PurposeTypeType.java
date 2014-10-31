
package se.riv.ehr.log.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PurposeTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PurposeTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Vård och behandling"/>
 *     &lt;enumeration value="Kvalitetssäkring"/>
 *     &lt;enumeration value="Annan dokumentation enligt lag"/>
 *     &lt;enumeration value="Statistik"/>
 *     &lt;enumeration value="Administration"/>
 *     &lt;enumeration value="Kvalitetsregister"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PurposeTypeType")
@XmlEnum
public enum PurposeTypeType {


    /**
     * 
     * 				        Innefattar följande ändamål enligt Patientdatalag 2kap4§: Att fullgöra de skyldigheter som anges i 3 kap. (Skyldigheten att föra patientjournal) och upprätta annan dokumentation som behövs i och för vården av patienter. Administration som rör patienter och som syftar till att ge vård i enskilda fall eller som annars föranleds av vård i enskilda fall.
     * 				    
     * 
     */
    @XmlEnumValue("V\u00e5rd och behandling")
    VÅRD_OCH_BEHANDLING("V\u00e5rd och behandling"),

    /**
     * 
     * 				        Innefattar följande ändamål enligt Patientdatalag 2kap4§: Systematiskt och fortlöpande utveckla och säkra kvaliteten i verksamheten.
     * 				    
     * 
     */
    @XmlEnumValue("Kvalitetss\u00e4kring")
    KVALITETSSÄKRING("Kvalitetss\u00e4kring"),

    /**
     * 
     * 				        Innefattar följande ändamål enligt Patientdatalag 2kap4§: Upprätta annan dokumentation som följer av lag, förordning eller annan författning.
     * 				    
     * 
     */
    @XmlEnumValue("Annan dokumentation enligt lag")
    ANNAN_DOKUMENTATION_ENLIGT_LAG("Annan dokumentation enligt lag"),

    /**
     * 
     * 				        Innefattar följande ändamål enligt Patientdatalag 2kap4§: Framställa statistik om hälso- och sjukvården.
     * 				    
     * 
     */
    @XmlEnumValue("Statistik")
    STATISTIK("Statistik"),

    /**
     * 
     * 				        Innefattar följande ändamål enligt Patientdatalag 2kap4§: Administration, planering, uppföljning, utvärdering och tillsyn av verksamheten.
     * 				    
     * 
     */
    @XmlEnumValue("Administration")
    ADMINISTRATION("Administration"),

    /**
     * 
     * 				        Beskrivs i Patientdatalagen 7kap4§: Att systematiskt och fortlöpande utveckla och säkra vårdens kvalitet. Ändamålet ska användas vid kvalitetsuppföljning i av SKL godkända kvalitetsregister.
     * 				    
     * 
     */
    @XmlEnumValue("Kvalitetsregister")
    KVALITETSREGISTER("Kvalitetsregister");
    private final String value;

    PurposeTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PurposeTypeType fromValue(String v) {
        for (PurposeTypeType c: PurposeTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
