
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
 * 		        Datatyp som representerar en vårdgivare.
 * 		    
 * 
 * <p>Java class for CareProviderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CareProviderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CareProviderId" type="{urn:riv:ehr:log:1}HsaId"/>
 *         &lt;element name="CareProviderName" type="{urn:riv:ehr:log:1}CareProviderName" minOccurs="0"/>
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
@XmlType(name = "CareProviderType", propOrder = {
    "careProviderId",
    "careProviderName",
    "any"
})
public class CareProviderType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "CareProviderId", required = true)
    protected String careProviderId;
    @XmlElement(name = "CareProviderName")
    protected String careProviderName;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the careProviderId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCareProviderId() {
        return careProviderId;
    }

    /**
     * Sets the value of the careProviderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCareProviderId(String value) {
        this.careProviderId = value;
    }

    /**
     * Gets the value of the careProviderName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCareProviderName() {
        return careProviderName;
    }

    /**
     * Sets the value of the careProviderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCareProviderName(String value) {
        this.careProviderName = value;
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
            String theCareProviderId;
            theCareProviderId = this.getCareProviderId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "careProviderId", theCareProviderId), currentHashCode, theCareProviderId);
        }
        {
            String theCareProviderName;
            theCareProviderName = this.getCareProviderName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "careProviderName", theCareProviderName), currentHashCode, theCareProviderName);
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
        if (!(object instanceof CareProviderType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CareProviderType that = ((CareProviderType) object);
        {
            String lhsCareProviderId;
            lhsCareProviderId = this.getCareProviderId();
            String rhsCareProviderId;
            rhsCareProviderId = that.getCareProviderId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "careProviderId", lhsCareProviderId), LocatorUtils.property(thatLocator, "careProviderId", rhsCareProviderId), lhsCareProviderId, rhsCareProviderId)) {
                return false;
            }
        }
        {
            String lhsCareProviderName;
            lhsCareProviderName = this.getCareProviderName();
            String rhsCareProviderName;
            rhsCareProviderName = that.getCareProviderName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "careProviderName", lhsCareProviderName), LocatorUtils.property(thatLocator, "careProviderName", rhsCareProviderName), lhsCareProviderName, rhsCareProviderName)) {
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
            String theCareProviderId;
            theCareProviderId = this.getCareProviderId();
            strategy.appendField(locator, this, "careProviderId", buffer, theCareProviderId);
        }
        {
            String theCareProviderName;
            theCareProviderName = this.getCareProviderName();
            strategy.appendField(locator, this, "careProviderName", buffer, theCareProviderName);
        }
        {
            List<Object> theAny;
            theAny = (((this.any!= null)&&(!this.any.isEmpty()))?this.getAny():null);
            strategy.appendField(locator, this, "any", buffer, theAny);
        }
        return buffer;
    }

}
