package com.booking.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.demo.dto.BookingDTO;
import com.booking.demo.dto.DataResponseDTO;
import com.booking.demo.dto.RentalDTO;
import com.booking.demo.service.TelegramNotificationService;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/car")
public class BookingController {

   
   @Autowired
   private TelegramNotificationService telegramNotification;
   
   @PostMapping("/book")
   public ResponseEntity<?> booking(@RequestBody @Valid  BookingDTO request) throws Exception {
    telegramNotification.sendBookingToOwner(request);
    return ResponseEntity.ok(new DataResponseDTO("Details Send Successfully to the Owner"));

   }

   @PostMapping("/rent")
   public ResponseEntity<?> renting(@Valid @RequestBody RentalDTO request) throws Exception {
    telegramNotification.sendRentalToOwner(request);
    return ResponseEntity.ok(new DataResponseDTO("Details Send Successfully to the Owner"));

   }
   
   @PostMapping("/mock/{testVariable}")
   public ResponseEntity<?> mockMethod(@PathVariable String testVariable)
   {
      return ResponseEntity.ok("This Reached The End Point Successfully"+testVariable);
   }
   // @GetMapping("/distance")
   // public ResponseEntity<Map<String, Object>> getDistanceAndCost(
   //       @RequestParam String pickup,
   //       @RequestParam String destination) {
   //    double[] start = distanceService.getCoordinates(pickup);
   //    double[] end = distanceService.getCoordinates(destination);
   //    double distanceKm = distanceService.calculateDistance(start, end);
   //    double pricePerKm = 15;
   //    double totalCost = distanceKm * pricePerKm;

   //    Map<String, Object> response = new HashMap<>();
   //    response.put("distanceKm", distanceKm);
   //    response.put("totalCost", totalCost);

   //    return ResponseEntity.ok(response);
   // }

}
