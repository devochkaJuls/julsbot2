package ru.professornails.julsbot;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class Launcher {
    private TelegramService telegramService;

    public Launcher(TelegramService telegramService) {
        this.telegramService = telegramService;
    }

    @EventListener(value = ContextRefreshedEvent.class)
    public void start() throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(this.telegramService);
    }
}
