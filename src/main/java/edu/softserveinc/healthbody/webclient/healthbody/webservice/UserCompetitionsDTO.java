
package edu.softserveinc.healthbody.webclient.healthbody.webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for userCompetitionsDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userCompetitionsDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="awardsName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="competitions" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="idUserCompetition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="login" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timeReceivedAward" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userScore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userCompetitionsDTO", propOrder = {
    "awardsName",
    "competitions",
    "idUserCompetition",
    "login",
    "timeReceivedAward",
    "userScore"
})
public class UserCompetitionsDTO {

    protected String awardsName;
    @XmlElement(nillable = true)
    protected List<String> competitions;
    protected String idUserCompetition;
    protected String login;
    protected String timeReceivedAward;
    protected String userScore;

    /**
     * Gets the value of the awardsName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAwardsName() {
        return awardsName;
    }

    /**
     * Sets the value of the awardsName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAwardsName(String value) {
        this.awardsName = value;
    }

    /**
     * Gets the value of the competitions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the competitions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCompetitions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCompetitions() {
        if (competitions == null) {
            competitions = new ArrayList<String>();
        }
        return this.competitions;
    }

    /**
     * Gets the value of the idUserCompetition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdUserCompetition() {
        return idUserCompetition;
    }

    /**
     * Sets the value of the idUserCompetition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdUserCompetition(String value) {
        this.idUserCompetition = value;
    }

    /**
     * Gets the value of the login property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the value of the login property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogin(String value) {
        this.login = value;
    }

    /**
     * Gets the value of the timeReceivedAward property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeReceivedAward() {
        return timeReceivedAward;
    }

    /**
     * Sets the value of the timeReceivedAward property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeReceivedAward(String value) {
        this.timeReceivedAward = value;
    }

    /**
     * Gets the value of the userScore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserScore() {
        return userScore;
    }

    /**
     * Sets the value of the userScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserScore(String value) {
        this.userScore = value;
    }

}
