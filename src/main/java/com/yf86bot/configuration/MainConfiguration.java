package com.yf86bot.configuration;

import com.yf86bot.controller.MainController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfiguration {

    private static final String TOKEN = "6067961010:AAEHjkhTKK14S7IVQEGwzRn7QsM_fRInp9A";

    @Bean
    public MainController mainController() {
        return new MainController(TOKEN);
    }

}
