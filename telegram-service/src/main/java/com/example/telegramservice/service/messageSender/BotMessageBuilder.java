package com.example.telegramservice.service.messageSender;

import com.example.telegramservice.commands.BotCommands;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
public class BotMessageBuilder {

    public static SendMessage buildMessage(String message, String chatId) {
        SendMessage.SendMessageBuilder builder = SendMessage.builder();

        builder.chatId(chatId);

        if (message.contains(BotCommands.HELLO.getCommandName())) {
            builder.text("Привет твій id " + chatId);
        }

        if (message.contains(BotCommands.CHAT_ID.getCommandName())) {
            builder.text("ID Канала : " + chatId);
        }

        return builder.build();
    }
}
