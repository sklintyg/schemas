
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
 * 		        Datatyp som representerar en loggpost enligt PDL. Datatypen beskriver grundformatet för en loggpost.
 * 		    
 * 
 * <p>Java class for LogType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LogType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LogId" type="{urn:riv:ehr:log:1}Id"/>
 *         &lt;element name="System" type="{urn:riv:ehr:log:1}SystemType"/>
 *         &lt;element name="Activity" type="{urn:riv:ehr:log:1}ActivityType"/>
 *         &lt;element name="User" type="{urn:riv:ehr:log:1}UserType"/>
 *         &lt;element name="Resources" type="{urn:riv:ehr:log:1}ResourcesType"/>
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
@XmlType(name = "LogType", propOrder = {
    "logId",
    "system",
    "activity",
    "user",
    "resources",
    "any"
})
public class LogType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "LogId", required = true)
    protected String logId;
    @XmlElement(name = "System", required = true)
    protected SystemType system;
    @XmlElement(name = "Activity", required = true)
    protected ActivityType activity;
    @XmlElement(name = "User", required = true)
    protected UserType user;
    @XmlElement(name = "Resources", required = true)
    protected ResourcesType resources;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the logId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogId() {
        return logId;
    }

    /**
     * Sets the value of the logId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogId(String value) {
        this.logId = value;
    }

    /**
     * Gets the value of the system property.
     * 
     * @return
     *     possible object is
     *     {@link SystemType }
     *     
     */
    public SystemType getSystem() {
        return system;
    }

    /**
     * Sets the value of the system property.
     * 
     * @param value
     *     allowed object is
     *     {@link SystemType }
     *     
     */
    public void setSystem(SystemType value) {
        this.system = value;
    }

    /**
     * Gets the value of the activity property.
     * 
     * @return
     *     possible object is
     *     {@link ActivityType }
     *     
     */
    public ActivityType getActivity() {
        return activity;
    }

    /**
     * Sets the value of the activity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivityType }
     *     
     */
    public void setActivity(ActivityType value) {
        this.activity = value;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link UserType }
     *     
     */
    public UserType getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserType }
     *     
     */
    public void setUser(UserType value) {
        this.user = value;
    }

    /**
     * Gets the value of the resources property.
     * 
     * @return
     *     possible object is
     *     {@link ResourcesType }
     *     
     */
    public ResourcesType getResources() {
        return resources;
    }

    /**
     * Sets the value of the resources property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourcesType }
     *     
     */
    public void setResources(ResourcesType value) {
        this.resources = value;
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
            String theLogId;
            theLogId = this.getLogId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "logId", theLogId), currentHashCode, theLogId);
        }
        {
            SystemType theSystem;
            theSystem = this.getSystem();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "system", theSystem), currentHashCode, theSystem);
        }
        {
            ActivityType theActivity;
            theActivity = this.getActivity();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "activity", theActivity), currentHashCode, theActivity);
        }
        {
            UserType theUser;
            theUser = this.getUser();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "user", theUser), currentHashCode, theUser);
        }
        {
            ResourcesType theResources;
            theResources = this.getResources();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "resources", theResources), currentHashCode, theResources);
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
        if (!(object instanceof LogType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final LogType that = ((LogType) object);
        {
            String lhsLogId;
            lhsLogId = this.getLogId();
            String rhsLogId;
            rhsLogId = that.getLogId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "logId", lhsLogId), LocatorUtils.property(thatLocator, "logId", rhsLogId), lhsLogId, rhsLogId)) {
                return false;
            }
        }
        {
            SystemType lhsSystem;
            lhsSystem = this.getSystem();
            SystemType rhsSystem;
            rhsSystem = that.getSystem();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "system", lhsSystem), LocatorUtils.property(thatLocator, "system", rhsSystem), lhsSystem, rhsSystem)) {
                return false;
            }
        }
        {
            ActivityType lhsActivity;
            lhsActivity = this.getActivity();
            ActivityType rhsActivity;
            rhsActivity = that.getActivity();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "activity", lhsActivity), LocatorUtils.property(thatLocator, "activity", rhsActivity), lhsActivity, rhsActivity)) {
                return false;
            }
        }
        {
            UserType lhsUser;
            lhsUser = this.getUser();
            UserType rhsUser;
            rhsUser = that.getUser();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "user", lhsUser), LocatorUtils.property(thatLocator, "user", rhsUser), lhsUser, rhsUser)) {
                return false;
            }
        }
        {
            ResourcesType lhsResources;
            lhsResources = this.getResources();
            ResourcesType rhsResources;
            rhsResources = that.getResources();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "resources", lhsResources), LocatorUtils.property(thatLocator, "resources", rhsResources), lhsResources, rhsResources)) {
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
            String theLogId;
            theLogId = this.getLogId();
            strategy.appendField(locator, this, "logId", buffer, theLogId);
        }
        {
            SystemType theSystem;
            theSystem = this.getSystem();
            strategy.appendField(locator, this, "system", buffer, theSystem);
        }
        {
            ActivityType theActivity;
            theActivity = this.getActivity();
            strategy.appendField(locator, this, "activity", buffer, theActivity);
        }
        {
            UserType theUser;
            theUser = this.getUser();
            strategy.appendField(locator, this, "user", buffer, theUser);
        }
        {
            ResourcesType theResources;
            theResources = this.getResources();
            strategy.appendField(locator, this, "resources", buffer, theResources);
        }
        {
            List<Object> theAny;
            theAny = (((this.any!= null)&&(!this.any.isEmpty()))?this.getAny():null);
            strategy.appendField(locator, this, "any", buffer, theAny);
        }
        return buffer;
    }

}
