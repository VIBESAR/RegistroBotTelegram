package umg.pricipal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import umg.pricipal.db.DatabaseConnection;

public class RespuestaDao {

    public void insertarRespuesta(long chatId, String section, int questionIndex, String responseText) {
        String query = "INSERT INTO tb_respuestas (telegram_id, seccion, pregunta_id, respuesta_texto) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, chatId);
            statement.setString(2, section);
            statement.setInt(3, questionIndex);
            statement.setString(4, responseText);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



