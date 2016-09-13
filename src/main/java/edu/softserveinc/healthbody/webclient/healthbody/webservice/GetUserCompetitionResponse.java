
package edu.softserveinc.healthbody.webclient.healthbody.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getUserCompetitionResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getUserCompetitionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://webservice.healthbody.softserveinc.edu/}userCompetitionsDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUserCompetitionResponse", propOrder = {
    "_return"
})
public class GetUserCompetitionResponse {

    @XmlElement(name = "return")
    protected UserCompetitionsDTO _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link UserCompetitionsDTO }
     *     
     */
    public UserCompetitionsDTO getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserCompetitionsDTO }
     *     
     */
    public void setReturn(UserCompetitionsDTO value) {
        this._return = value;
    }

}
