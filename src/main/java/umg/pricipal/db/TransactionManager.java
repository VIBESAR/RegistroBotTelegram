package umg.pricipal.db;


import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {

    public static void beginTransaction(Connection connection) throws SQLException {
        connection.setAutoCommit(false);
    }

    public static void commitTransaction(Connection connection) throws SQLException {
        connection.commit();
    }

    public static void rollbackTransaction(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

