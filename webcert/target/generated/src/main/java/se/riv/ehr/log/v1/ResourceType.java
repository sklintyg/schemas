
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
 * 		        Datatyp som representerar en resurs i loggposten.
 * 		    
 * 
 * <p>Java class for ResourceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResourceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResourceType" type="{urn:riv:ehr:log:1}ResourceTypeValue"/>
 *         &lt;element name="Patient" type="{urn:riv:ehr:log:1}PatientType" minOccurs="0"/>
 *         &lt;element name="CareProvider" type="{urn:riv:ehr:log:1}CareProviderType"/>
 *         &lt;element name="CareUnit" type="{urn:riv:ehr:log:1}CareUnitType" minOccurs="0"/>
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
@XmlType(name = "ResourceType", propOrder = {
    "resourceType",
    "patient",
    "careProvider",
    "careUnit",
    "any"
})
public class ResourceType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "ResourceType", required = true)
    protected String resourceType;
    @XmlElement(name = "Patient")
    protected PatientType patient;
    @XmlElement(name = "CareProvider", required = true)
    protected CareProviderType careProvider;
    @XmlElement(name = "CareUnit")
    protected CareUnitType careUnit;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the resourceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     * Sets the value of the resourceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResourceType(String value) {
        this.resourceType = value;
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
     * Gets the value of the careProvider property.
     * 
     * @return
     *     possible object is
     *     {@link CareProviderType }
     *     
     */
    public CareProviderType getCareProvider() {
        return careProvider;
    }

    /**
     * Sets the value of the careProvider property.
     * 
     * @param value
     *     allowed object is
     *     {@link CareProviderType }
     *     
     */
    public void setCareProvider(CareProviderType value) {
        this.careProvider = value;
    }

    /**
     * Gets the value of the careUnit property.
     * 
     * @return
     *     possible object is
     *     {@link CareUnitType }
     *     
     */
    public CareUnitType getCareUnit() {
        return careUnit;
    }

    /**
     * Sets the value of the careUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link CareUnitType }
     *     
     */
    public void setCareUnit(CareUnitType value) {
        this.careUnit = value;
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
            String theResourceType;
            theResourceType = this.getResourceType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "resourceType", theResourceType), currentHashCode, theResourceType);
        }
        {
            PatientType thePatient;
            thePatient = this.getPatient();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "patient", thePatient), currentHashCode, thePatient);
        }
        {
            CareProviderType theCareProvider;
            theCareProvider = this.getCareProvider();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "careProvider", theCareProvider), currentHashCode, theCareProvider);
        }
        {
            CareUnitType theCareUnit;
            theCareUnit = this.getCareUnit();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "careUnit", theCareUnit), currentHashCode, theCareUnit);
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
        if (!(object instanceof ResourceType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ResourceType that = ((ResourceType) object);
        {
            String lhsResourceType;
            lhsResourceType = this.getResourceType();
            String rhsResourceType;
            rhsResourceType = that.getResourceType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "resourceType", lhsResourceType), LocatorUtils.property(thatLocator, "resourceType", rhsResourceType), lhsResourceType, rhsResourceType)) {
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
            CareProviderType lhsCareProvider;
            lhsCareProvider = this.getCareProvider();
            CareProviderType rhsCareProvider;
            rhsCareProvider = that.getCareProvider();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "careProvider", lhsCareProvider), LocatorUtils.property(thatLocator, "careProvider", rhsCareProvider), lhsCareProvider, rhsCareProvider)) {
                return false;
            }
        }
        {
            CareUnitType lhsCareUnit;
            lhsCareUnit = this.getCareUnit();
            CareUnitType rhsCareUnit;
            rhsCareUnit = that.getCareUnit();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "careUnit", lhsCareUnit), LocatorUtils.property(thatLocator, "careUnit", rhsCareUnit), lhsCareUnit, rhsCareUnit)) {
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
            String theResourceType;
            theResourceType = this.getResourceType();
            strategy.appendField(locator, this, "resourceType", buffer, theResourceType);
        }
        {
            PatientType thePatient;
            thePatient = this.getPatient();
            strategy.appendField(locator, this, "patient", buffer, thePatient);
        }
        {
            CareProviderType theCareProvider;
            theCareProvider = this.getCareProvider();
            strategy.appendField(locator, this, "careProvider", buffer, theCareProvider);
        }
        {
            CareUnitType theCareUnit;
            theCareUnit = this.getCareUnit();
            strategy.appendField(locator, this, "careUnit", buffer, theCareUnit);
        }
        {
            List<Object> theAny;
            theAny = (((this.any!= null)&&(!this.any.isEmpty()))?this.getAny():null);
            strategy.appendField(locator, this, "any", buffer, theAny);
        }
        return buffer;
    }

}
