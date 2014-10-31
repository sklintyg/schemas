
package se.riv.ehr.log.v1;

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


/**
 * 
 * 		        Datatyp som representerar vilken typ av aktivitet som utförts, på vilken nivå, tidpunkt samt syftet med aktiviteten.
 * 		    
 * 
 * <p>Java class for ActivityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActivityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ActivityType" type="{urn:riv:ehr:log:1}ActivityTypeValue"/>
 *         &lt;element name="ActivityLevel" type="{urn:riv:ehr:log:1}ActivityLevel" minOccurs="0"/>
 *         &lt;element name="ActivityArgs" type="{urn:riv:ehr:log:1}ActivityArgs" minOccurs="0"/>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Purpose" type="{urn:riv:ehr:log:1}PurposeDescription"/>
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
@XmlType(name = "ActivityType", propOrder = {
    "activityType",
    "activityLevel",
    "activityArgs",
    "startDate",
    "purpose",
    "any"
})
public class ActivityType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "ActivityType", required = true)
    protected String activityType;
    @XmlElement(name = "ActivityLevel")
    protected String activityLevel;
    @XmlElement(name = "ActivityArgs")
    protected String activityArgs;
    @XmlElement(name = "StartDate", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected LocalDateTime startDate;
    @XmlElement(name = "Purpose", required = true)
    protected String purpose;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the activityType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityType() {
        return activityType;
    }

    /**
     * Sets the value of the activityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityType(String value) {
        this.activityType = value;
    }

    /**
     * Gets the value of the activityLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityLevel() {
        return activityLevel;
    }

    /**
     * Sets the value of the activityLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityLevel(String value) {
        this.activityLevel = value;
    }

    /**
     * Gets the value of the activityArgs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityArgs() {
        return activityArgs;
    }

    /**
     * Sets the value of the activityArgs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityArgs(String value) {
        this.activityArgs = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDateTime getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(LocalDateTime value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the purpose property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * Sets the value of the purpose property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurpose(String value) {
        this.purpose = value;
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
            String theActivityType;
            theActivityType = this.getActivityType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "activityType", theActivityType), currentHashCode, theActivityType);
        }
        {
            String theActivityLevel;
            theActivityLevel = this.getActivityLevel();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "activityLevel", theActivityLevel), currentHashCode, theActivityLevel);
        }
        {
            String theActivityArgs;
            theActivityArgs = this.getActivityArgs();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "activityArgs", theActivityArgs), currentHashCode, theActivityArgs);
        }
        {
            LocalDateTime theStartDate;
            theStartDate = this.getStartDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "startDate", theStartDate), currentHashCode, theStartDate);
        }
        {
            String thePurpose;
            thePurpose = this.getPurpose();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "purpose", thePurpose), currentHashCode, thePurpose);
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
        if (!(object instanceof ActivityType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ActivityType that = ((ActivityType) object);
        {
            String lhsActivityType;
            lhsActivityType = this.getActivityType();
            String rhsActivityType;
            rhsActivityType = that.getActivityType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "activityType", lhsActivityType), LocatorUtils.property(thatLocator, "activityType", rhsActivityType), lhsActivityType, rhsActivityType)) {
                return false;
            }
        }
        {
            String lhsActivityLevel;
            lhsActivityLevel = this.getActivityLevel();
            String rhsActivityLevel;
            rhsActivityLevel = that.getActivityLevel();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "activityLevel", lhsActivityLevel), LocatorUtils.property(thatLocator, "activityLevel", rhsActivityLevel), lhsActivityLevel, rhsActivityLevel)) {
                return false;
            }
        }
        {
            String lhsActivityArgs;
            lhsActivityArgs = this.getActivityArgs();
            String rhsActivityArgs;
            rhsActivityArgs = that.getActivityArgs();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "activityArgs", lhsActivityArgs), LocatorUtils.property(thatLocator, "activityArgs", rhsActivityArgs), lhsActivityArgs, rhsActivityArgs)) {
                return false;
            }
        }
        {
            LocalDateTime lhsStartDate;
            lhsStartDate = this.getStartDate();
            LocalDateTime rhsStartDate;
            rhsStartDate = that.getStartDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "startDate", lhsStartDate), LocatorUtils.property(thatLocator, "startDate", rhsStartDate), lhsStartDate, rhsStartDate)) {
                return false;
            }
        }
        {
            String lhsPurpose;
            lhsPurpose = this.getPurpose();
            String rhsPurpose;
            rhsPurpose = that.getPurpose();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "purpose", lhsPurpose), LocatorUtils.property(thatLocator, "purpose", rhsPurpose), lhsPurpose, rhsPurpose)) {
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
            String theActivityType;
            theActivityType = this.getActivityType();
            strategy.appendField(locator, this, "activityType", buffer, theActivityType);
        }
        {
            String theActivityLevel;
            theActivityLevel = this.getActivityLevel();
            strategy.appendField(locator, this, "activityLevel", buffer, theActivityLevel);
        }
        {
            String theActivityArgs;
            theActivityArgs = this.getActivityArgs();
            strategy.appendField(locator, this, "activityArgs", buffer, theActivityArgs);
        }
        {
            LocalDateTime theStartDate;
            theStartDate = this.getStartDate();
            strategy.appendField(locator, this, "startDate", buffer, theStartDate);
        }
        {
            String thePurpose;
            thePurpose = this.getPurpose();
            strategy.appendField(locator, this, "purpose", buffer, thePurpose);
        }
        {
            List<Object> theAny;
            theAny = (((this.any!= null)&&(!this.any.isEmpty()))?this.getAny():null);
            strategy.appendField(locator, this, "any", buffer, theAny);
        }
        return buffer;
    }

}
