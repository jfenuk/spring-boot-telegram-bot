package com.yf86bot.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MainController extends TelegramLongPollingBot {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    private static final String BOT_NAME = "YF86_bot";

    public MainController(final String token) {
        super(token);
    }

    @Override
    public void onUpdatesReceived(final List<Update> updates) {
        updates
                .forEach(this::onUpdateReceived);
    }

    @Override
    public void onUpdateReceived(final Update update) {
        if (update.hasMessage()) {
            var msg = update.getMessage();
            var chatId = msg.getChatId();
            try {
                LOGGER.info("Incoming message: {}", msg.getText());
                var reply = msg.getText().contains("Glory to Ukraine") ? "Glory to the heroes" : "Glory to Ukraine";
                sendNotification(String.valueOf(chatId), reply);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void sendNotification(String chatId, String msg) throws TelegramApiException {
        var response = new SendMessage(chatId, msg);
        execute(response);
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

}
