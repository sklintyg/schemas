
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
 * <p>Java class for hosPersonalType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="hosPersonalType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="personal-id" type="{urn:iso:21090:dt:1}II"/>
 *         &lt;element name="fullstandigtNamn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="forskrivarkod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="enhet" type="{urn:riv:insuranceprocess:healthreporting:2}enhetType"/>
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
@XmlType(name = "hosPersonalType", propOrder = {
    "personalId",
    "fullstandigtNamn",
    "forskrivarkod",
    "enhet",
    "any"
})
public class HosPersonalType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "personal-id", required = true)
    protected II personalId;
    @XmlElement(required = true)
    protected String fullstandigtNamn;
    protected String forskrivarkod;
    @XmlElement(required = true)
    protected EnhetType enhet;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the personalId property.
     * 
     * @return
     *     possible object is
     *     {@link II }
     *     
     */
    public II getPersonalId() {
        return personalId;
    }

    /**
     * Sets the value of the personalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link II }
     *     
     */
    public void setPersonalId(II value) {
        this.personalId = value;
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
     * Gets the value of the forskrivarkod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForskrivarkod() {
        return forskrivarkod;
    }

    /**
     * Sets the value of the forskrivarkod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForskrivarkod(String value) {
        this.forskrivarkod = value;
    }

    /**
     * Gets the value of the enhet property.
     * 
     * @return
     *     possible object is
     *     {@link EnhetType }
     *     
     */
    public EnhetType getEnhet() {
        return enhet;
    }

    /**
     * Sets the value of the enhet property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnhetType }
     *     
     */
    public void setEnhet(EnhetType value) {
        this.enhet = value;
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
            II thePersonalId;
            thePersonalId = this.getPersonalId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "personalId", thePersonalId), currentHashCode, thePersonalId);
        }
        {
            String theFullstandigtNamn;
            theFullstandigtNamn = this.getFullstandigtNamn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fullstandigtNamn", theFullstandigtNamn), currentHashCode, theFullstandigtNamn);
        }
        {
            String theForskrivarkod;
            theForskrivarkod = this.getForskrivarkod();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "forskrivarkod", theForskrivarkod), currentHashCode, theForskrivarkod);
        }
        {
            EnhetType theEnhet;
            theEnhet = this.getEnhet();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "enhet", theEnhet), currentHashCode, theEnhet);
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
        if (!(object instanceof HosPersonalType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final HosPersonalType that = ((HosPersonalType) object);
        {
            II lhsPersonalId;
            lhsPersonalId = this.getPersonalId();
            II rhsPersonalId;
            rhsPersonalId = that.getPersonalId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "personalId", lhsPersonalId), LocatorUtils.property(thatLocator, "personalId", rhsPersonalId), lhsPersonalId, rhsPersonalId)) {
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
            String lhsForskrivarkod;
            lhsForskrivarkod = this.getForskrivarkod();
            String rhsForskrivarkod;
            rhsForskrivarkod = that.getForskrivarkod();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "forskrivarkod", lhsForskrivarkod), LocatorUtils.property(thatLocator, "forskrivarkod", rhsForskrivarkod), lhsForskrivarkod, rhsForskrivarkod)) {
                return false;
            }
        }
        {
            EnhetType lhsEnhet;
            lhsEnhet = this.getEnhet();
            EnhetType rhsEnhet;
            rhsEnhet = that.getEnhet();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "enhet", lhsEnhet), LocatorUtils.property(thatLocator, "enhet", rhsEnhet), lhsEnhet, rhsEnhet)) {
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
            II thePersonalId;
            thePersonalId = this.getPersonalId();
            strategy.appendField(locator, this, "personalId", buffer, thePersonalId);
        }
        {
            String theFullstandigtNamn;
            theFullstandigtNamn = this.getFullstandigtNamn();
            strategy.appendField(locator, this, "fullstandigtNamn", buffer, theFullstandigtNamn);
        }
        {
            String theForskrivarkod;
            theForskrivarkod = this.getForskrivarkod();
            strategy.appendField(locator, this, "forskrivarkod", buffer, theForskrivarkod);
        }
        {
            EnhetType theEnhet;
            theEnhet = this.getEnhet();
            strategy.appendField(locator, this, "enhet", buffer, theEnhet);
        }
        {
            List<Object> theAny;
            theAny = (((this.any!= null)&&(!this.any.isEmpty()))?this.getAny():null);
            strategy.appendField(locator, this, "any", buffer, theAny);
        }
        return buffer;
    }

}
