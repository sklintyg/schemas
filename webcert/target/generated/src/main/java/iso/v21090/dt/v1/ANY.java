
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
 * <p>Java class for ANY complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ANY">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:21090:dt:1}HXIT">
 *       &lt;attribute name="nullFlavor" type="{urn:iso:21090:dt:1}NullFlavor" />
 *       &lt;attribute name="flavorId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="updateMode" type="{urn:iso:21090:dt:1}UpdateMode" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ANY")
@XmlSeeAlso({
    II.class,
    CD.class
})
public class ANY
    extends HXIT
    implements Equals, HashCode, ToString
{

    @XmlAttribute(name = "nullFlavor")
    protected NullFlavor nullFlavor;
    @XmlAttribute(name = "flavorId")
    protected String flavorId;
    @XmlAttribute(name = "updateMode")
    protected UpdateMode updateMode;

    /**
     * Gets the value of the nullFlavor property.
     * 
     * @return
     *     possible object is
     *     {@link NullFlavor }
     *     
     */
    public NullFlavor getNullFlavor() {
        return nullFlavor;
    }

    /**
     * Sets the value of the nullFlavor property.
     * 
     * @param value
     *     allowed object is
     *     {@link NullFlavor }
     *     
     */
    public void setNullFlavor(NullFlavor value) {
        this.nullFlavor = value;
    }

    /**
     * Gets the value of the flavorId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlavorId() {
        return flavorId;
    }

    /**
     * Sets the value of the flavorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlavorId(String value) {
        this.flavorId = value;
    }

    /**
     * Gets the value of the updateMode property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateMode }
     *     
     */
    public UpdateMode getUpdateMode() {
        return updateMode;
    }

    /**
     * Sets the value of the updateMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateMode }
     *     
     */
    public void setUpdateMode(UpdateMode value) {
        this.updateMode = value;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            NullFlavor theNullFlavor;
            theNullFlavor = this.getNullFlavor();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nullFlavor", theNullFlavor), currentHashCode, theNullFlavor);
        }
        {
            String theFlavorId;
            theFlavorId = this.getFlavorId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "flavorId", theFlavorId), currentHashCode, theFlavorId);
        }
        {
            UpdateMode theUpdateMode;
            theUpdateMode = this.getUpdateMode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "updateMode", theUpdateMode), currentHashCode, theUpdateMode);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ANY)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final ANY that = ((ANY) object);
        {
            NullFlavor lhsNullFlavor;
            lhsNullFlavor = this.getNullFlavor();
            NullFlavor rhsNullFlavor;
            rhsNullFlavor = that.getNullFlavor();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nullFlavor", lhsNullFlavor), LocatorUtils.property(thatLocator, "nullFlavor", rhsNullFlavor), lhsNullFlavor, rhsNullFlavor)) {
                return false;
            }
        }
        {
            String lhsFlavorId;
            lhsFlavorId = this.getFlavorId();
            String rhsFlavorId;
            rhsFlavorId = that.getFlavorId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "flavorId", lhsFlavorId), LocatorUtils.property(thatLocator, "flavorId", rhsFlavorId), lhsFlavorId, rhsFlavorId)) {
                return false;
            }
        }
        {
            UpdateMode lhsUpdateMode;
            lhsUpdateMode = this.getUpdateMode();
            UpdateMode rhsUpdateMode;
            rhsUpdateMode = that.getUpdateMode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "updateMode", lhsUpdateMode), LocatorUtils.property(thatLocator, "updateMode", rhsUpdateMode), lhsUpdateMode, rhsUpdateMode)) {
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
        super.appendFields(locator, buffer, strategy);
        {
            NullFlavor theNullFlavor;
            theNullFlavor = this.getNullFlavor();
            strategy.appendField(locator, this, "nullFlavor", buffer, theNullFlavor);
        }
        {
            String theFlavorId;
            theFlavorId = this.getFlavorId();
            strategy.appendField(locator, this, "flavorId", buffer, theFlavorId);
        }
        {
            UpdateMode theUpdateMode;
            theUpdateMode = this.getUpdateMode();
            strategy.appendField(locator, this, "updateMode", buffer, theUpdateMode);
        }
        return buffer;
    }

}
