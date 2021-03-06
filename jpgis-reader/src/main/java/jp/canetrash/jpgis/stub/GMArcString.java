//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.11.26 at 01:19:58 �ߑO JST 
//


package jp.canetrash.jpgis.stub;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GM_ArcString complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GM_ArcString">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}GM_CurveSegments">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}GM_ArcString.controlPoint"/>
 *         &lt;element ref="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}GM_ArcString.numArc"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GM_ArcString", propOrder = {
    "gmArcStringControlPoint",
    "gmArcStringNumArc"
})
@XmlSeeAlso({
    GMArc.class
})
public class GMArcString
    extends GMCurveSegments
{

    @XmlElement(name = "GM_ArcString.controlPoint", required = true)
    protected GMArcStringControlPoint gmArcStringControlPoint;
    @XmlElement(name = "GM_ArcString.numArc", required = true)
    protected BigInteger gmArcStringNumArc;

    /**
     * Gets the value of the gmArcStringControlPoint property.
     * 
     * @return
     *     possible object is
     *     {@link GMArcStringControlPoint }
     *     
     */
    public GMArcStringControlPoint getGMArcStringControlPoint() {
        return gmArcStringControlPoint;
    }

    /**
     * Sets the value of the gmArcStringControlPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link GMArcStringControlPoint }
     *     
     */
    public void setGMArcStringControlPoint(GMArcStringControlPoint value) {
        this.gmArcStringControlPoint = value;
    }

    /**
     * Gets the value of the gmArcStringNumArc property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getGMArcStringNumArc() {
        return gmArcStringNumArc;
    }

    /**
     * Sets the value of the gmArcStringNumArc property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setGMArcStringNumArc(BigInteger value) {
        this.gmArcStringNumArc = value;
    }

}
