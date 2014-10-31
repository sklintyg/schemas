
package se.riv.ehr.log.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
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
 * 
 * 		        Datatyp som representerar en vårdenhet.
 * 		    
 * 
 * <p>Java class for CareUnitType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CareUnitType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CareUnitId" type="{urn:riv:ehr:log:1}HsaId"/>
 *         &lt;element name="CareUnitName" type="{urn:riv:ehr:log:1}CareUnitName" minOccurs="0"/>
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
@XmlType(name = "CareUnitType", propOrder = {
    "careUnitId",
    "careUnitName",
    "any"
})
public class CareUnitType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "CareUnitId", required = true)
    protected String careUnitId;
    @XmlElement(name = "CareUnitName")
    protected String careUnitName;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the careUnitId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCareUnitId() {
        return careUnitId;
    }

    /**
     * Sets the value of the careUnitId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCareUnitId(String value) {
        this.careUnitId = value;
    }

    /**
     * Gets the value of the careUnitName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCareUnitName() {
        return careUnitName;
    }

    /**
     * Sets the value of the careUnitName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCareUnitName(String value) {
        this.careUnitName = value;
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
            String theCareUnitId;
            theCareUnitId = this.getCareUnitId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "careUnitId", theCareUnitId), currentHashCode, theCareUnitId);
        }
        {
            String theCareUnitName;
            theCareUnitName = this.getCareUnitName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "careUnitName", theCareUnitName), currentHashCode, theCareUnitName);
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
        if (!(object instanceof CareUnitType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CareUnitType that = ((CareUnitType) object);
        {
            String lhsCareUnitId;
            lhsCareUnitId = this.getCareUnitId();
            String rhsCareUnitId;
            rhsCareUnitId = that.getCareUnitId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "careUnitId", lhsCareUnitId), LocatorUtils.property(thatLocator, "careUnitId", rhsCareUnitId), lhsCareUnitId, rhsCareUnitId)) {
                return false;
            }
        }
        {
            String lhsCareUnitName;
            lhsCareUnitName = this.getCareUnitName();
            String rhsCareUnitName;
            rhsCareUnitName = that.getCareUnitName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "careUnitName", lhsCareUnitName), LocatorUtils.property(thatLocator, "careUnitName", rhsCareUnitName), lhsCareUnitName, rhsCareUnitName)) {
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
            String theCareUnitId;
            theCareUnitId = this.getCareUnitId();
            strategy.appendField(locator, this, "careUnitId", buffer, theCareUnitId);
        }
        {
            String theCareUnitName;
            theCareUnitName = this.getCareUnitName();
            strategy.appendField(locator, this, "careUnitName", buffer, theCareUnitName);
        }
        {
            List<Object> theAny;
            theAny = (((this.any!= null)&&(!this.any.isEmpty()))?this.getAny():null);
            strategy.appendField(locator, this, "any", buffer, theAny);
        }
        return buffer;
    }

}
