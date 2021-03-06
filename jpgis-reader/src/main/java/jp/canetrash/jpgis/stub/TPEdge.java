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
 * <p>Java class for TP_Edge complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TP_Edge">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}TP_DirectedEdge">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}TP_Edge.spoke" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}TP_Edge.boundary" maxOccurs="2" minOccurs="2"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TP_Edge", propOrder = {
    "tpEdgeSpoke",
    "tpEdgeBoundary"
})
public class TPEdge
    extends TPDirectedEdge
{

    @XmlElement(name = "TP_Edge.spoke")
    protected List<RefTPDirectedFace> tpEdgeSpoke;
    @XmlElement(name = "TP_Edge.boundary", required = true)
    protected List<TPEdgeBoundary> tpEdgeBoundary;

    /**
     * Gets the value of the tpEdgeSpoke property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tpEdgeSpoke property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTPEdgeSpoke().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefTPDirectedFace }
     * 
     * 
     */
    public List<RefTPDirectedFace> getTPEdgeSpoke() {
        if (tpEdgeSpoke == null) {
            tpEdgeSpoke = new ArrayList<RefTPDirectedFace>();
        }
        return this.tpEdgeSpoke;
    }

    /**
     * Gets the value of the tpEdgeBoundary property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tpEdgeBoundary property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTPEdgeBoundary().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TPEdgeBoundary }
     * 
     * 
     */
    public List<TPEdgeBoundary> getTPEdgeBoundary() {
        if (tpEdgeBoundary == null) {
            tpEdgeBoundary = new ArrayList<TPEdgeBoundary>();
        }
        return this.tpEdgeBoundary;
    }

}
