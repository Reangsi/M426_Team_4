package controller;

import model.Customer;
import model.Reservation;
import model.Room;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Bean for the Reservation Bean
 * <p>
 * M426_Team_4
 *
 * @author Besfort Dauti
 * @version 1.0
 * @since 03.07.20
 */

@Named
@SessionScoped
public class ReservationslisteBean implements Serializable {

    private Reservation model;
    private Room roomModel;
    private Customer customerModel;

    /**
     * Constructor
     */
    private ReservationslisteBean() {

    }

    private String getRoomName() {
        String roomName = roomModel.getName();
        return roomName;
    }

    private String getDate() {
        String date = model.getDate().toString();
        return date;
    }

    private String getStartTime() {
        String startTime = model.getStartTime().toString();
        return startTime;
    }

    private String getEndTime() {
        String endTime = model.getEndTime().toString();
        return endTime;
    }

    private String getCustomerName() {
        String customerName = customerModel.getName();
        return customerName;
    }

    private String getCustomerNumber() {
        String customerTelefon = customerModel.getTelefon();
        return customerTelefon;
    }
}
