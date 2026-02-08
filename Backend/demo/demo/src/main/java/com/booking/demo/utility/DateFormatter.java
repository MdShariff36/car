package com.booking.demo.utility;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter 
{
     public static String getFormattedDateTime() {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMM dd");
        String formattedDate = currentDate.format(dateFormatter);

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm");
        String formattedTime = currentTime.format(timeFormatter);

        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        String dayOfWeekFormatted = dayOfWeek.name();  
       
        return String.format("%s, %s ,Time: %s", 
                dayOfWeekFormatted.substring(0, 1).toUpperCase() + dayOfWeekFormatted.substring(1).toLowerCase(), 
                formattedDate, formattedTime);
    }   
}
