
package edu.softserveinc.healthbody.webclient.healthbody.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for groupCompetitionsDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="groupCompetitionsDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idCompetition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idGroupCompetition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "groupCompetitionsDTO", propOrder = {
    "idCompetition",
    "idGroup",
    "idGroupCompetition"
})
public class GroupCompetitionsDTO {

    protected String idCompetition;
    protected String idGroup;
    protected String idGroupCompetition;

    /**
     * Gets the value of the idCompetition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCompetition() {
        return idCompetition;
    }

    /**
     * Sets the value of the idCompetition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCompetition(String value) {
        this.idCompetition = value;
    }

    /**
     * Gets the value of the idGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdGroup() {
        return idGroup;
    }

    /**
     * Sets the value of the idGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdGroup(String value) {
        this.idGroup = value;
    }

    /**
     * Gets the value of the idGroupCompetition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdGroupCompetition() {
        return idGroupCompetition;
    }

    /**
     * Sets the value of the idGroupCompetition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdGroupCompetition(String value) {
        this.idGroupCompetition = value;
    }

}
