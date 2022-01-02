package com.example.telegramservice.commands;

public enum BotCommands {
    HELLO("/hello"), NEW_MERCHANDISE("/get_new"), CHAT_ID("/chartId");

    private String commandName;

    BotCommands(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
