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
 * <p>Java class for CI_ResponsibleParty complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CI_ResponsibleParty">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CI_ResponsibleParty.individualName" type="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}CharacterString" minOccurs="0"/>
 *         &lt;element name="CI_ResponsibleParty.organisationName" type="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}CharacterString" minOccurs="0"/>
 *         &lt;element name="CI_ResponsibleParty.positionName" type="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}CharacterString" minOccurs="0"/>
 *         &lt;element name="CI_ResponsibleParty.contactInfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}CI_Contact"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CI_ResponsibleParty.role" type="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}CI_RoleCode"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CI_ResponsibleParty", propOrder = {
    "ciResponsiblePartyIndividualName",
    "ciResponsiblePartyOrganisationName",
    "ciResponsiblePartyPositionName",
    "ciResponsiblePartyContactInfo",
    "ciResponsiblePartyRole"
})
public class CIResponsibleParty {

    @XmlElement(name = "CI_ResponsibleParty.individualName", namespace = "")
    protected String ciResponsiblePartyIndividualName;
    @XmlElement(name = "CI_ResponsibleParty.organisationName", namespace = "")
    protected String ciResponsiblePartyOrganisationName;
    @XmlElement(name = "CI_ResponsibleParty.positionName", namespace = "")
    protected String ciResponsiblePartyPositionName;
    @XmlElement(name = "CI_ResponsibleParty.contactInfo", namespace = "")
    protected CIResponsibleParty.CIResponsiblePartyContactInfo ciResponsiblePartyContactInfo;
    @XmlElement(name = "CI_ResponsibleParty.role", namespace = "", required = true)
    protected String ciResponsiblePartyRole;

    /**
     * Gets the value of the ciResponsiblePartyIndividualName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCIResponsiblePartyIndividualName() {
        return ciResponsiblePartyIndividualName;
    }

    /**
     * Sets the value of the ciResponsiblePartyIndividualName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCIResponsiblePartyIndividualName(String value) {
        this.ciResponsiblePartyIndividualName = value;
    }

    /**
     * Gets the value of the ciResponsiblePartyOrganisationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCIResponsiblePartyOrganisationName() {
        return ciResponsiblePartyOrganisationName;
    }

    /**
     * Sets the value of the ciResponsiblePartyOrganisationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCIResponsiblePartyOrganisationName(String value) {
        this.ciResponsiblePartyOrganisationName = value;
    }

    /**
     * Gets the value of the ciResponsiblePartyPositionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCIResponsiblePartyPositionName() {
        return ciResponsiblePartyPositionName;
    }

    /**
     * Sets the value of the ciResponsiblePartyPositionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCIResponsiblePartyPositionName(String value) {
        this.ciResponsiblePartyPositionName = value;
    }

    /**
     * Gets the value of the ciResponsiblePartyContactInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CIResponsibleParty.CIResponsiblePartyContactInfo }
     *     
     */
    public CIResponsibleParty.CIResponsiblePartyContactInfo getCIResponsiblePartyContactInfo() {
        return ciResponsiblePartyContactInfo;
    }

    /**
     * Sets the value of the ciResponsiblePartyContactInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CIResponsibleParty.CIResponsiblePartyContactInfo }
     *     
     */
    public void setCIResponsiblePartyContactInfo(CIResponsibleParty.CIResponsiblePartyContactInfo value) {
        this.ciResponsiblePartyContactInfo = value;
    }

    /**
     * Gets the value of the ciResponsiblePartyRole property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCIResponsiblePartyRole() {
        return ciResponsiblePartyRole;
    }

    /**
     * Sets the value of the ciResponsiblePartyRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCIResponsiblePartyRole(String value) {
        this.ciResponsiblePartyRole = value;
    }


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
     *         &lt;element ref="{http://www.gsi.go.jp/GIS/jpgis/standardSchemas}CI_Contact"/>
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
        "ciContact"
    })
    public static class CIResponsiblePartyContactInfo {

        @XmlElement(name = "CI_Contact", required = true)
        protected CIContact ciContact;

        /**
         * Gets the value of the ciContact property.
         * 
         * @return
         *     possible object is
         *     {@link CIContact }
         *     
         */
        public CIContact getCIContact() {
            return ciContact;
        }

        /**
         * Sets the value of the ciContact property.
         * 
         * @param value
         *     allowed object is
         *     {@link CIContact }
         *     
         */
        public void setCIContact(CIContact value) {
            this.ciContact = value;
        }

    }

}
