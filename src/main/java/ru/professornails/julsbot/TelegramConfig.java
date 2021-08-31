package ru.professornails.julsbot;

import org.springframework.stereotype.Component;

@Component
public class TelegramConfig {
    private String username = "JulsBot";
    private String token = "1760538550:AAH930FD9JuLNINSAkEVJeq5M_KAuwHwwHw";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
