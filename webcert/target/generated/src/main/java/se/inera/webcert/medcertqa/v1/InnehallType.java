
package se.inera.webcert.medcertqa.v1;

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
 * <p>Java class for innehallType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="innehallType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="meddelandeText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="signeringsTidpunkt" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
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
@XmlType(name = "innehallType", propOrder = {
    "meddelandeText",
    "signeringsTidpunkt",
    "any"
})
public class InnehallType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String meddelandeText;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected LocalDateTime signeringsTidpunkt;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the meddelandeText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeddelandeText() {
        return meddelandeText;
    }

    /**
     * Sets the value of the meddelandeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeddelandeText(String value) {
        this.meddelandeText = value;
    }

    /**
     * Gets the value of the signeringsTidpunkt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDateTime getSigneringsTidpunkt() {
        return signeringsTidpunkt;
    }

    /**
     * Sets the value of the signeringsTidpunkt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSigneringsTidpunkt(LocalDateTime value) {
        this.signeringsTidpunkt = value;
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
            String theMeddelandeText;
            theMeddelandeText = this.getMeddelandeText();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "meddelandeText", theMeddelandeText), currentHashCode, theMeddelandeText);
        }
        {
            LocalDateTime theSigneringsTidpunkt;
            theSigneringsTidpunkt = this.getSigneringsTidpunkt();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signeringsTidpunkt", theSigneringsTidpunkt), currentHashCode, theSigneringsTidpunkt);
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
        if (!(object instanceof InnehallType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final InnehallType that = ((InnehallType) object);
        {
            String lhsMeddelandeText;
            lhsMeddelandeText = this.getMeddelandeText();
            String rhsMeddelandeText;
            rhsMeddelandeText = that.getMeddelandeText();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "meddelandeText", lhsMeddelandeText), LocatorUtils.property(thatLocator, "meddelandeText", rhsMeddelandeText), lhsMeddelandeText, rhsMeddelandeText)) {
                return false;
            }
        }
        {
            LocalDateTime lhsSigneringsTidpunkt;
            lhsSigneringsTidpunkt = this.getSigneringsTidpunkt();
            LocalDateTime rhsSigneringsTidpunkt;
            rhsSigneringsTidpunkt = that.getSigneringsTidpunkt();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "signeringsTidpunkt", lhsSigneringsTidpunkt), LocatorUtils.property(thatLocator, "signeringsTidpunkt", rhsSigneringsTidpunkt), lhsSigneringsTidpunkt, rhsSigneringsTidpunkt)) {
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
            String theMeddelandeText;
            theMeddelandeText = this.getMeddelandeText();
            strategy.appendField(locator, this, "meddelandeText", buffer, theMeddelandeText);
        }
        {
            LocalDateTime theSigneringsTidpunkt;
            theSigneringsTidpunkt = this.getSigneringsTidpunkt();
            strategy.appendField(locator, this, "signeringsTidpunkt", buffer, theSigneringsTidpunkt);
        }
        {
            List<Object> theAny;
            theAny = (((this.any!= null)&&(!this.any.isEmpty()))?this.getAny():null);
            strategy.appendField(locator, this, "any", buffer, theAny);
        }
        return buffer;
    }

}
