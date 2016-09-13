
package edu.softserveinc.healthbody.webclient.healthbody.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getGroupCompetitionResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getGroupCompetitionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://webservice.healthbody.softserveinc.edu/}groupCompetitionsDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getGroupCompetitionResponse", propOrder = {
    "_return"
})
public class GetGroupCompetitionResponse {

    @XmlElement(name = "return")
    protected GroupCompetitionsDTO _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link GroupCompetitionsDTO }
     *     
     */
    public GroupCompetitionsDTO getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupCompetitionsDTO }
     *     
     */
    public void setReturn(GroupCompetitionsDTO value) {
        this._return = value;
    }

}
