package dao;

import util.Result;

import java.sql.*;
import java.util.Map;

/**
 * common methods for MySQL database
 *
 * @author Besfort Dauti
 * @version 1.0
 * @since 05.06.2020
 */
public class MySqlDB {
	
    private static Connection connection = null;
    private static PreparedStatement prepStmt;
    private static ResultSet resultSet;
    
	private static String connectionURL = "jdbc:mysql://localhost:3306/RoomManagement" + "?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String myUsername = "RoomUser";
	private static String myPassword = "123";

    /**
     * default constructor: defeat instantiation
     */
    public MySqlDB() {
    }

    /**
     * Execute SELECT-Query without dynamic values and return the resultset
     *
     * @param sqlQuery the query to be executed
     * @return ResultSet the data retrieved from the database
     * @throws SQLException Syntax errors
     */
    static synchronized ResultSet sqlSelect(String sqlQuery)
            throws SQLException {
        return sqlSelect(sqlQuery, null);
    }

    /**
     * execute SELECT-query with dynamic values and return the resultset
     *
     * @param sqlQuery the query to be executed
     * @param values   map of values to be inserted
     * @return ResultSet the data retrieved from the database
     * @throws SQLException Syntax errors
     */
    static synchronized ResultSet sqlSelect(String sqlQuery, Map<Integer, String> values)
            throws SQLException {
        setResultSet(null);

        try {
            setPrepStmt(getConnection().prepareStatement(sqlQuery));

            if (values != null) {
                setValues(values);
            }
            setResultSet(getPrepStmt().executeQuery());

        } catch (SQLException sqlException) {
            printSQLException(sqlException, sqlQuery);
            throw sqlException;
        }
        return getResultSet();
    }

    /**
     * execute a query without dynamic values to update the db (INSERT, UPDATE, DELETE, REPLACE)
     *
     * @param sqlQuery
     *            the query to be executed
     * @return number of affected rows
     * @throws SQLException
     */
    static Result sqlUpdate(String sqlQuery) throws SQLException {
        return sqlUpdate(sqlQuery, null);
    }

    /**
     * execute a query with dynamic values to update the db (UPDATE, DELETE, REPLACE)
     *
     * @param sqlQuery
     *            the query to be executed
     * @param values
     *            map of values to be inserted
     * @return number of affected rows
     * @throws SQLException
     */
    static Result sqlUpdate(String sqlQuery, Map<Integer, String> values) throws SQLException {
        try {
            setPrepStmt(getConnection().prepareStatement(sqlQuery));

            if (values != null) {
                setValues(values);
            }
            int affectedRows = getPrepStmt().executeUpdate();
            if (affectedRows <= 2) {
                return Result.SUCCESS;
            } else if (affectedRows == 0) {
                return Result.NOACTION;
            } else {
                return Result.ERROR;
            }
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
            throw sqlException;
        }finally {
            sqlClose();
        }
    }

    /**
     * Insert the values into a prepared-Statement
     *
     * @param values map with attributename=value
     * @throws SQLException wrong parameter count
     */
    private static void setValues(Map<Integer, String> values) throws SQLException {

        for (Integer i=1; values.containsKey(i); i++) {
            getPrepStmt().setString(i, values.get(i));
        }
    }

    /**
     * Close resultSet and prepared statement
     */
    static void sqlClose() {
        try {
            if (getResultSet() != null) getResultSet().close();
            if (getPrepStmt() != null) getPrepStmt().close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    /**
     * Show query, error codes and messages for a SQL-Exception
     *
     * @param sqlEx the SQLException
     * @param sqlQuery the executed query
     */
    static void printSQLException(SQLException sqlEx, String sqlQuery) {
        System.out.println("Query: " + sqlQuery);
        System.err.println("Query: " + sqlQuery);
        printSQLException(sqlEx);
    }

    /**
     * Show error codes and messages for a SQL-Exception
     *
     * @param sqlEx the SQLException
     */
    static void printSQLException(SQLException sqlEx) {
        StringBuilder message = new StringBuilder("ERROR: an SQLException has occured");
        for (Throwable exception : sqlEx) {
            if (exception instanceof SQLException) {

                exception.printStackTrace(System.err);
                message.append("\nSQLState: ").append(((SQLException) exception).getSQLState());
                message.append("\nError Code: ").append(((SQLException) exception).getErrorCode());
                message.append("\nMessage: ").append(exception.getMessage());

                Throwable cause = sqlEx.getCause();
                while (cause != null) {
                    message.append("\nCause: ").append(cause);
                    cause = cause.getCause();
                }
            }
        }
        System.out.println(message);
        System.err.println(message);
    }


    /**
     * Gets the connection: open new connection if needed
     *
     * @return connection
     */
    public static Connection getConnection() {

		if (connection == null) {
			try {
                Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(connectionURL, 
								                        myUsername, 
								                        myPassword);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
		return connection;
	}

    /**
     * Sets the connection
     *
     * @param connection the value to set
     */

    private static void setConnection(Connection connection) {
        MySqlDB.connection = connection;
    }

    /**
     * Gets the prepStmt
     *
     * @return value of prepStmt
     */
    private static PreparedStatement getPrepStmt() {
        return prepStmt;
    }

    /**
     * Sets the prepStmt
     *
     * @param prepStmt the value to set
     */

    public static void setPrepStmt(PreparedStatement prepStmt) {
        MySqlDB.prepStmt = prepStmt;
    }

    /**
     * Gets the resultSet
     *
     * @return value of resultSet
     */
    public static ResultSet getResultSet() {
        return resultSet;
    }

    /**
     * Sets the resultSet
     *
     * @param resultSet the value to set
     */

    public static void setResultSet(ResultSet resultSet) {
        MySqlDB.resultSet = resultSet;
    }
}
