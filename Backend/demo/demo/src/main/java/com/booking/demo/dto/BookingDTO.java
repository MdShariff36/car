package com.booking.demo.dto;
import com.booking.demo.Constants.TripType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class BookingDTO {

    @NotBlank(message = "User name is required")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must contain only letters")
    private String userName;

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Invalid contact number")
    private String userContact;

    @NotBlank(message = "Car type is required")
    private String userCarType;

    @NotBlank(message = "Pickup location is required")
    private String pickUp;

    @NotBlank(message = "Drop-off location is required")
    private String dropOff;

    private  TripType tripType;

    private String pickUpDate;
}
