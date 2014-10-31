
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
 * 		        Datatyp som representerar användaren som utfört aktivitet, tillika ägare av loggpost.
 * 		    
 * 
 * <p>Java class for UserType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UserId" type="{urn:riv:ehr:log:1}HsaId"/>
 *         &lt;element name="Name" type="{urn:riv:ehr:log:1}UserName" minOccurs="0"/>
 *         &lt;element name="PersonId" type="{urn:riv:ehr:log:1}PersonId" minOccurs="0"/>
 *         &lt;element name="Assignment" type="{urn:riv:ehr:log:1}Assignment" minOccurs="0"/>
 *         &lt;element name="Title" type="{urn:riv:ehr:log:1}UserTitle" minOccurs="0"/>
 *         &lt;element name="CareProvider" type="{urn:riv:ehr:log:1}CareProviderType"/>
 *         &lt;element name="CareUnit" type="{urn:riv:ehr:log:1}CareUnitType"/>
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
@XmlType(name = "UserType", propOrder = {
    "userId",
    "name",
    "personId",
    "assignment",
    "title",
    "careProvider",
    "careUnit",
    "any"
})
public class UserType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "UserId", required = true)
    protected String userId;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "PersonId")
    protected String personId;
    @XmlElement(name = "Assignment")
    protected String assignment;
    @XmlElement(name = "Title")
    protected String title;
    @XmlElement(name = "CareProvider", required = true)
    protected CareProviderType careProvider;
    @XmlElement(name = "CareUnit", required = true)
    protected CareUnitType careUnit;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the personId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonId() {
        return personId;
    }

    /**
     * Sets the value of the personId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonId(String value) {
        this.personId = value;
    }

    /**
     * Gets the value of the assignment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssignment() {
        return assignment;
    }

    /**
     * Sets the value of the assignment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssignment(String value) {
        this.assignment = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
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
            String theUserId;
            theUserId = this.getUserId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userId", theUserId), currentHashCode, theUserId);
        }
        {
            String theName;
            theName = this.getName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "name", theName), currentHashCode, theName);
        }
        {
            String thePersonId;
            thePersonId = this.getPersonId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "personId", thePersonId), currentHashCode, thePersonId);
        }
        {
            String theAssignment;
            theAssignment = this.getAssignment();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "assignment", theAssignment), currentHashCode, theAssignment);
        }
        {
            String theTitle;
            theTitle = this.getTitle();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "title", theTitle), currentHashCode, theTitle);
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
        if (!(object instanceof UserType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final UserType that = ((UserType) object);
        {
            String lhsUserId;
            lhsUserId = this.getUserId();
            String rhsUserId;
            rhsUserId = that.getUserId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userId", lhsUserId), LocatorUtils.property(thatLocator, "userId", rhsUserId), lhsUserId, rhsUserId)) {
                return false;
            }
        }
        {
            String lhsName;
            lhsName = this.getName();
            String rhsName;
            rhsName = that.getName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "name", lhsName), LocatorUtils.property(thatLocator, "name", rhsName), lhsName, rhsName)) {
                return false;
            }
        }
        {
            String lhsPersonId;
            lhsPersonId = this.getPersonId();
            String rhsPersonId;
            rhsPersonId = that.getPersonId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "personId", lhsPersonId), LocatorUtils.property(thatLocator, "personId", rhsPersonId), lhsPersonId, rhsPersonId)) {
                return false;
            }
        }
        {
            String lhsAssignment;
            lhsAssignment = this.getAssignment();
            String rhsAssignment;
            rhsAssignment = that.getAssignment();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "assignment", lhsAssignment), LocatorUtils.property(thatLocator, "assignment", rhsAssignment), lhsAssignment, rhsAssignment)) {
                return false;
            }
        }
        {
            String lhsTitle;
            lhsTitle = this.getTitle();
            String rhsTitle;
            rhsTitle = that.getTitle();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "title", lhsTitle), LocatorUtils.property(thatLocator, "title", rhsTitle), lhsTitle, rhsTitle)) {
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
            String theUserId;
            theUserId = this.getUserId();
            strategy.appendField(locator, this, "userId", buffer, theUserId);
        }
        {
            String theName;
            theName = this.getName();
            strategy.appendField(locator, this, "name", buffer, theName);
        }
        {
            String thePersonId;
            thePersonId = this.getPersonId();
            strategy.appendField(locator, this, "personId", buffer, thePersonId);
        }
        {
            String theAssignment;
            theAssignment = this.getAssignment();
            strategy.appendField(locator, this, "assignment", buffer, theAssignment);
        }
        {
            String theTitle;
            theTitle = this.getTitle();
            strategy.appendField(locator, this, "title", buffer, theTitle);
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
