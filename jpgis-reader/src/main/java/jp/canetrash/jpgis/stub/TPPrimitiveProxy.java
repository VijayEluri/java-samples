//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.11.26 at 01:19:58 �ߑO JST 
//


package jp.canetrash.jpgis.stub;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}TP_DirectedTopo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tpDirectedTopo"
})
@XmlRootElement(name = "TP_Primitive.proxy")
public class TPPrimitiveProxy {

    @XmlElementRef(name = "TP_DirectedTopo", namespace = "http://www.gsi.go.jp/GIS/jpgis/standardSchemas", type = JAXBElement.class)
    protected JAXBElement<? extends TPDirectedTopo> tpDirectedTopo;

    /**
     * Gets the value of the tpDirectedTopo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TPDirectedNode }{@code >}
     *     {@link JAXBElement }{@code <}{@link TPDirectedEdge }{@code >}
     *     {@link JAXBElement }{@code <}{@link TPEdge }{@code >}
     *     {@link JAXBElement }{@code <}{@link TPDirectedTopo }{@code >}
     *     {@link JAXBElement }{@code <}{@link TPFace }{@code >}
     *     {@link JAXBElement }{@code <}{@link TPDirectedFace }{@code >}
     *     {@link JAXBElement }{@code <}{@link TPNode }{@code >}
     *     
     */
    public JAXBElement<? extends TPDirectedTopo> getTPDirectedTopo() {
        return tpDirectedTopo;
    }

    /**
     * Sets the value of the tpDirectedTopo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TPDirectedNode }{@code >}
     *     {@link JAXBElement }{@code <}{@link TPDirectedEdge }{@code >}
     *     {@link JAXBElement }{@code <}{@link TPEdge }{@code >}
     *     {@link JAXBElement }{@code <}{@link TPDirectedTopo }{@code >}
     *     {@link JAXBElement }{@code <}{@link TPFace }{@code >}
     *     {@link JAXBElement }{@code <}{@link TPDirectedFace }{@code >}
     *     {@link JAXBElement }{@code <}{@link TPNode }{@code >}
     *     
     */
    public void setTPDirectedTopo(JAXBElement<? extends TPDirectedTopo> value) {
        this.tpDirectedTopo = ((JAXBElement<? extends TPDirectedTopo> ) value);
    }

}
