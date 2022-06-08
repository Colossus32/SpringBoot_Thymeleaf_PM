package com.colossus.projectmanagement.telegram;

import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class TelegramBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "@colossus_project_management_bot";
    }

    @Override
    public String getBotToken() {
        return "5496524401:AAEKMDW867RO6byGC4xXMFbhu6FZ7Uf2wUI";
    }

    @Override
    public void onUpdateReceived(Update update) {

    }

    public static void main(String[] args) throws Exception {
        TelegramBot bot = new TelegramBot();
        SendMessage message = new SendMessage();
        message.setChatId("1126891709");
        message.setText("i'm from java homie!");
        bot.execute(message);
    }


}
