package ru.professornails.julsbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramService extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "JulsBot";
    }

    @Override
    public String getBotToken() {
        return "1760538550:AAH930FD9JuLNINSAkEVJeq5M_KAuwHwwHw";
    }

    @Override
    public void onUpdateReceived(Update update) {

        if(update.hasMessage()){
            Message message = update.getMessage();

            if(message.hasText()){
                SendMessage sendMes = new SendMessage();
                sendMes.setChatId(message.getChatId().toString());
                sendMes.setText(message.getText());
                    try {
                        execute(sendMes);
                    } catch (TelegramApiException e) {

                    }
                }
            }

    }
}
