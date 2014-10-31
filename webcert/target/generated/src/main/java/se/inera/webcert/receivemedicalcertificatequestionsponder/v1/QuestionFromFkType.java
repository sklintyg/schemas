
package se.inera.webcert.receivemedicalcertificatequestionsponder.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.joda.time.LocalDate;
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
import org.w3._2001.xmlschema.Adapter2;
import org.w3c.dom.Element;
import se.inera.webcert.medcertqa.v1.Amnetyp;
import se.inera.webcert.medcertqa.v1.FkKontaktType;
import se.inera.webcert.medcertqa.v1.InnehallType;
import se.inera.webcert.medcertqa.v1.KompletteringType;
import se.inera.webcert.medcertqa.v1.LakarutlatandeEnkelType;
import se.inera.webcert.medcertqa.v1.VardAdresseringsType;


/**
 * <p>Java class for QuestionFromFkType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QuestionFromFkType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fkReferens-id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="amne" type="{urn:riv:insuranceprocess:healthreporting:medcertqa:1}Amnetyp"/>
 *         &lt;element name="fraga" type="{urn:riv:insuranceprocess:healthreporting:medcertqa:1}innehallType"/>
 *         &lt;element name="avsantTidpunkt" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="fkKontaktInfo" type="{urn:riv:insuranceprocess:healthreporting:medcertqa:1}fkKontaktType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adressVard" type="{urn:riv:insuranceprocess:healthreporting:medcertqa:1}vardAdresseringsType"/>
 *         &lt;element name="fkMeddelanderubrik" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fkKomplettering" type="{urn:riv:insuranceprocess:healthreporting:medcertqa:1}kompletteringType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="fkSistaDatumForSvar" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="lakarutlatande" type="{urn:riv:insuranceprocess:healthreporting:medcertqa:1}lakarutlatandeEnkelType"/>
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
@XmlType(name = "QuestionFromFkType", propOrder = {
    "fkReferensId",
    "amne",
    "fraga",
    "avsantTidpunkt",
    "fkKontaktInfo",
    "adressVard",
    "fkMeddelanderubrik",
    "fkKomplettering",
    "fkSistaDatumForSvar",
    "lakarutlatande",
    "any"
})
public class QuestionFromFkType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "fkReferens-id", required = true)
    protected String fkReferensId;
    @XmlElement(required = true)
    protected Amnetyp amne;
    @XmlElement(required = true)
    protected InnehallType fraga;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected LocalDateTime avsantTidpunkt;
    protected List<FkKontaktType> fkKontaktInfo;
    @XmlElement(required = true)
    protected VardAdresseringsType adressVard;
    protected String fkMeddelanderubrik;
    protected List<KompletteringType> fkKomplettering;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "date")
    protected LocalDate fkSistaDatumForSvar;
    @XmlElement(required = true)
    protected LakarutlatandeEnkelType lakarutlatande;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the fkReferensId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFkReferensId() {
        return fkReferensId;
    }

    /**
     * Sets the value of the fkReferensId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFkReferensId(String value) {
        this.fkReferensId = value;
    }

    /**
     * Gets the value of the amne property.
     * 
     * @return
     *     possible object is
     *     {@link Amnetyp }
     *     
     */
    public Amnetyp getAmne() {
        return amne;
    }

    /**
     * Sets the value of the amne property.
     * 
     * @param value
     *     allowed object is
     *     {@link Amnetyp }
     *     
     */
    public void setAmne(Amnetyp value) {
        this.amne = value;
    }

    /**
     * Gets the value of the fraga property.
     * 
     * @return
     *     possible object is
     *     {@link InnehallType }
     *     
     */
    public InnehallType getFraga() {
        return fraga;
    }

    /**
     * Sets the value of the fraga property.
     * 
     * @param value
     *     allowed object is
     *     {@link InnehallType }
     *     
     */
    public void setFraga(InnehallType value) {
        this.fraga = value;
    }

    /**
     * Gets the value of the avsantTidpunkt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDateTime getAvsantTidpunkt() {
        return avsantTidpunkt;
    }

    /**
     * Sets the value of the avsantTidpunkt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvsantTidpunkt(LocalDateTime value) {
        this.avsantTidpunkt = value;
    }

    /**
     * Gets the value of the fkKontaktInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fkKontaktInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFkKontaktInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FkKontaktType }
     * 
     * 
     */
    public List<FkKontaktType> getFkKontaktInfo() {
        if (fkKontaktInfo == null) {
            fkKontaktInfo = new ArrayList<FkKontaktType>();
        }
        return this.fkKontaktInfo;
    }

    /**
     * Gets the value of the adressVard property.
     * 
     * @return
     *     possible object is
     *     {@link VardAdresseringsType }
     *     
     */
    public VardAdresseringsType getAdressVard() {
        return adressVard;
    }

    /**
     * Sets the value of the adressVard property.
     * 
     * @param value
     *     allowed object is
     *     {@link VardAdresseringsType }
     *     
     */
    public void setAdressVard(VardAdresseringsType value) {
        this.adressVard = value;
    }

    /**
     * Gets the value of the fkMeddelanderubrik property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFkMeddelanderubrik() {
        return fkMeddelanderubrik;
    }

    /**
     * Sets the value of the fkMeddelanderubrik property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFkMeddelanderubrik(String value) {
        this.fkMeddelanderubrik = value;
    }

    /**
     * Gets the value of the fkKomplettering property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fkKomplettering property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFkKomplettering().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KompletteringType }
     * 
     * 
     */
    public List<KompletteringType> getFkKomplettering() {
        if (fkKomplettering == null) {
            fkKomplettering = new ArrayList<KompletteringType>();
        }
        return this.fkKomplettering;
    }

    /**
     * Gets the value of the fkSistaDatumForSvar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDate getFkSistaDatumForSvar() {
        return fkSistaDatumForSvar;
    }

    /**
     * Sets the value of the fkSistaDatumForSvar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFkSistaDatumForSvar(LocalDate value) {
        this.fkSistaDatumForSvar = value;
    }

    /**
     * Gets the value of the lakarutlatande property.
     * 
     * @return
     *     possible object is
     *     {@link LakarutlatandeEnkelType }
     *     
     */
    public LakarutlatandeEnkelType getLakarutlatande() {
        return lakarutlatande;
    }

    /**
     * Sets the value of the lakarutlatande property.
     * 
     * @param value
     *     allowed object is
     *     {@link LakarutlatandeEnkelType }
     *     
     */
    public void setLakarutlatande(LakarutlatandeEnkelType value) {
        this.lakarutlatande = value;
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
            String theFkReferensId;
            theFkReferensId = this.getFkReferensId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fkReferensId", theFkReferensId), currentHashCode, theFkReferensId);
        }
        {
            Amnetyp theAmne;
            theAmne = this.getAmne();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "amne", theAmne), currentHashCode, theAmne);
        }
        {
            InnehallType theFraga;
            theFraga = this.getFraga();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fraga", theFraga), currentHashCode, theFraga);
        }
        {
            LocalDateTime theAvsantTidpunkt;
            theAvsantTidpunkt = this.getAvsantTidpunkt();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "avsantTidpunkt", theAvsantTidpunkt), currentHashCode, theAvsantTidpunkt);
        }
        {
            List<FkKontaktType> theFkKontaktInfo;
            theFkKontaktInfo = (((this.fkKontaktInfo!= null)&&(!this.fkKontaktInfo.isEmpty()))?this.getFkKontaktInfo():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fkKontaktInfo", theFkKontaktInfo), currentHashCode, theFkKontaktInfo);
        }
        {
            VardAdresseringsType theAdressVard;
            theAdressVard = this.getAdressVard();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "adressVard", theAdressVard), currentHashCode, theAdressVard);
        }
        {
            String theFkMeddelanderubrik;
            theFkMeddelanderubrik = this.getFkMeddelanderubrik();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fkMeddelanderubrik", theFkMeddelanderubrik), currentHashCode, theFkMeddelanderubrik);
        }
        {
            List<KompletteringType> theFkKomplettering;
            theFkKomplettering = (((this.fkKomplettering!= null)&&(!this.fkKomplettering.isEmpty()))?this.getFkKomplettering():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fkKomplettering", theFkKomplettering), currentHashCode, theFkKomplettering);
        }
        {
            LocalDate theFkSistaDatumForSvar;
            theFkSistaDatumForSvar = this.getFkSistaDatumForSvar();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fkSistaDatumForSvar", theFkSistaDatumForSvar), currentHashCode, theFkSistaDatumForSvar);
        }
        {
            LakarutlatandeEnkelType theLakarutlatande;
            theLakarutlatande = this.getLakarutlatande();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lakarutlatande", theLakarutlatande), currentHashCode, theLakarutlatande);
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
        if (!(object instanceof QuestionFromFkType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final QuestionFromFkType that = ((QuestionFromFkType) object);
        {
            String lhsFkReferensId;
            lhsFkReferensId = this.getFkReferensId();
            String rhsFkReferensId;
            rhsFkReferensId = that.getFkReferensId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fkReferensId", lhsFkReferensId), LocatorUtils.property(thatLocator, "fkReferensId", rhsFkReferensId), lhsFkReferensId, rhsFkReferensId)) {
                return false;
            }
        }
        {
            Amnetyp lhsAmne;
            lhsAmne = this.getAmne();
            Amnetyp rhsAmne;
            rhsAmne = that.getAmne();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "amne", lhsAmne), LocatorUtils.property(thatLocator, "amne", rhsAmne), lhsAmne, rhsAmne)) {
                return false;
            }
        }
        {
            InnehallType lhsFraga;
            lhsFraga = this.getFraga();
            InnehallType rhsFraga;
            rhsFraga = that.getFraga();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fraga", lhsFraga), LocatorUtils.property(thatLocator, "fraga", rhsFraga), lhsFraga, rhsFraga)) {
                return false;
            }
        }
        {
            LocalDateTime lhsAvsantTidpunkt;
            lhsAvsantTidpunkt = this.getAvsantTidpunkt();
            LocalDateTime rhsAvsantTidpunkt;
            rhsAvsantTidpunkt = that.getAvsantTidpunkt();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "avsantTidpunkt", lhsAvsantTidpunkt), LocatorUtils.property(thatLocator, "avsantTidpunkt", rhsAvsantTidpunkt), lhsAvsantTidpunkt, rhsAvsantTidpunkt)) {
                return false;
            }
        }
        {
            List<FkKontaktType> lhsFkKontaktInfo;
            lhsFkKontaktInfo = (((this.fkKontaktInfo!= null)&&(!this.fkKontaktInfo.isEmpty()))?this.getFkKontaktInfo():null);
            List<FkKontaktType> rhsFkKontaktInfo;
            rhsFkKontaktInfo = (((that.fkKontaktInfo!= null)&&(!that.fkKontaktInfo.isEmpty()))?that.getFkKontaktInfo():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fkKontaktInfo", lhsFkKontaktInfo), LocatorUtils.property(thatLocator, "fkKontaktInfo", rhsFkKontaktInfo), lhsFkKontaktInfo, rhsFkKontaktInfo)) {
                return false;
            }
        }
        {
            VardAdresseringsType lhsAdressVard;
            lhsAdressVard = this.getAdressVard();
            VardAdresseringsType rhsAdressVard;
            rhsAdressVard = that.getAdressVard();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "adressVard", lhsAdressVard), LocatorUtils.property(thatLocator, "adressVard", rhsAdressVard), lhsAdressVard, rhsAdressVard)) {
                return false;
            }
        }
        {
            String lhsFkMeddelanderubrik;
            lhsFkMeddelanderubrik = this.getFkMeddelanderubrik();
            String rhsFkMeddelanderubrik;
            rhsFkMeddelanderubrik = that.getFkMeddelanderubrik();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fkMeddelanderubrik", lhsFkMeddelanderubrik), LocatorUtils.property(thatLocator, "fkMeddelanderubrik", rhsFkMeddelanderubrik), lhsFkMeddelanderubrik, rhsFkMeddelanderubrik)) {
                return false;
            }
        }
        {
            List<KompletteringType> lhsFkKomplettering;
            lhsFkKomplettering = (((this.fkKomplettering!= null)&&(!this.fkKomplettering.isEmpty()))?this.getFkKomplettering():null);
            List<KompletteringType> rhsFkKomplettering;
            rhsFkKomplettering = (((that.fkKomplettering!= null)&&(!that.fkKomplettering.isEmpty()))?that.getFkKomplettering():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fkKomplettering", lhsFkKomplettering), LocatorUtils.property(thatLocator, "fkKomplettering", rhsFkKomplettering), lhsFkKomplettering, rhsFkKomplettering)) {
                return false;
            }
        }
        {
            LocalDate lhsFkSistaDatumForSvar;
            lhsFkSistaDatumForSvar = this.getFkSistaDatumForSvar();
            LocalDate rhsFkSistaDatumForSvar;
            rhsFkSistaDatumForSvar = that.getFkSistaDatumForSvar();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fkSistaDatumForSvar", lhsFkSistaDatumForSvar), LocatorUtils.property(thatLocator, "fkSistaDatumForSvar", rhsFkSistaDatumForSvar), lhsFkSistaDatumForSvar, rhsFkSistaDatumForSvar)) {
                return false;
            }
        }
        {
            LakarutlatandeEnkelType lhsLakarutlatande;
            lhsLakarutlatande = this.getLakarutlatande();
            LakarutlatandeEnkelType rhsLakarutlatande;
            rhsLakarutlatande = that.getLakarutlatande();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lakarutlatande", lhsLakarutlatande), LocatorUtils.property(thatLocator, "lakarutlatande", rhsLakarutlatande), lhsLakarutlatande, rhsLakarutlatande)) {
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
            String theFkReferensId;
            theFkReferensId = this.getFkReferensId();
            strategy.appendField(locator, this, "fkReferensId", buffer, theFkReferensId);
        }
        {
            Amnetyp theAmne;
            theAmne = this.getAmne();
            strategy.appendField(locator, this, "amne", buffer, theAmne);
        }
        {
            InnehallType theFraga;
            theFraga = this.getFraga();
            strategy.appendField(locator, this, "fraga", buffer, theFraga);
        }
        {
            LocalDateTime theAvsantTidpunkt;
            theAvsantTidpunkt = this.getAvsantTidpunkt();
            strategy.appendField(locator, this, "avsantTidpunkt", buffer, theAvsantTidpunkt);
        }
        {
            List<FkKontaktType> theFkKontaktInfo;
            theFkKontaktInfo = (((this.fkKontaktInfo!= null)&&(!this.fkKontaktInfo.isEmpty()))?this.getFkKontaktInfo():null);
            strategy.appendField(locator, this, "fkKontaktInfo", buffer, theFkKontaktInfo);
        }
        {
            VardAdresseringsType theAdressVard;
            theAdressVard = this.getAdressVard();
            strategy.appendField(locator, this, "adressVard", buffer, theAdressVard);
        }
        {
            String theFkMeddelanderubrik;
            theFkMeddelanderubrik = this.getFkMeddelanderubrik();
            strategy.appendField(locator, this, "fkMeddelanderubrik", buffer, theFkMeddelanderubrik);
        }
        {
            List<KompletteringType> theFkKomplettering;
            theFkKomplettering = (((this.fkKomplettering!= null)&&(!this.fkKomplettering.isEmpty()))?this.getFkKomplettering():null);
            strategy.appendField(locator, this, "fkKomplettering", buffer, theFkKomplettering);
        }
        {
            LocalDate theFkSistaDatumForSvar;
            theFkSistaDatumForSvar = this.getFkSistaDatumForSvar();
            strategy.appendField(locator, this, "fkSistaDatumForSvar", buffer, theFkSistaDatumForSvar);
        }
        {
            LakarutlatandeEnkelType theLakarutlatande;
            theLakarutlatande = this.getLakarutlatande();
            strategy.appendField(locator, this, "lakarutlatande", buffer, theLakarutlatande);
        }
        {
            List<Object> theAny;
            theAny = (((this.any!= null)&&(!this.any.isEmpty()))?this.getAny():null);
            strategy.appendField(locator, this, "any", buffer, theAny);
        }
        return buffer;
    }

}
