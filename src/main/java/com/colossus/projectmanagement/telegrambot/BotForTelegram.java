package com.colossus.projectmanagement.telegrambot;

import com.colossus.projectmanagement.entity.ListProjectsFromDataBase;
import com.colossus.projectmanagement.entity.Project;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.SendMessage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BotForTelegram {

    TelegramBot bot;

    public BotForTelegram() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("token.txt"));
            String token = reader.readLine();
            reader.close();
            this.bot = new TelegramBot(token);
        } catch (Exception e){
            System.out.println("bot initialisation error");
            e.printStackTrace();
        }
    }

    public void listen(){
        bot.setUpdatesListener(element ->{
            element.forEach(pock ->{
                if (pock.message().text().equals("report")){
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create("http://localhost:8081/api/month"))
                            .build();
                    try {
                        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

                        bot.execute(new SendMessage(pock.message().chat().id(), response.body()));
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }
}
