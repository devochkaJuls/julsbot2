package ru.professornails.julsbot;

import org.springframework.stereotype.Component;

@Component
public class WeatherService {
    public String getTodayWeather(String cityName) {
        return "Сегодня в городе " + cityName + " +25, дощ";
    }
}
