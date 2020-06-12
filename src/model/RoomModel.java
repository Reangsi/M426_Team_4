package model;

/**
 * model for our RoomView
 * M426-Team-4
 *
 * @author Alen Redza
 * @version 1.0
 * @since 05.06.20
 */
public class RoomModel {

    private int ID;
    private int platz;
    private String name;
    private String beschreibung;
    private String preis;
    private String ausstattung;

    public RoomModel() {

    }

    public RoomModel(int ID, int platz, String preis, String ausstattung) {
            this.ID = ID;
            this.platz = platz;
            this.preis = preis;
            this.ausstattung = ausstattung;
    }

    public int getID() {
            return ID;
        }
    public void setID(int iD) {
            ID = iD;
        }

    public int getPlatz() {
        return platz;
    }

    public void setPlatz(int platz) {
        this.platz = platz;
    }

    public String getPreis() {
        return preis;
    }

    public void setPreis(String preis) {
        this.preis = preis;
    }

    public String getAusstattung() {
        return ausstattung;
    }

    public void setAusstattung(String ausstattung) {
        this.ausstattung = ausstattung;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}

