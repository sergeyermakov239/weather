package com.example.weather;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Collections;

@Component
public class Bot extends TelegramLongPollingBot {
    public static final String TOKEN = "5056913305:AAGIe3Fi25jLQWF-2pCwgTnh_Wx__EyFa_A";
    public static final String USERNAME = "BestWeather239bot";
    public Weather weather=new Weather();
    @Override
    public String getBotUsername() {
        return USERNAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
        SendMessage sendMessage = new SendMessage();
        Long chatId = update.getMessage().getChatId();
        sendMessage.setChatId(String.valueOf(chatId));
        String message = String.valueOf(update.getMessage().getText());
        String s = weather.request(message);

        sendMessage.setText(s);
        execute(sendMessage);


        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }
}
