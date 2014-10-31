
package se.inera.ifv.insuranceprocess.healthreporting.v2;

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
 * 				Holds information about the success of the call. If INFO is set the field infoText should contain more information.
 * 				If ERROR is set the fields errorId and errorText will contain information about the error.
 * 			
 * 
 * <p>Java class for ResultOfCall complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResultOfCall">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resultCode" type="{urn:riv:insuranceprocess:healthreporting:2}ResultCodeEnum"/>
 *         &lt;element name="infoText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="errorId" type="{urn:riv:insuranceprocess:healthreporting:2}ErrorIdEnum" minOccurs="0"/>
 *         &lt;element name="errorText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "ResultOfCall", propOrder = {
    "resultCode",
    "infoText",
    "errorId",
    "errorText",
    "any"
})
public class ResultOfCall
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected ResultCodeEnum resultCode;
    protected String infoText;
    protected ErrorIdEnum errorId;
    protected String errorText;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the resultCode property.
     * 
     * @return
     *     possible object is
     *     {@link ResultCodeEnum }
     *     
     */
    public ResultCodeEnum getResultCode() {
        return resultCode;
    }

    /**
     * Sets the value of the resultCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultCodeEnum }
     *     
     */
    public void setResultCode(ResultCodeEnum value) {
        this.resultCode = value;
    }

    /**
     * Gets the value of the infoText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfoText() {
        return infoText;
    }

    /**
     * Sets the value of the infoText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfoText(String value) {
        this.infoText = value;
    }

    /**
     * Gets the value of the errorId property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorIdEnum }
     *     
     */
    public ErrorIdEnum getErrorId() {
        return errorId;
    }

    /**
     * Sets the value of the errorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorIdEnum }
     *     
     */
    public void setErrorId(ErrorIdEnum value) {
        this.errorId = value;
    }

    /**
     * Gets the value of the errorText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorText() {
        return errorText;
    }

    /**
     * Sets the value of the errorText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorText(String value) {
        this.errorText = value;
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
            ResultCodeEnum theResultCode;
            theResultCode = this.getResultCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "resultCode", theResultCode), currentHashCode, theResultCode);
        }
        {
            String theInfoText;
            theInfoText = this.getInfoText();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "infoText", theInfoText), currentHashCode, theInfoText);
        }
        {
            ErrorIdEnum theErrorId;
            theErrorId = this.getErrorId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "errorId", theErrorId), currentHashCode, theErrorId);
        }
        {
            String theErrorText;
            theErrorText = this.getErrorText();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "errorText", theErrorText), currentHashCode, theErrorText);
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
        if (!(object instanceof ResultOfCall)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ResultOfCall that = ((ResultOfCall) object);
        {
            ResultCodeEnum lhsResultCode;
            lhsResultCode = this.getResultCode();
            ResultCodeEnum rhsResultCode;
            rhsResultCode = that.getResultCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "resultCode", lhsResultCode), LocatorUtils.property(thatLocator, "resultCode", rhsResultCode), lhsResultCode, rhsResultCode)) {
                return false;
            }
        }
        {
            String lhsInfoText;
            lhsInfoText = this.getInfoText();
            String rhsInfoText;
            rhsInfoText = that.getInfoText();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "infoText", lhsInfoText), LocatorUtils.property(thatLocator, "infoText", rhsInfoText), lhsInfoText, rhsInfoText)) {
                return false;
            }
        }
        {
            ErrorIdEnum lhsErrorId;
            lhsErrorId = this.getErrorId();
            ErrorIdEnum rhsErrorId;
            rhsErrorId = that.getErrorId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "errorId", lhsErrorId), LocatorUtils.property(thatLocator, "errorId", rhsErrorId), lhsErrorId, rhsErrorId)) {
                return false;
            }
        }
        {
            String lhsErrorText;
            lhsErrorText = this.getErrorText();
            String rhsErrorText;
            rhsErrorText = that.getErrorText();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "errorText", lhsErrorText), LocatorUtils.property(thatLocator, "errorText", rhsErrorText), lhsErrorText, rhsErrorText)) {
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
            ResultCodeEnum theResultCode;
            theResultCode = this.getResultCode();
            strategy.appendField(locator, this, "resultCode", buffer, theResultCode);
        }
        {
            String theInfoText;
            theInfoText = this.getInfoText();
            strategy.appendField(locator, this, "infoText", buffer, theInfoText);
        }
        {
            ErrorIdEnum theErrorId;
            theErrorId = this.getErrorId();
            strategy.appendField(locator, this, "errorId", buffer, theErrorId);
        }
        {
            String theErrorText;
            theErrorText = this.getErrorText();
            strategy.appendField(locator, this, "errorText", buffer, theErrorText);
        }
        {
            List<Object> theAny;
            theAny = (((this.any!= null)&&(!this.any.isEmpty()))?this.getAny():null);
            strategy.appendField(locator, this, "any", buffer, theAny);
        }
        return buffer;
    }

}
