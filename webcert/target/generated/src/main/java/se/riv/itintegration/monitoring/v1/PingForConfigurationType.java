
package se.riv.itintegration.monitoring.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 * <p>Java class for PingForConfigurationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PingForConfigurationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serviceContractNamespace" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="logicalAddress" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
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
@XmlType(name = "PingForConfigurationType", propOrder = {
    "serviceContractNamespace",
    "logicalAddress",
    "any"
})
public class PingForConfigurationType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String serviceContractNamespace;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String logicalAddress;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the serviceContractNamespace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceContractNamespace() {
        return serviceContractNamespace;
    }

    /**
     * Sets the value of the serviceContractNamespace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceContractNamespace(String value) {
        this.serviceContractNamespace = value;
    }

    /**
     * Gets the value of the logicalAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogicalAddress() {
        return logicalAddress;
    }

    /**
     * Sets the value of the logicalAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogicalAddress(String value) {
        this.logicalAddress = value;
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
            String theServiceContractNamespace;
            theServiceContractNamespace = this.getServiceContractNamespace();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "serviceContractNamespace", theServiceContractNamespace), currentHashCode, theServiceContractNamespace);
        }
        {
            String theLogicalAddress;
            theLogicalAddress = this.getLogicalAddress();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "logicalAddress", theLogicalAddress), currentHashCode, theLogicalAddress);
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
        if (!(object instanceof PingForConfigurationType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final PingForConfigurationType that = ((PingForConfigurationType) object);
        {
            String lhsServiceContractNamespace;
            lhsServiceContractNamespace = this.getServiceContractNamespace();
            String rhsServiceContractNamespace;
            rhsServiceContractNamespace = that.getServiceContractNamespace();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "serviceContractNamespace", lhsServiceContractNamespace), LocatorUtils.property(thatLocator, "serviceContractNamespace", rhsServiceContractNamespace), lhsServiceContractNamespace, rhsServiceContractNamespace)) {
                return false;
            }
        }
        {
            String lhsLogicalAddress;
            lhsLogicalAddress = this.getLogicalAddress();
            String rhsLogicalAddress;
            rhsLogicalAddress = that.getLogicalAddress();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "logicalAddress", lhsLogicalAddress), LocatorUtils.property(thatLocator, "logicalAddress", rhsLogicalAddress), lhsLogicalAddress, rhsLogicalAddress)) {
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
            String theServiceContractNamespace;
            theServiceContractNamespace = this.getServiceContractNamespace();
            strategy.appendField(locator, this, "serviceContractNamespace", buffer, theServiceContractNamespace);
        }
        {
            String theLogicalAddress;
            theLogicalAddress = this.getLogicalAddress();
            strategy.appendField(locator, this, "logicalAddress", buffer, theLogicalAddress);
        }
        {
            List<Object> theAny;
            theAny = (((this.any!= null)&&(!this.any.isEmpty()))?this.getAny():null);
            strategy.appendField(locator, this, "any", buffer, theAny);
        }
        return buffer;
    }

}
