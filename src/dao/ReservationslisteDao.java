package dao;

import model.Customer;
import model.Reservation;
import model.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * short description
 * <p>
 * M426_Team_4
 *
 * @author Besfort Dauti
 * @version 1.0
 * @since 26.06.20
 */
public class ReservationslisteDao implements Dao<Reservation, String> {

    public Reservation getEntityType(String id) {
        ResultSet resultSet;
        Reservation model = new Reservation();

        String sqlQuery = "SELECT *" +
                " FROM reservations" +
                " WHERE ID=?;";

        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, id);

        try {
            resultSet = MySqlDB.sqlSelect(sqlQuery, map);
            if (resultSet.next()) {
                setValuesType(resultSet, model);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            throw new RuntimeException();
        } finally {
            MySqlDB.sqlClose();
        }
        return model;

    }

    public List<Reservation> getAllTypes() {
        ResultSet resultSet;
        List<Reservation> aktienList = new ArrayList<>();
        String sqlQuery =
                "SELECT * FROM roommanagement.reservations" +
                        " ORDER BY ID;";

        try {
            resultSet = MySqlDB.sqlSelect(sqlQuery);
            while (resultSet.next()) {
                Reservation model = new Reservation();
                setValuesType(resultSet, model);
                aktienList.add(model);
            }

        } catch (SQLException sqlEx) {

            sqlEx.printStackTrace();
            throw new RuntimeException();
        } finally {

            MySqlDB.sqlClose();
        }
        return aktienList;

    }

    /**
     * sets the values of the attributes from the resultset
     *
     * @param resultSet  the resultSet with an entity
     * @param model      a Room object
     * @throws SQLException
     */
    private void setValuesType(ResultSet resultSet, Reservation model, Room modelRoom, Customer modelCustomer) throws SQLException {
        /*model.setID(resultSet.getInt("ID"));
        model.setPlatz(resultSet.getInt("platz"));
        model.setPreis(resultSet.getString("preis"));
        model.setAusstattung(resultSet.getString("ausstattung"));
        model.setName(resultSet.getString("name"));*/
        model.setId(resultSet.getInt("id"));
        model.setDate(resultSet.getDate("date"));
        model.setStartTime(resultSet.getString("starttime"));
        model.setEndTime(resultSet.getString("endtime"));
        model.setRoomId(resultSet.getInt("rooms_id"));
        model.setCustomerId(resultSet.getInt("customer_id"));
    }
}
