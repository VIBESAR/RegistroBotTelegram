package umg.pricipal.service;

import umg.pricipal.dao.UserDao;
import umg.pricipal.model.User;

public class UserService {
    private UserDao userDao = new UserDao();

    public boolean estaRegistrado(long chatId) {
        return userDao.existeUsuario(chatId);
    }

    public void registrarUsuario(long chatId, String firstName, String lastName, String nickName, String email) {
        userDao.guardarUsuario(chatId, firstName, lastName, nickName, email);
    }

    public User getUserByTelegramId(long chatId) {
        return userDao.obtenerUsuarioPorTelegramId(chatId);
    }

    public User getUserByEmail(String email) {
        return userDao.obtenerUsuarioPorEmail(email);
    }

    public void updateUser(User usuarioConectado) {
        userDao.actualizarUsuario(usuarioConectado);
    }
}

