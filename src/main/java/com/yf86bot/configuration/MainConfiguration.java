package com.yf86bot.configuration;

import com.yf86bot.controller.MainController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainConfiguration.class);
    @Value("${telegram.token}")
    private String telegramToken;

    @Bean
    public MainController mainController() {
        LOGGER.info("Telegram token value: {}", telegramToken);
        return new MainController(telegramToken);
    }

}
