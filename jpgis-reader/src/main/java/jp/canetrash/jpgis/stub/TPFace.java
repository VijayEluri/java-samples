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
 * <p>Java class for TP_Face complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TP_Face">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}TP_DirectedFace">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}TP_Face.boundary" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TP_Face", propOrder = {
    "tpFaceBoundary"
})
public class TPFace
    extends TPDirectedFace
{

    @XmlElement(name = "TP_Face.boundary", required = true)
    protected List<TPFaceBoundary> tpFaceBoundary;

    /**
     * Gets the value of the tpFaceBoundary property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tpFaceBoundary property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTPFaceBoundary().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TPFaceBoundary }
     * 
     * 
     */
    public List<TPFaceBoundary> getTPFaceBoundary() {
        if (tpFaceBoundary == null) {
            tpFaceBoundary = new ArrayList<TPFaceBoundary>();
        }
        return this.tpFaceBoundary;
    }

}
