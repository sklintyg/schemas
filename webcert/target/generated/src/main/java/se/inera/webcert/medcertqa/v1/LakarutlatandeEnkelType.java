
package se.inera.webcert.medcertqa.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.joda.time.LocalDateTime;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;
import org.w3._2001.xmlschema.Adapter1;
import org.w3c.dom.Element;
import se.inera.ifv.insuranceprocess.healthreporting.v2.PatientType;


/**
 * <p>Java class for lakarutlatandeEnkelType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="lakarutlatandeEnkelType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lakarutlatande-id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="signeringsTidpunkt" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="patient" type="{urn:riv:insuranceprocess:healthreporting:2}patientType"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lakarutlatandeEnkelType", propOrder = {
    "lakarutlatandeId",
    "signeringsTidpunkt",
    "patient",
    "any"
})
public class LakarutlatandeEnkelType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "lakarutlatande-id", required = true)
    protected String lakarutlatandeId;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected LocalDateTime signeringsTidpunkt;
    @XmlElement(required = true)
    protected PatientType patient;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the lakarutlatandeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLakarutlatandeId() {
        return lakarutlatandeId;
    }

    /**
     * Sets the value of the lakarutlatandeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLakarutlatandeId(String value) {
        this.lakarutlatandeId = value;
    }

    /**
     * Gets the value of the signeringsTidpunkt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDateTime getSigneringsTidpunkt() {
        return signeringsTidpunkt;
    }

    /**
     * Sets the value of the signeringsTidpunkt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSigneringsTidpunkt(LocalDateTime value) {
        this.signeringsTidpunkt = value;
    }

    /**
     * Gets the value of the patient property.
     * 
     * @return
     *     possible object is
     *     {@link PatientType }
     *     
     */
    public PatientType getPatient() {
        return patient;
    }

    /**
     * Sets the value of the patient property.
     * 
     * @param value
     *     allowed object is
     *     {@link PatientType }
     *     
     */
    public void setPatient(PatientType value) {
        this.patient = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * {@link Element }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theLakarutlatandeId;
            theLakarutlatandeId = this.getLakarutlatandeId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lakarutlatandeId", theLakarutlatandeId), currentHashCode, theLakarutlatandeId);
        }
        {
            LocalDateTime theSigneringsTidpunkt;
            theSigneringsTidpunkt = this.getSigneringsTidpunkt();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signeringsTidpunkt", theSigneringsTidpunkt), currentHashCode, theSigneringsTidpunkt);
        }
        {
            PatientType thePatient;
            thePatient = this.getPatient();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "patient", thePatient), currentHashCode, thePatient);
        }
        {
            List<Object> theAny;
            theAny = (((this.any!= null)&&(!this.any.isEmpty()))?this.getAny():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "any", theAny), currentHashCode, theAny);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof LakarutlatandeEnkelType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final LakarutlatandeEnkelType that = ((LakarutlatandeEnkelType) object);
        {
            String lhsLakarutlatandeId;
            lhsLakarutlatandeId = this.getLakarutlatandeId();
            String rhsLakarutlatandeId;
            rhsLakarutlatandeId = that.getLakarutlatandeId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lakarutlatandeId", lhsLakarutlatandeId), LocatorUtils.property(thatLocator, "lakarutlatandeId", rhsLakarutlatandeId), lhsLakarutlatandeId, rhsLakarutlatandeId)) {
                return false;
            }
        }
        {
            LocalDateTime lhsSigneringsTidpunkt;
            lhsSigneringsTidpunkt = this.getSigneringsTidpunkt();
            LocalDateTime rhsSigneringsTidpunkt;
            rhsSigneringsTidpunkt = that.getSigneringsTidpunkt();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "signeringsTidpunkt", lhsSigneringsTidpunkt), LocatorUtils.property(thatLocator, "signeringsTidpunkt", rhsSigneringsTidpunkt), lhsSigneringsTidpunkt, rhsSigneringsTidpunkt)) {
                return false;
            }
        }
        {
            PatientType lhsPatient;
            lhsPatient = this.getPatient();
            PatientType rhsPatient;
            rhsPatient = that.getPatient();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "patient", lhsPatient), LocatorUtils.property(thatLocator, "patient", rhsPatient), lhsPatient, rhsPatient)) {
                return false;
            }
        }
        {
            List<Object> lhsAny;
            lhsAny = (((this.any!= null)&&(!this.any.isEmpty()))?this.getAny():null);
            List<Object> rhsAny;
            rhsAny = (((that.any!= null)&&(!that.any.isEmpty()))?that.getAny():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "any", lhsAny), LocatorUtils.property(thatLocator, "any", rhsAny), lhsAny, rhsAny)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            String theLakarutlatandeId;
            theLakarutlatandeId = this.getLakarutlatandeId();
            strategy.appendField(locator, this, "lakarutlatandeId", buffer, theLakarutlatandeId);
        }
        {
            LocalDateTime theSigneringsTidpunkt;
            theSigneringsTidpunkt = this.getSigneringsTidpunkt();
            strategy.appendField(locator, this, "signeringsTidpunkt", buffer, theSigneringsTidpunkt);
        }
        {
            PatientType thePatient;
            thePatient = this.getPatient();
            strategy.appendField(locator, this, "patient", buffer, thePatient);
        }
        {
            List<Object> theAny;
            theAny = (((this.any!= null)&&(!this.any.isEmpty()))?this.getAny():null);
            strategy.appendField(locator, this, "any", buffer, theAny);
        }
        return buffer;
    }

}
