package umg.pricipal.service;

import umg.pricipal.dao.RespuestaDao;

public class RespuestaService {
    private RespuestaDao respuestaDao = new RespuestaDao();

    public void guardarRespuesta(long chatId, String section, int questionIndex, String responseText) {
        respuestaDao.insertarRespuesta(chatId, section, questionIndex, responseText);
    }
}

