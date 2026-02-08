package com.booking.demo.dto;

import lombok.Data;

@Data
public class RentalDTO {
    
    private String rentalUserName;
    private String rentalUserContact;
    private String rentalUserCarType;
    private String rentalPickupDate;
    private String rentalReturnDate;
}
