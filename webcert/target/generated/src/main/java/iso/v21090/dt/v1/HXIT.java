
package iso.v21090.dt.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
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


/**
 * <p>Java class for HXIT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HXIT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="validTimeLow" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="validTimeHigh" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="controlActRoot" type="{urn:iso:21090:dt:1}Uid" />
 *       &lt;attribute name="controlActExtension" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HXIT")
@XmlSeeAlso({
    ANY.class
})
public abstract class HXIT
    implements Equals, HashCode, ToString
{

    @XmlAttribute(name = "validTimeLow")
    protected String validTimeLow;
    @XmlAttribute(name = "validTimeHigh")
    protected String validTimeHigh;
    @XmlAttribute(name = "controlActRoot")
    protected String controlActRoot;
    @XmlAttribute(name = "controlActExtension")
    protected String controlActExtension;

    /**
     * Gets the value of the validTimeLow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidTimeLow() {
        return validTimeLow;
    }

    /**
     * Sets the value of the validTimeLow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidTimeLow(String value) {
        this.validTimeLow = value;
    }

    /**
     * Gets the value of the validTimeHigh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidTimeHigh() {
        return validTimeHigh;
    }

    /**
     * Sets the value of the validTimeHigh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidTimeHigh(String value) {
        this.validTimeHigh = value;
    }

    /**
     * Gets the value of the controlActRoot property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getControlActRoot() {
        return controlActRoot;
    }

    /**
     * Sets the value of the controlActRoot property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setControlActRoot(String value) {
        this.controlActRoot = value;
    }

    /**
     * Gets the value of the controlActExtension property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getControlActExtension() {
        return controlActExtension;
    }

    /**
     * Sets the value of the controlActExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setControlActExtension(String value) {
        this.controlActExtension = value;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theValidTimeLow;
            theValidTimeLow = this.getValidTimeLow();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "validTimeLow", theValidTimeLow), currentHashCode, theValidTimeLow);
        }
        {
            String theValidTimeHigh;
            theValidTimeHigh = this.getValidTimeHigh();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "validTimeHigh", theValidTimeHigh), currentHashCode, theValidTimeHigh);
        }
        {
            String theControlActRoot;
            theControlActRoot = this.getControlActRoot();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "controlActRoot", theControlActRoot), currentHashCode, theControlActRoot);
        }
        {
            String theControlActExtension;
            theControlActExtension = this.getControlActExtension();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "controlActExtension", theControlActExtension), currentHashCode, theControlActExtension);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof HXIT)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final HXIT that = ((HXIT) object);
        {
            String lhsValidTimeLow;
            lhsValidTimeLow = this.getValidTimeLow();
            String rhsValidTimeLow;
            rhsValidTimeLow = that.getValidTimeLow();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "validTimeLow", lhsValidTimeLow), LocatorUtils.property(thatLocator, "validTimeLow", rhsValidTimeLow), lhsValidTimeLow, rhsValidTimeLow)) {
                return false;
            }
        }
        {
            String lhsValidTimeHigh;
            lhsValidTimeHigh = this.getValidTimeHigh();
            String rhsValidTimeHigh;
            rhsValidTimeHigh = that.getValidTimeHigh();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "validTimeHigh", lhsValidTimeHigh), LocatorUtils.property(thatLocator, "validTimeHigh", rhsValidTimeHigh), lhsValidTimeHigh, rhsValidTimeHigh)) {
                return false;
            }
        }
        {
            String lhsControlActRoot;
            lhsControlActRoot = this.getControlActRoot();
            String rhsControlActRoot;
            rhsControlActRoot = that.getControlActRoot();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "controlActRoot", lhsControlActRoot), LocatorUtils.property(thatLocator, "controlActRoot", rhsControlActRoot), lhsControlActRoot, rhsControlActRoot)) {
                return false;
            }
        }
        {
            String lhsControlActExtension;
            lhsControlActExtension = this.getControlActExtension();
            String rhsControlActExtension;
            rhsControlActExtension = that.getControlActExtension();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "controlActExtension", lhsControlActExtension), LocatorUtils.property(thatLocator, "controlActExtension", rhsControlActExtension), lhsControlActExtension, rhsControlActExtension)) {
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
            String theValidTimeLow;
            theValidTimeLow = this.getValidTimeLow();
            strategy.appendField(locator, this, "validTimeLow", buffer, theValidTimeLow);
        }
        {
            String theValidTimeHigh;
            theValidTimeHigh = this.getValidTimeHigh();
            strategy.appendField(locator, this, "validTimeHigh", buffer, theValidTimeHigh);
        }
        {
            String theControlActRoot;
            theControlActRoot = this.getControlActRoot();
            strategy.appendField(locator, this, "controlActRoot", buffer, theControlActRoot);
        }
        {
            String theControlActExtension;
            theControlActExtension = this.getControlActExtension();
            strategy.appendField(locator, this, "controlActExtension", buffer, theControlActExtension);
        }
        return buffer;
    }

}
