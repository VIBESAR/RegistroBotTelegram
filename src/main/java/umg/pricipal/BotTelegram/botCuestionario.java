package umg.pricipal.BotTelegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.BotOptions;

import static jdk.javadoc.internal.tool.Main.execute;

public class botCuestionario extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        // Retorna el nombre de usuario del bot
        return "CuyeyoBot";
    }

    @Override
    public String getBotToken() {
        // Retorna el token del bot
        return "7188721547:AAF4HpjgFg8ZXIV2CLoG2GhdLRpeLhNLpjA";
    }

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            String text = update.getMessage().getText();

            SendMessage message = new SendMessage();
            message.setChatId(String.valueOf(chatId));
            message.setText("Recibido: " + text);

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}