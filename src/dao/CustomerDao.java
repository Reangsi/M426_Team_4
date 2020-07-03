package dao;

import model.Customer;

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
public class CustomerDao implements Dao<Customer, String> {

    public Customer getEntityType(String id) {
        ResultSet resultSet;
        Customer model = new Customer();

        String sqlQuery = "SELECT *" +
                " FROM customer" +
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

    public List<Customer> getAllTypes() {
        ResultSet resultSet;
        List<Customer> customerList = new ArrayList<>();
        String sqlQuery =
                "SELECT * FROM roommanagement.customer" +
                        " ORDER BY ID;";

        try {
            resultSet = MySqlDB.sqlSelect(sqlQuery);
            while (resultSet.next()) {
                Customer model = new Customer();
                setValuesType(resultSet, model);
                customerList.add(model);
            }

        } catch (SQLException sqlEx) {

            sqlEx.printStackTrace();
            throw new RuntimeException();
        } finally {

            MySqlDB.sqlClose();
        }
        return customerList;

    }

    /**
     * sets the values of the attributes from the resultset
     *
     * @param resultSet  the resultSet with an entity
     * @param model      a Room object
     * @throws SQLException
     */
    private void setValuesType(ResultSet resultSet, Customer model) throws SQLException {
        model.setId(resultSet.getInt("ID"));
        model.setName(resultSet.getString("name"));
        model.setTelefon(resultSet.getString("telefon"));
    }
}
