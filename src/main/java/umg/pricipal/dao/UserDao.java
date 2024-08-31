package umg.pricipal.dao;
import java.sql.*;
import java.util.Properties;

import umg.pricipal.model.User;
import umg.pricipal.db.DatabaseConnection;

public class UserDao {

    public boolean existeUsuario(long chatId) {
        String query = "SELECT COUNT(*) FROM usuarios WHERE chat_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, chatId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void guardarUsuario(long chatId, String firstName, String lastName, String nickName, String email) {
        String query = "INSERT INTO usuarios (chat_id, first_name, last_name, nick_name, email) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, chatId);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, nickName);
            statement.setString(5, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User obtenerUsuarioPorTelegramId(long chatId) {
        String query = "SELECT * FROM usuarios WHERE chat_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, chatId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setChatId(resultSet.getLong("chat_id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setNickName(resultSet.getString("nick_name"));
                user.setEmail(resultSet.getString("email"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User obtenerUsuarioPorEmail(String email) {
        String query = "SELECT * FROM usuarios WHERE email = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Mapea los datos del ResultSet a un objeto User
                // ... (Similar a obtenerUsuarioPorTelegramId)
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void actualizarUsuario(User usuarioConectado) {
        String query = "UPDATE usuarios SET first_name = ?, last_name = ?, nick_name = ?, email = ? WHERE chat_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, usuarioConectado.getFirstName());
            statement.setString(2, usuarioConectado.getLastName());
            statement.setString(3, usuarioConectado.getNickName());
            statement.setString(4, usuarioConectado.getEmail());
            statement.setLong(5, usuarioConectado.getChatId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}