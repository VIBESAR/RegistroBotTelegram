package umg.pricipal.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/db_telebot";
    private static final String USER = "root";
    private static final String PASSWORD = "canche12";
    private static Connection connection;

    public static void initConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexión a la base de datos establecida.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
