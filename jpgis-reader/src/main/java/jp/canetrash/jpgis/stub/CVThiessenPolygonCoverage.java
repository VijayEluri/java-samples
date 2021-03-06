//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.11.26 at 01:19:58 �ߑO JST 
//


package jp.canetrash.jpgis.stub;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CV_ThiessenPolygonCoverage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CV_ThiessenPolygonCoverage">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}CV_ContinuousCoverage">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}CV_ContinuousCoverage.clipArea"/>
 *         &lt;element name="CV_ThiessenPolygonCoverage.element" type="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}CV_ThiessenValuePolygon" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CV_ThiessenPolygonCoverage", propOrder = {
    "cvContinuousCoverageClipArea",
    "cvThiessenPolygonCoverageElement"
})
public class CVThiessenPolygonCoverage
    extends CVContinuousCoverage
{

    @XmlElement(name = "CV_ContinuousCoverage.clipArea", required = true)
    protected RefGMSurface cvContinuousCoverageClipArea;
    @XmlElement(name = "CV_ThiessenPolygonCoverage.element", namespace = "", required = true)
    protected List<CVThiessenValuePolygon> cvThiessenPolygonCoverageElement;

    /**
     * Gets the value of the cvContinuousCoverageClipArea property.
     * 
     * @return
     *     possible object is
     *     {@link RefGMSurface }
     *     
     */
    public RefGMSurface getCVContinuousCoverageClipArea() {
        return cvContinuousCoverageClipArea;
    }

    /**
     * Sets the value of the cvContinuousCoverageClipArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefGMSurface }
     *     
     */
    public void setCVContinuousCoverageClipArea(RefGMSurface value) {
        this.cvContinuousCoverageClipArea = value;
    }

    /**
     * Gets the value of the cvThiessenPolygonCoverageElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cvThiessenPolygonCoverageElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCVThiessenPolygonCoverageElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CVThiessenValuePolygon }
     * 
     * 
     */
    public List<CVThiessenValuePolygon> getCVThiessenPolygonCoverageElement() {
        if (cvThiessenPolygonCoverageElement == null) {
            cvThiessenPolygonCoverageElement = new ArrayList<CVThiessenValuePolygon>();
        }
        return this.cvThiessenPolygonCoverageElement;
    }

}
