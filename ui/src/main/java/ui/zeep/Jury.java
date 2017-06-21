
package ui.zeep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for jury complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="jury">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services/}user">
 *       &lt;sequence>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userStats" type="{http://services/}userStats" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jury", propOrder = {
        "password",
        "userStats"
})
public class Jury
        extends User {

    protected String password;
    protected UserStats userStats;

    /**
     * Gets the value of the password property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the userStats property.
     *
     * @return possible object is
     * {@link UserStats }
     */
    public UserStats getUserStats() {
        return userStats;
    }

    /**
     * Sets the value of the userStats property.
     *
     * @param value allowed object is
     *              {@link UserStats }
     */
    public void setUserStats(UserStats value) {
        this.userStats = value;
    }

}
