package com.booking.demo.utility;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import com.booking.demo.dto.BookingDTO;
import com.booking.demo.dto.RentalDTO;

public class MessageTemplateUtility 
{
    public static void sendWelcomeMessage(MyTelegramBot bot,Long chatId) {
    SendMessage message = new SendMessage();
    message.setChatId(chatId.toString());
    message.setText("👋 Hello! How can we help you today?");

    InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
    List<List<InlineKeyboardButton>> rows = new ArrayList<>();

    List<InlineKeyboardButton> row1 = new ArrayList<>();
    row1.add(InlineKeyboardButton.builder()
        .text("📅 Book a Ride")
        .callbackData("BOOK")
        .build());

    List<InlineKeyboardButton> row2 = new ArrayList<>();
    row2.add(InlineKeyboardButton.builder()
        .text("📞 Contact Support")
        .callbackData("CONTACT")
        .build());

    rows.add(row1);
    rows.add(row2);
    markup.setKeyboard(rows);

    message.setReplyMarkup(markup);

    try {
        bot.execute(message); // from TelegramLongPollingBot
    } catch (TelegramApiException e) {
        e.printStackTrace();
    }
}

    public static String sendNewOrderToOwner(BookingDTO dto) {
        return """
                🚖 *New Booking Received!* 

                 *Date : %s*
                ------------------------------------------------

                👤 Name: %s

                📞 Phone: %s

                🚗 Selected Car: %s

                📍 Pickup: %s

                🛤️ Trip Type : %s

                📌 Destination: %s

                📅 PickUp Date: %s

                ------------------------------------------------

                end of this notification....
                """.formatted(DateFormatter.getFormattedDateTime(),
                dto.getUserName(), dto.getUserContact(),dto.getUserCarType(), dto.getPickUp(), dto.getTripType(),
                dto.getDropOff(), dto.getPickUpDate());
    }
    
     public static String sendNewRentalToOwner(RentalDTO dto) {
        return """
                🚖 *New Rental Received!*
                ------------------------------------------------

                👤 Name: %s

                📞 Phone: %s

                🚗 Selected Car: %s

                📅 PickUp Date: %s

                📅 Return Date: %s
                ------------------------------------------------

                end of this notification....
                """.formatted(dto.getRentalUserName(),
                              dto.getRentalUserContact(),
                              dto.getRentalUserCarType(),
                              dto.getRentalPickupDate(),
                              dto.getRentalReturnDate());
    }

}
