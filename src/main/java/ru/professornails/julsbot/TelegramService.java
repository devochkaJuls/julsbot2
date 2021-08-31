package ru.professornails.julsbot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramService extends TelegramLongPollingBot {
    private TelegramConfig telegramConfig;
    private WeatherService weatherService;

    public TelegramService(TelegramConfig telegramConfig, WeatherService weatherService) {
        this.telegramConfig = telegramConfig;
        this.weatherService = weatherService;
    }

    @Override
    public String getBotUsername() {
        return this.telegramConfig.getUsername();
    }

    @Override
    public String getBotToken() {
        return this.telegramConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {

        if(update.hasMessage()){
            Message message = update.getMessage();

            if(message.hasText()){
                String cityName = message.getText();
                String weather = this.weatherService.getTodayWeather(cityName);

                SendMessage sendMes = new SendMessage();
                sendMes.setChatId(message.getChatId().toString());
                sendMes.setText(weather);

                try {
                    execute(sendMes);
                } catch (TelegramApiException e) {

                }
            }
        }

    }
}
