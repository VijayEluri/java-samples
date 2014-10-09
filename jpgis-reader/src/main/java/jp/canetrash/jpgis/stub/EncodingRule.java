//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.11.26 at 01:19:58 �ߑO JST 
//


package jp.canetrash.jpgis.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EncodingRule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EncodingRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="encodingRuleCitation" type="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}CI_Citation"/>
 *         &lt;element name="toolName" type="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}CharacterString"/>
 *         &lt;element name="toolVersion" type="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}CharacterString" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EncodingRule", propOrder = {
    "encodingRuleCitation",
    "toolName",
    "toolVersion"
})
public class EncodingRule {

    @XmlElement(namespace = "", required = true)
    protected CICitation encodingRuleCitation;
    @XmlElement(namespace = "", required = true)
    protected String toolName;
    @XmlElement(namespace = "")
    protected String toolVersion;

    /**
     * Gets the value of the encodingRuleCitation property.
     * 
     * @return
     *     possible object is
     *     {@link CICitation }
     *     
     */
    public CICitation getEncodingRuleCitation() {
        return encodingRuleCitation;
    }

    /**
     * Sets the value of the encodingRuleCitation property.
     * 
     * @param value
     *     allowed object is
     *     {@link CICitation }
     *     
     */
    public void setEncodingRuleCitation(CICitation value) {
        this.encodingRuleCitation = value;
    }

    /**
     * Gets the value of the toolName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToolName() {
        return toolName;
    }

    /**
     * Sets the value of the toolName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToolName(String value) {
        this.toolName = value;
    }

    /**
     * Gets the value of the toolVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToolVersion() {
        return toolVersion;
    }

    /**
     * Sets the value of the toolVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToolVersion(String value) {
        this.toolVersion = value;
    }

}