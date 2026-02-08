package com.booking.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.booking.demo.dto.BookingDTO;
import com.booking.demo.dto.RentalDTO;
import com.booking.demo.utility.MessageTemplateUtility;

@Service
public class TelegramNotificationService {

    @Value("${telegram.bot.token}")
    private String botToken;

    @Value("${telegram.owner.chatId}")
    private String ownerChatId;

    public void sendBookingToOwner(BookingDTO dto) {

        String message = MessageTemplateUtility.sendNewOrderToOwner(dto);

        String url = "https://api.telegram.org/bot" + botToken + "/sendMessage";

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> request = new HashMap<>();
        
        request.put("chat_id", ownerChatId);
        request.put("text", message);
        request.put("parse_mode", "Markdown");

        restTemplate.postForObject(url, request, String.class);
    }

     public void sendRentalToOwner(RentalDTO dto) {

        String message = MessageTemplateUtility.sendNewRentalToOwner(dto);

        String url = "https://api.telegram.org/bot" + botToken + "/sendMessage";

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> request = new HashMap<>();
        
        request.put("chat_id", ownerChatId);
        request.put("text", message);
        request.put("parse_mode", "Markdown");

        restTemplate.postForObject(url, request, String.class);
    }
}
