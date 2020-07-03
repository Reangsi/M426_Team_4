package dao;

import model.Reservation;

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
                " FROM aktientyp" +
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
                "SELECT * FROM mytrade.aktientyp" +
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
    private void setValuesType(ResultSet resultSet, Reservation model) throws SQLException {
        /*model.setID(resultSet.getInt("ID"));
        model.setPlatz(resultSet.getInt("platz"));
        model.setPreis(resultSet.getString("preis"));
        model.setAusstattung(resultSet.getString("ausstattung"));
        model.setName(resultSet.getString("name"));*/


    }
}
