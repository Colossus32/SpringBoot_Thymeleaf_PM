package com.colossus.projectmanagement.telegram;

import com.colossus.projectmanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class TelegramBot extends TelegramLongPollingBot {

    @Autowired
    private ProjectService service;

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

        if (update.hasMessage() && update.getMessage().hasText()){
            SendMessage sendMessage = new SendMessage();

            String message_text = update.getMessage().getText();
            String chat_id = String.valueOf(update.getMessage().getChatId());
            if (message_text.equals("/report")){



                sendMessage.setChatId(chat_id);
                sendMessage.setText(service.getReport());

                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }

   /* public static void main(String[] args) throws Exception {
        TelegramBot bot = new TelegramBot();
        SendMessage message = new SendMessage();
        message.setChatId("1126891709");
        message.setText("i'm from java homie!");
        bot.execute(message);
    }*/


}
