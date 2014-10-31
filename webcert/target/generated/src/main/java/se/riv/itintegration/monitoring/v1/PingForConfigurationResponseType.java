
package se.riv.itintegration.monitoring.v1;

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
 * <p>Java class for PingForConfigurationResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PingForConfigurationResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pingDateTime" type="{urn:riv:itintegration:monitoring:1}TS"/>
 *         &lt;element name="configuration" type="{urn:riv:itintegration:monitoring:PingForConfigurationResponder:1}ConfigurationType" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "PingForConfigurationResponseType", propOrder = {
    "version",
    "pingDateTime",
    "configuration",
    "any"
})
public class PingForConfigurationResponseType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String version;
    @XmlElement(required = true)
    protected String pingDateTime;
    protected List<ConfigurationType> configuration;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the pingDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPingDateTime() {
        return pingDateTime;
    }

    /**
     * Sets the value of the pingDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPingDateTime(String value) {
        this.pingDateTime = value;
    }

    /**
     * Gets the value of the configuration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the configuration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConfiguration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConfigurationType }
     * 
     * 
     */
    public List<ConfigurationType> getConfiguration() {
        if (configuration == null) {
            configuration = new ArrayList<ConfigurationType>();
        }
        return this.configuration;
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
            String theVersion;
            theVersion = this.getVersion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "version", theVersion), currentHashCode, theVersion);
        }
        {
            String thePingDateTime;
            thePingDateTime = this.getPingDateTime();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pingDateTime", thePingDateTime), currentHashCode, thePingDateTime);
        }
        {
            List<ConfigurationType> theConfiguration;
            theConfiguration = (((this.configuration!= null)&&(!this.configuration.isEmpty()))?this.getConfiguration():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "configuration", theConfiguration), currentHashCode, theConfiguration);
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
        if (!(object instanceof PingForConfigurationResponseType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final PingForConfigurationResponseType that = ((PingForConfigurationResponseType) object);
        {
            String lhsVersion;
            lhsVersion = this.getVersion();
            String rhsVersion;
            rhsVersion = that.getVersion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "version", lhsVersion), LocatorUtils.property(thatLocator, "version", rhsVersion), lhsVersion, rhsVersion)) {
                return false;
            }
        }
        {
            String lhsPingDateTime;
            lhsPingDateTime = this.getPingDateTime();
            String rhsPingDateTime;
            rhsPingDateTime = that.getPingDateTime();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pingDateTime", lhsPingDateTime), LocatorUtils.property(thatLocator, "pingDateTime", rhsPingDateTime), lhsPingDateTime, rhsPingDateTime)) {
                return false;
            }
        }
        {
            List<ConfigurationType> lhsConfiguration;
            lhsConfiguration = (((this.configuration!= null)&&(!this.configuration.isEmpty()))?this.getConfiguration():null);
            List<ConfigurationType> rhsConfiguration;
            rhsConfiguration = (((that.configuration!= null)&&(!that.configuration.isEmpty()))?that.getConfiguration():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "configuration", lhsConfiguration), LocatorUtils.property(thatLocator, "configuration", rhsConfiguration), lhsConfiguration, rhsConfiguration)) {
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
            String theVersion;
            theVersion = this.getVersion();
            strategy.appendField(locator, this, "version", buffer, theVersion);
        }
        {
            String thePingDateTime;
            thePingDateTime = this.getPingDateTime();
            strategy.appendField(locator, this, "pingDateTime", buffer, thePingDateTime);
        }
        {
            List<ConfigurationType> theConfiguration;
            theConfiguration = (((this.configuration!= null)&&(!this.configuration.isEmpty()))?this.getConfiguration():null);
            strategy.appendField(locator, this, "configuration", buffer, theConfiguration);
        }
        {
            List<Object> theAny;
            theAny = (((this.any!= null)&&(!this.any.isEmpty()))?this.getAny():null);
            strategy.appendField(locator, this, "any", buffer, theAny);
        }
        return buffer;
    }

}
