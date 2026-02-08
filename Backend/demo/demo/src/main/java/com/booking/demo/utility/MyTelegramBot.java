package com.booking.demo.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class MyTelegramBot extends TelegramLongPollingBot {


    String botUsername;
    
    String botToken;

    
    public MyTelegramBot(@Value("${telegram.bot.username}")String botUsername,@Value("${telegram.bot.token}")String botToken)
    {
        super(botToken);
        this.botToken= botToken;
        this.botUsername = botUsername;
    }
    
    @Override
    public void onUpdateReceived(Update update) {
       
        if(update.hasCallbackQuery())
            {
                String callBackMessage = update.getCallbackQuery().getData();
                Long chatId = update.getCallbackQuery().getMessage().getChatId();

                switch (callBackMessage) {

                case "BOOK":
                    
                    break;
                
                case "CONTACT":
                  
                    break;

            }
        }
        
        if(update.hasMessage() && update.getMessage().hasText())
        {
            String message = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if(message.equals("/start"))
            {
                MessageTemplateUtility.sendWelcomeMessage(this,chatId);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

}
