package dao;

import model.RoomModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * short description
 * <p>
 * M426-Team-4
 *
 * @author Besfort Dauti
 * @version 1.0
 * @since 05.06.20
 */
public class RoomDao implements Dao<RoomModel, String> {

    public RoomModel getEntityType(String id) {
        ResultSet resultSet;
        RoomModel model = new RoomModel();

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

    public List<RoomModel> getAllTypes() {
        ResultSet resultSet;
        List<RoomModel> aktienList = new ArrayList<>();
        String sqlQuery =
                "SELECT * FROM mytrade.aktientyp" +
                        " ORDER BY ID;";

        try {
            resultSet = MySqlDB.sqlSelect(sqlQuery);
            while (resultSet.next()) {
                RoomModel model = new RoomModel();
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
    private void setValuesType(ResultSet resultSet, RoomModel model) throws SQLException {
        model.setID(resultSet.getInt("ID"));
        model.setPlatz(resultSet.getInt("platz"));
        model.setPreis(resultSet.getString("preis"));
        model.setAusstattung(resultSet.getString("ausstattung"));
        model.setName(resultSet.getString("name"));
    }
}
