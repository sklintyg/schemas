
package iso.v21090.dt.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 * <p>Java class for CD complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CD">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:21090:dt:1}ANY">
 *       &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="codeSystem" type="{urn:iso:21090:dt:1}Uid" />
 *       &lt;attribute name="codeSystemName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="codeSystemVersion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="displayName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CD")
public class CD
    extends ANY
    implements Equals, HashCode, ToString
{

    @XmlAttribute(name = "code")
    protected String code;
    @XmlAttribute(name = "codeSystem")
    protected String codeSystem;
    @XmlAttribute(name = "codeSystemName")
    protected String codeSystemName;
    @XmlAttribute(name = "codeSystemVersion")
    protected String codeSystemVersion;
    @XmlAttribute(name = "displayName")
    protected String displayName;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the codeSystem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeSystem() {
        return codeSystem;
    }

    /**
     * Sets the value of the codeSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeSystem(String value) {
        this.codeSystem = value;
    }

    /**
     * Gets the value of the codeSystemName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeSystemName() {
        return codeSystemName;
    }

    /**
     * Sets the value of the codeSystemName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeSystemName(String value) {
        this.codeSystemName = value;
    }

    /**
     * Gets the value of the codeSystemVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeSystemVersion() {
        return codeSystemVersion;
    }

    /**
     * Sets the value of the codeSystemVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeSystemVersion(String value) {
        this.codeSystemVersion = value;
    }

    /**
     * Gets the value of the displayName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the value of the displayName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayName(String value) {
        this.displayName = value;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            String theCode;
            theCode = this.getCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "code", theCode), currentHashCode, theCode);
        }
        {
            String theCodeSystem;
            theCodeSystem = this.getCodeSystem();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "codeSystem", theCodeSystem), currentHashCode, theCodeSystem);
        }
        {
            String theCodeSystemName;
            theCodeSystemName = this.getCodeSystemName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "codeSystemName", theCodeSystemName), currentHashCode, theCodeSystemName);
        }
        {
            String theCodeSystemVersion;
            theCodeSystemVersion = this.getCodeSystemVersion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "codeSystemVersion", theCodeSystemVersion), currentHashCode, theCodeSystemVersion);
        }
        {
            String theDisplayName;
            theDisplayName = this.getDisplayName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "displayName", theDisplayName), currentHashCode, theDisplayName);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CD)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final CD that = ((CD) object);
        {
            String lhsCode;
            lhsCode = this.getCode();
            String rhsCode;
            rhsCode = that.getCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "code", lhsCode), LocatorUtils.property(thatLocator, "code", rhsCode), lhsCode, rhsCode)) {
                return false;
            }
        }
        {
            String lhsCodeSystem;
            lhsCodeSystem = this.getCodeSystem();
            String rhsCodeSystem;
            rhsCodeSystem = that.getCodeSystem();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "codeSystem", lhsCodeSystem), LocatorUtils.property(thatLocator, "codeSystem", rhsCodeSystem), lhsCodeSystem, rhsCodeSystem)) {
                return false;
            }
        }
        {
            String lhsCodeSystemName;
            lhsCodeSystemName = this.getCodeSystemName();
            String rhsCodeSystemName;
            rhsCodeSystemName = that.getCodeSystemName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "codeSystemName", lhsCodeSystemName), LocatorUtils.property(thatLocator, "codeSystemName", rhsCodeSystemName), lhsCodeSystemName, rhsCodeSystemName)) {
                return false;
            }
        }
        {
            String lhsCodeSystemVersion;
            lhsCodeSystemVersion = this.getCodeSystemVersion();
            String rhsCodeSystemVersion;
            rhsCodeSystemVersion = that.getCodeSystemVersion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "codeSystemVersion", lhsCodeSystemVersion), LocatorUtils.property(thatLocator, "codeSystemVersion", rhsCodeSystemVersion), lhsCodeSystemVersion, rhsCodeSystemVersion)) {
                return false;
            }
        }
        {
            String lhsDisplayName;
            lhsDisplayName = this.getDisplayName();
            String rhsDisplayName;
            rhsDisplayName = that.getDisplayName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "displayName", lhsDisplayName), LocatorUtils.property(thatLocator, "displayName", rhsDisplayName), lhsDisplayName, rhsDisplayName)) {
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
            String theCode;
            theCode = this.getCode();
            strategy.appendField(locator, this, "code", buffer, theCode);
        }
        {
            String theCodeSystem;
            theCodeSystem = this.getCodeSystem();
            strategy.appendField(locator, this, "codeSystem", buffer, theCodeSystem);
        }
        {
            String theCodeSystemName;
            theCodeSystemName = this.getCodeSystemName();
            strategy.appendField(locator, this, "codeSystemName", buffer, theCodeSystemName);
        }
        {
            String theCodeSystemVersion;
            theCodeSystemVersion = this.getCodeSystemVersion();
            strategy.appendField(locator, this, "codeSystemVersion", buffer, theCodeSystemVersion);
        }
        {
            String theDisplayName;
            theDisplayName = this.getDisplayName();
            strategy.appendField(locator, this, "displayName", buffer, theDisplayName);
        }
        return buffer;
    }

}
