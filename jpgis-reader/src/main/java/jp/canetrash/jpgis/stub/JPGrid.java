//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.11.26 at 01:19:58 �ߑO JST 
//


package jp.canetrash.jpgis.stub;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_Grid complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Grid">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}IM_Object">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}JP_Grid.dimension"/>
 *         &lt;element ref="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}JP_Grid.axisNames"/>
 *         &lt;element ref="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}JP_Grid.extent" minOccurs="0"/>
 *         &lt;element ref="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}JP_Grid.rangeType"/>
 *         &lt;element ref="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}JP_Grid.cell"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_Grid", propOrder = {
    "jpGridDimension",
    "jpGridAxisNames",
    "jpGridExtent",
    "jpGridRangeType",
    "jpGridCell"
})
@XmlSeeAlso({
    JPRubberGrid.class,
    JPRectifiedGrid.class,
    MAA02 .class
})
public class JPGrid
    extends IMObject
{

    @XmlElement(name = "JP_Grid.dimension", required = true)
    protected BigInteger jpGridDimension;
    @XmlList
    @XmlElement(name = "JP_Grid.axisNames", required = true)
    protected List<String> jpGridAxisNames;
    @XmlElement(name = "JP_Grid.extent")
    protected JPGridExtent jpGridExtent;
    @XmlElement(name = "JP_Grid.rangeType", required = true)
    protected RefRecordType jpGridRangeType;
    @XmlElement(name = "JP_Grid.cell", required = true)
    protected RefJPCell jpGridCell;

    /**
     * Gets the value of the jpGridDimension property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getJPGridDimension() {
        return jpGridDimension;
    }

    /**
     * Sets the value of the jpGridDimension property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setJPGridDimension(BigInteger value) {
        this.jpGridDimension = value;
    }

    /**
     * Gets the value of the jpGridAxisNames property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jpGridAxisNames property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJPGridAxisNames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getJPGridAxisNames() {
        if (jpGridAxisNames == null) {
            jpGridAxisNames = new ArrayList<String>();
        }
        return this.jpGridAxisNames;
    }

    /**
     * Gets the value of the jpGridExtent property.
     * 
     * @return
     *     possible object is
     *     {@link JPGridExtent }
     *     
     */
    public JPGridExtent getJPGridExtent() {
        return jpGridExtent;
    }

    /**
     * Sets the value of the jpGridExtent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPGridExtent }
     *     
     */
    public void setJPGridExtent(JPGridExtent value) {
        this.jpGridExtent = value;
    }

    /**
     * Gets the value of the jpGridRangeType property.
     * 
     * @return
     *     possible object is
     *     {@link RefRecordType }
     *     
     */
    public RefRecordType getJPGridRangeType() {
        return jpGridRangeType;
    }

    /**
     * Sets the value of the jpGridRangeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefRecordType }
     *     
     */
    public void setJPGridRangeType(RefRecordType value) {
        this.jpGridRangeType = value;
    }

    /**
     * Gets the value of the jpGridCell property.
     * 
     * @return
     *     possible object is
     *     {@link RefJPCell }
     *     
     */
    public RefJPCell getJPGridCell() {
        return jpGridCell;
    }

    /**
     * Sets the value of the jpGridCell property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefJPCell }
     *     
     */
    public void setJPGridCell(RefJPCell value) {
        this.jpGridCell = value;
    }

}