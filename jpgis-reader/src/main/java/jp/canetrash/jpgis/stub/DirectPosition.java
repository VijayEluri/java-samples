//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.11.26 at 01:19:58 �ߑO JST 
//


package jp.canetrash.jpgis.stub;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DirectPosition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DirectPosition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DirectPosition.coordinate" type="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}Sequence_Number"/>
 *         &lt;element name="DirectPosition.dimension" type="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}Integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DirectPosition", propOrder = {
    "directPositionCoordinate",
    "directPositionDimension"
})
public class DirectPosition {

    @XmlList
    @XmlElement(name = "DirectPosition.coordinate", namespace = "", required = true)
    protected List<BigDecimal> directPositionCoordinate;
    @XmlElement(name = "DirectPosition.dimension", namespace = "")
    protected BigInteger directPositionDimension;

    /**
     * Gets the value of the directPositionCoordinate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the directPositionCoordinate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDirectPositionCoordinate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BigDecimal }
     * 
     * 
     */
    public List<BigDecimal> getDirectPositionCoordinate() {
        if (directPositionCoordinate == null) {
            directPositionCoordinate = new ArrayList<BigDecimal>();
        }
        return this.directPositionCoordinate;
    }

    /**
     * Gets the value of the directPositionDimension property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDirectPositionDimension() {
        return directPositionDimension;
    }

    /**
     * Sets the value of the directPositionDimension property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDirectPositionDimension(BigInteger value) {
        this.directPositionDimension = value;
    }

}
