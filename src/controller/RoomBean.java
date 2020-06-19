package controller;

import dao.RoomDao;
import model.RoomModel;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


/**
 * Bean for the Room View
 * <p>
 * M426-Team-4
 *
 * @author Besfort Dauti
 * @version 1.0
 * @since 12.06.20
 */

@Named
@SessionScoped
public class RoomBean implements Serializable {

    private RoomDao roomDao;
    private RoomModel roomModel;
    private int platz;
    private String name;
    private String beschreibung;
    private String preis;
    private String ausstattung;
    private ArrayList<RoomModel> raumListe;
    private ArrayList<String> zeitListe;
    private SimpleDateFormat dateFormat;
    private Date from;

    /**
     * Constructor
     */
    private RoomBean() {
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.from = new Date();
    }

    /**
     * getter for DatePicker
     */
    public String getFrom() {
        return dateFormat.format(from);
    }

    /**
     * setter for DatePicker
     */
    public void setFrom(String from) {
        try {
            this.from = dateFormat.parse(from);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * getter for Raum SelectBox
     */
    public ArrayList<RoomModel> getRaumListe() {
        raumListe = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            RoomModel model = new RoomModel();
            model.setName("Room " + i);
            raumListe.add(model);
        }
        return raumListe;
    }

    /**
     * getter for Zeit SelectBox
     */
    public ArrayList<String> getZeitListe() {
        zeitListe = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            zeitListe.add(i + ":00");
        }
        return zeitListe;
    }

}