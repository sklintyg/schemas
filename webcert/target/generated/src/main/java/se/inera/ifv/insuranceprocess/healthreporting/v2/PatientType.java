
package se.inera.ifv.insuranceprocess.healthreporting.v2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import iso.v21090.dt.v1.II;
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
import org.w3c.dom.Element;


/**
 * <p>Java class for patientType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="patientType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="person-id" type="{urn:iso:21090:dt:1}II"/>
 *         &lt;element name="fullstandigtNamn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "patientType", propOrder = {
    "personId",
    "fullstandigtNamn",
    "any"
})
public class PatientType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "person-id", required = true)
    protected II personId;
    @XmlElement(required = true)
    protected String fullstandigtNamn;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the personId property.
     * 
     * @return
     *     possible object is
     *     {@link II }
     *     
     */
    public II getPersonId() {
        return personId;
    }

    /**
     * Sets the value of the personId property.
     * 
     * @param value
     *     allowed object is
     *     {@link II }
     *     
     */
    public void setPersonId(II value) {
        this.personId = value;
    }

    /**
     * Gets the value of the fullstandigtNamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullstandigtNamn() {
        return fullstandigtNamn;
    }

    /**
     * Sets the value of the fullstandigtNamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullstandigtNamn(String value) {
        this.fullstandigtNamn = value;
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
            II thePersonId;
            thePersonId = this.getPersonId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "personId", thePersonId), currentHashCode, thePersonId);
        }
        {
            String theFullstandigtNamn;
            theFullstandigtNamn = this.getFullstandigtNamn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fullstandigtNamn", theFullstandigtNamn), currentHashCode, theFullstandigtNamn);
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
        if (!(object instanceof PatientType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final PatientType that = ((PatientType) object);
        {
            II lhsPersonId;
            lhsPersonId = this.getPersonId();
            II rhsPersonId;
            rhsPersonId = that.getPersonId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "personId", lhsPersonId), LocatorUtils.property(thatLocator, "personId", rhsPersonId), lhsPersonId, rhsPersonId)) {
                return false;
            }
        }
        {
            String lhsFullstandigtNamn;
            lhsFullstandigtNamn = this.getFullstandigtNamn();
            String rhsFullstandigtNamn;
            rhsFullstandigtNamn = that.getFullstandigtNamn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fullstandigtNamn", lhsFullstandigtNamn), LocatorUtils.property(thatLocator, "fullstandigtNamn", rhsFullstandigtNamn), lhsFullstandigtNamn, rhsFullstandigtNamn)) {
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
            II thePersonId;
            thePersonId = this.getPersonId();
            strategy.appendField(locator, this, "personId", buffer, thePersonId);
        }
        {
            String theFullstandigtNamn;
            theFullstandigtNamn = this.getFullstandigtNamn();
            strategy.appendField(locator, this, "fullstandigtNamn", buffer, theFullstandigtNamn);
        }
        {
            List<Object> theAny;
            theAny = (((this.any!= null)&&(!this.any.isEmpty()))?this.getAny():null);
            strategy.appendField(locator, this, "any", buffer, theAny);
        }
        return buffer;
    }

}
