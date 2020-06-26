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
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
