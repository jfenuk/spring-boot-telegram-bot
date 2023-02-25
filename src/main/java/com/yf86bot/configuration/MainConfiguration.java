package com.yf86bot.configuration;

import com.yf86bot.controller.MainController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfiguration {

    @Value("${TELEGRAM_TOKEN}")
    private String telegramToken;

    @Bean
    public MainController mainController() {
        return new MainController(telegramToken);
    }

}
