package com.booking.demo.dto;

import lombok.Data;

@Data
public class DataResponseDTO {
    String message;

    public DataResponseDTO(String message)
    {
        this.message = message;
    }
}
