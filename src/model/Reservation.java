package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

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
    private int userId;
    private int roomId;
    private int customerId;
    private Date date;
    private String startTime;
    private String endTime;


    /**
     * Gets the customerId
     *
     * @return value of customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customerId
     *
     * @param customerId the value to set
     */

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the userId
     *
     * @return value of userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the userId
     *
     * @param userId the value to set
     */

    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the raumId
     *
     * @return value of raumId
     */
    public int getRoomId() {
        return roomId;
    }

    /**
     * Sets the raumId
     *
     * @param raumId the value to set
     */

    public void setRoomId(int raumId) {
        this.roomId = raumId;
    }

    /**
     * Gets the date
     *
     * @return value of date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date
     *
     * @param date the value to set
     */

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the startTime
     *
     * @return value of startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Sets the startTime
     *
     * @param startTime the value to set
     */

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets the endTime
     *
     * @return value of endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * Sets the endTime
     *
     * @param endTime the value to set
     */

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

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




}
