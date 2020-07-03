package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * short description
 * <p>
 * M426_Team_4
 *
 * @author Reangsi Im
 * @version 1.0
 * @since 26.06.20
 */
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String telefon;

    /**
     * Gets the id
     *
     * @return value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id
     *
     * @param id the value to set
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name
     *
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     *
     * @param name the value to set
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the telefon
     *
     * @return value of telefon
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * Sets the telefon
     *
     * @param telefon the value to set
     */

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

}
