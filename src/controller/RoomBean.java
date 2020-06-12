package controller;

import dao.RoomDao;
import model.RoomModel;

/**
 * short description
 * <p>
 * M426-Team-4
 *
 * @author Alen Redza
 * @version 1.0
 * @since 05.06.20
 */
public class RoomBean {

    private RoomDao roomDao;
    private RoomModel roomModel;
    private int platz = roomModel.getPlatz();
    private String name = roomModel.getName();
    private String beschreibung = roomModel.getBeschreibung();
    private String preis = roomModel.getPreis();
    private String ausstattung = roomModel.getAusstattung();

    public String openDescription() {
        return "descriptionView.xhtml";
    }
}