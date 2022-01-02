package com.example.telegramservice.service;

import com.example.telegramservice.config.BotConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@Slf4j
public class Bot extends TelegramLongPollingBot {

    private final BotConfig config;
    private final String test = "662449862";

    public Bot(BotConfig config) {
        this.config = config;
    }

    public void send(String text) {
        var message = SendMessage.builder()
                .chatId(test)
                .text(text)
                .build();

        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.debug(e.toString());
        }
    }

    public void onUpdateReceived(Update update) {
        update.getUpdateId();
        String messageText;
        String chatId;

        if (update.getMessage() != null) {
            chatId = update.getMessage().getChatId().toString();
            messageText = update.getMessage().getText();
        } else {
            chatId = update.getChannelPost().getChatId().toString();
            messageText = update.getChannelPost().getText();
        }


        try {
            execute(BotMessageBuilder.buildMessage(messageText, chatId));
        } catch (TelegramApiException e) {
            log.debug(e.toString());
        }
    }


    public String getBotUsername() {
        return config.getBotUserName();
    }

    public String getBotToken() {
        return config.getToken();
    }

}
