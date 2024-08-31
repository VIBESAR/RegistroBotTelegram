package umg.pricipal;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import umg.pricipal.BotTelegram.botCuestionario;

public class Main {

    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot((LongPollingBot) new botCuestionario());
            System.out.println("El bot se ha registrado correctamente.");
        } catch (TelegramApiException e) {
            System.err.println("Error al registrar el bot: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Se ha producido un error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

