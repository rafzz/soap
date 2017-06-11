
package io.spring.guides.gs_producing_web_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="logins" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "logins"
})
@XmlRootElement(name = "getUsersResponse")
public class GetUsersResponse {

    @XmlElement(required = true)
    protected String logins;

    /**
     * Gets the value of the logins property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogins() {
        return logins;
    }

    /**
     * Sets the value of the logins property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogins(String value) {
        this.logins = value;
    }

}
