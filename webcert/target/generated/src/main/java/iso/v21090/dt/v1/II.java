
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
 * <p>Java class for II complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="II">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:21090:dt:1}ANY">
 *       &lt;attribute name="root" type="{urn:iso:21090:dt:1}Uid" />
 *       &lt;attribute name="extension" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="identifierName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "II")
public class II
    extends ANY
    implements Equals, HashCode, ToString
{

    @XmlAttribute(name = "root")
    protected String root;
    @XmlAttribute(name = "extension")
    protected String extension;
    @XmlAttribute(name = "identifierName")
    protected String identifierName;

    /**
     * Gets the value of the root property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoot() {
        return root;
    }

    /**
     * Sets the value of the root property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoot(String value) {
        this.root = value;
    }

    /**
     * Gets the value of the extension property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Sets the value of the extension property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtension(String value) {
        this.extension = value;
    }

    /**
     * Gets the value of the identifierName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifierName() {
        return identifierName;
    }

    /**
     * Sets the value of the identifierName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifierName(String value) {
        this.identifierName = value;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            String theRoot;
            theRoot = this.getRoot();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "root", theRoot), currentHashCode, theRoot);
        }
        {
            String theExtension;
            theExtension = this.getExtension();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "extension", theExtension), currentHashCode, theExtension);
        }
        {
            String theIdentifierName;
            theIdentifierName = this.getIdentifierName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "identifierName", theIdentifierName), currentHashCode, theIdentifierName);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof II)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final II that = ((II) object);
        {
            String lhsRoot;
            lhsRoot = this.getRoot();
            String rhsRoot;
            rhsRoot = that.getRoot();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "root", lhsRoot), LocatorUtils.property(thatLocator, "root", rhsRoot), lhsRoot, rhsRoot)) {
                return false;
            }
        }
        {
            String lhsExtension;
            lhsExtension = this.getExtension();
            String rhsExtension;
            rhsExtension = that.getExtension();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "extension", lhsExtension), LocatorUtils.property(thatLocator, "extension", rhsExtension), lhsExtension, rhsExtension)) {
                return false;
            }
        }
        {
            String lhsIdentifierName;
            lhsIdentifierName = this.getIdentifierName();
            String rhsIdentifierName;
            rhsIdentifierName = that.getIdentifierName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "identifierName", lhsIdentifierName), LocatorUtils.property(thatLocator, "identifierName", rhsIdentifierName), lhsIdentifierName, rhsIdentifierName)) {
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
            String theRoot;
            theRoot = this.getRoot();
            strategy.appendField(locator, this, "root", buffer, theRoot);
        }
        {
            String theExtension;
            theExtension = this.getExtension();
            strategy.appendField(locator, this, "extension", buffer, theExtension);
        }
        {
            String theIdentifierName;
            theIdentifierName = this.getIdentifierName();
            strategy.appendField(locator, this, "identifierName", buffer, theIdentifierName);
        }
        return buffer;
    }

}
