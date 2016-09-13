
package edu.softserveinc.healthbody.webclient.healthbody.webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for competitionDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="competitionDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="finishDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="groups" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="idCompetition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="logins" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameCriteria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "competitionDTO", propOrder = {
    "count",
    "description",
    "finishDate",
    "groups",
    "idCompetition",
    "logins",
    "name",
    "nameCriteria",
    "startDate"
})
public class CompetitionDTO {

    protected String count;
    protected String description;
    protected String finishDate;
    @XmlElement(nillable = true)
    protected List<String> groups;
    protected String idCompetition;
    @XmlElement(nillable = true)
    protected List<String> logins;
    protected String name;
    protected String nameCriteria;
    protected String startDate;

    /**
     * Gets the value of the count property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCount(String value) {
        this.count = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the finishDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinishDate() {
        return finishDate;
    }

    /**
     * Sets the value of the finishDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinishDate(String value) {
        this.finishDate = value;
    }

    /**
     * Gets the value of the groups property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the groups property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroups().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getGroups() {
        if (groups == null) {
            groups = new ArrayList<String>();
        }
        return this.groups;
    }

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
     * Gets the value of the logins property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logins property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogins().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLogins() {
        if (logins == null) {
            logins = new ArrayList<String>();
        }
        return this.logins;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the nameCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameCriteria() {
        return nameCriteria;
    }

    /**
     * Sets the value of the nameCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameCriteria(String value) {
        this.nameCriteria = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

}
