package dao;

import model.ReservationslisteModel;
import model.RoomModel;

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
public class ReservationslisteDao implements Dao<ReservationslisteModel, String> {

    public ReservationslisteModel getEntityType(String id) {
        ResultSet resultSet;
        ReservationslisteModel model = new ReservationslisteModel();

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

    public List<ReservationslisteModel> getAllTypes() {
        ResultSet resultSet;
        List<ReservationslisteModel> aktienList = new ArrayList<>();
        String sqlQuery =
                "SELECT * FROM mytrade.aktientyp" +
                        " ORDER BY ID;";

        try {
            resultSet = MySqlDB.sqlSelect(sqlQuery);
            while (resultSet.next()) {
                ReservationslisteModel model = new ReservationslisteModel();
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
     * @param model      a RoomModel object
     * @throws SQLException
     */
    private void setValuesType(ResultSet resultSet, ReservationslisteModel model) throws SQLException {
        /*model.setID(resultSet.getInt("ID"));
        model.setPlatz(resultSet.getInt("platz"));
        model.setPreis(resultSet.getString("preis"));
        model.setAusstattung(resultSet.getString("ausstattung"));
        model.setName(resultSet.getString("name"));*/
    }
}
