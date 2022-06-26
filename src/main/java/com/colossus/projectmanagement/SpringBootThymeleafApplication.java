package com.colossus.projectmanagement;

import com.colossus.projectmanagement.telegrambot.BotForTelegram;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootThymeleafApplication{

    public static void main(String[] args) {
        SpringApplication.run(SpringBootThymeleafApplication.class, args);
        new BotForTelegram().listen();
    }
}
