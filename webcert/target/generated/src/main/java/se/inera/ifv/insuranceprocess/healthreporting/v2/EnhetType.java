
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
 * <p>Java class for enhetType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="enhetType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enhets-id" type="{urn:iso:21090:dt:1}II"/>
 *         &lt;element name="arbetsplatskod" type="{urn:iso:21090:dt:1}II" minOccurs="0"/>
 *         &lt;element name="enhetsnamn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="postadress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postnummer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telefonnummer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="epost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vardgivare" type="{urn:riv:insuranceprocess:healthreporting:2}vardgivareType" minOccurs="0"/>
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
@XmlType(name = "enhetType", propOrder = {
    "enhetsId",
    "arbetsplatskod",
    "enhetsnamn",
    "postadress",
    "postnummer",
    "postort",
    "telefonnummer",
    "epost",
    "vardgivare",
    "any"
})
public class EnhetType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "enhets-id", required = true)
    protected II enhetsId;
    protected II arbetsplatskod;
    @XmlElement(required = true)
    protected String enhetsnamn;
    protected String postadress;
    protected String postnummer;
    protected String postort;
    protected String telefonnummer;
    protected String epost;
    protected VardgivareType vardgivare;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the enhetsId property.
     * 
     * @return
     *     possible object is
     *     {@link II }
     *     
     */
    public II getEnhetsId() {
        return enhetsId;
    }

    /**
     * Sets the value of the enhetsId property.
     * 
     * @param value
     *     allowed object is
     *     {@link II }
     *     
     */
    public void setEnhetsId(II value) {
        this.enhetsId = value;
    }

    /**
     * Gets the value of the arbetsplatskod property.
     * 
     * @return
     *     possible object is
     *     {@link II }
     *     
     */
    public II getArbetsplatskod() {
        return arbetsplatskod;
    }

    /**
     * Sets the value of the arbetsplatskod property.
     * 
     * @param value
     *     allowed object is
     *     {@link II }
     *     
     */
    public void setArbetsplatskod(II value) {
        this.arbetsplatskod = value;
    }

    /**
     * Gets the value of the enhetsnamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnhetsnamn() {
        return enhetsnamn;
    }

    /**
     * Sets the value of the enhetsnamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnhetsnamn(String value) {
        this.enhetsnamn = value;
    }

    /**
     * Gets the value of the postadress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostadress() {
        return postadress;
    }

    /**
     * Sets the value of the postadress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostadress(String value) {
        this.postadress = value;
    }

    /**
     * Gets the value of the postnummer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostnummer() {
        return postnummer;
    }

    /**
     * Sets the value of the postnummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostnummer(String value) {
        this.postnummer = value;
    }

    /**
     * Gets the value of the postort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostort() {
        return postort;
    }

    /**
     * Sets the value of the postort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostort(String value) {
        this.postort = value;
    }

    /**
     * Gets the value of the telefonnummer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefonnummer() {
        return telefonnummer;
    }

    /**
     * Sets the value of the telefonnummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefonnummer(String value) {
        this.telefonnummer = value;
    }

    /**
     * Gets the value of the epost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEpost() {
        return epost;
    }

    /**
     * Sets the value of the epost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEpost(String value) {
        this.epost = value;
    }

    /**
     * Gets the value of the vardgivare property.
     * 
     * @return
     *     possible object is
     *     {@link VardgivareType }
     *     
     */
    public VardgivareType getVardgivare() {
        return vardgivare;
    }

    /**
     * Sets the value of the vardgivare property.
     * 
     * @param value
     *     allowed object is
     *     {@link VardgivareType }
     *     
     */
    public void setVardgivare(VardgivareType value) {
        this.vardgivare = value;
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
            II theEnhetsId;
            theEnhetsId = this.getEnhetsId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "enhetsId", theEnhetsId), currentHashCode, theEnhetsId);
        }
        {
            II theArbetsplatskod;
            theArbetsplatskod = this.getArbetsplatskod();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "arbetsplatskod", theArbetsplatskod), currentHashCode, theArbetsplatskod);
        }
        {
            String theEnhetsnamn;
            theEnhetsnamn = this.getEnhetsnamn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "enhetsnamn", theEnhetsnamn), currentHashCode, theEnhetsnamn);
        }
        {
            String thePostadress;
            thePostadress = this.getPostadress();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "postadress", thePostadress), currentHashCode, thePostadress);
        }
        {
            String thePostnummer;
            thePostnummer = this.getPostnummer();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "postnummer", thePostnummer), currentHashCode, thePostnummer);
        }
        {
            String thePostort;
            thePostort = this.getPostort();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "postort", thePostort), currentHashCode, thePostort);
        }
        {
            String theTelefonnummer;
            theTelefonnummer = this.getTelefonnummer();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "telefonnummer", theTelefonnummer), currentHashCode, theTelefonnummer);
        }
        {
            String theEpost;
            theEpost = this.getEpost();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "epost", theEpost), currentHashCode, theEpost);
        }
        {
            VardgivareType theVardgivare;
            theVardgivare = this.getVardgivare();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "vardgivare", theVardgivare), currentHashCode, theVardgivare);
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
        if (!(object instanceof EnhetType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final EnhetType that = ((EnhetType) object);
        {
            II lhsEnhetsId;
            lhsEnhetsId = this.getEnhetsId();
            II rhsEnhetsId;
            rhsEnhetsId = that.getEnhetsId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "enhetsId", lhsEnhetsId), LocatorUtils.property(thatLocator, "enhetsId", rhsEnhetsId), lhsEnhetsId, rhsEnhetsId)) {
                return false;
            }
        }
        {
            II lhsArbetsplatskod;
            lhsArbetsplatskod = this.getArbetsplatskod();
            II rhsArbetsplatskod;
            rhsArbetsplatskod = that.getArbetsplatskod();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "arbetsplatskod", lhsArbetsplatskod), LocatorUtils.property(thatLocator, "arbetsplatskod", rhsArbetsplatskod), lhsArbetsplatskod, rhsArbetsplatskod)) {
                return false;
            }
        }
        {
            String lhsEnhetsnamn;
            lhsEnhetsnamn = this.getEnhetsnamn();
            String rhsEnhetsnamn;
            rhsEnhetsnamn = that.getEnhetsnamn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "enhetsnamn", lhsEnhetsnamn), LocatorUtils.property(thatLocator, "enhetsnamn", rhsEnhetsnamn), lhsEnhetsnamn, rhsEnhetsnamn)) {
                return false;
            }
        }
        {
            String lhsPostadress;
            lhsPostadress = this.getPostadress();
            String rhsPostadress;
            rhsPostadress = that.getPostadress();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "postadress", lhsPostadress), LocatorUtils.property(thatLocator, "postadress", rhsPostadress), lhsPostadress, rhsPostadress)) {
                return false;
            }
        }
        {
            String lhsPostnummer;
            lhsPostnummer = this.getPostnummer();
            String rhsPostnummer;
            rhsPostnummer = that.getPostnummer();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "postnummer", lhsPostnummer), LocatorUtils.property(thatLocator, "postnummer", rhsPostnummer), lhsPostnummer, rhsPostnummer)) {
                return false;
            }
        }
        {
            String lhsPostort;
            lhsPostort = this.getPostort();
            String rhsPostort;
            rhsPostort = that.getPostort();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "postort", lhsPostort), LocatorUtils.property(thatLocator, "postort", rhsPostort), lhsPostort, rhsPostort)) {
                return false;
            }
        }
        {
            String lhsTelefonnummer;
            lhsTelefonnummer = this.getTelefonnummer();
            String rhsTelefonnummer;
            rhsTelefonnummer = that.getTelefonnummer();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "telefonnummer", lhsTelefonnummer), LocatorUtils.property(thatLocator, "telefonnummer", rhsTelefonnummer), lhsTelefonnummer, rhsTelefonnummer)) {
                return false;
            }
        }
        {
            String lhsEpost;
            lhsEpost = this.getEpost();
            String rhsEpost;
            rhsEpost = that.getEpost();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "epost", lhsEpost), LocatorUtils.property(thatLocator, "epost", rhsEpost), lhsEpost, rhsEpost)) {
                return false;
            }
        }
        {
            VardgivareType lhsVardgivare;
            lhsVardgivare = this.getVardgivare();
            VardgivareType rhsVardgivare;
            rhsVardgivare = that.getVardgivare();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "vardgivare", lhsVardgivare), LocatorUtils.property(thatLocator, "vardgivare", rhsVardgivare), lhsVardgivare, rhsVardgivare)) {
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
            II theEnhetsId;
            theEnhetsId = this.getEnhetsId();
            strategy.appendField(locator, this, "enhetsId", buffer, theEnhetsId);
        }
        {
            II theArbetsplatskod;
            theArbetsplatskod = this.getArbetsplatskod();
            strategy.appendField(locator, this, "arbetsplatskod", buffer, theArbetsplatskod);
        }
        {
            String theEnhetsnamn;
            theEnhetsnamn = this.getEnhetsnamn();
            strategy.appendField(locator, this, "enhetsnamn", buffer, theEnhetsnamn);
        }
        {
            String thePostadress;
            thePostadress = this.getPostadress();
            strategy.appendField(locator, this, "postadress", buffer, thePostadress);
        }
        {
            String thePostnummer;
            thePostnummer = this.getPostnummer();
            strategy.appendField(locator, this, "postnummer", buffer, thePostnummer);
        }
        {
            String thePostort;
            thePostort = this.getPostort();
            strategy.appendField(locator, this, "postort", buffer, thePostort);
        }
        {
            String theTelefonnummer;
            theTelefonnummer = this.getTelefonnummer();
            strategy.appendField(locator, this, "telefonnummer", buffer, theTelefonnummer);
        }
        {
            String theEpost;
            theEpost = this.getEpost();
            strategy.appendField(locator, this, "epost", buffer, theEpost);
        }
        {
            VardgivareType theVardgivare;
            theVardgivare = this.getVardgivare();
            strategy.appendField(locator, this, "vardgivare", buffer, theVardgivare);
        }
        {
            List<Object> theAny;
            theAny = (((this.any!= null)&&(!this.any.isEmpty()))?this.getAny():null);
            strategy.appendField(locator, this, "any", buffer, theAny);
        }
        return buffer;
    }

}
