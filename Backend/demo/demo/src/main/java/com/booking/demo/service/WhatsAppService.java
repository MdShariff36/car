// package com.booking.demo.service;

// import java.util.HashMap;
// import java.util.Map;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.http.*;
// import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;

// import com.booking.demo.dto.BookingDTO;
// import com.booking.demo.utility.DateFormatter;

// @Service
// public class WhatsAppService {

//     @Value("${whatsapp.api.url}")
//     private String whatsappApiUrl;

//     @Value("${whatsapp.api.token}")
//     private String whatsappApiToken;

//     final String number = "918610009342";

//     public String sendBookingMessage(BookingDTO request) {
//         try {
           
//             // Prepare the message
//             Map<String, Object> messageBody = new HashMap<>();
//             messageBody.put("messaging_product", "whatsapp");
//             messageBody.put("to", number);
//             messageBody.put("type", "template");

//             Map<String, Object> template = new HashMap<>();
//             template.put("name", "booking_notification");
//             template.put("language", Map.of("code", "en_US"));

//             Map<String, Object> bodyComponent = Map.of(
//                 "type", "body",
//                 "parameters", new Object[] {
//                     Map.of("type", "text", "text", request.getName()),
//                     Map.of("type", "text", "text", request.getPhNumber()),
//                     Map.of("type", "text", "text", request.getPickUpPlace()),
//                     Map.of("type", "text", "text", request.getDestination()),
//                     Map.of("type", "text", "text", request.getPickUpDate()),
//                 }
//             );

//             template.put("components", new Object[] { bodyComponent });
//             messageBody.put("template", template);

//             // Set Headers
//             HttpHeaders headers = new HttpHeaders();
//             headers.setContentType(MediaType.APPLICATION_JSON);
//             headers.setBearerAuth(whatsappApiToken);

//             HttpEntity<Map<String, Object>> order = new HttpEntity<>(messageBody, headers);

//             // Send request
//             RestTemplate restTemplate = new RestTemplate();
//             ResponseEntity<String> response = restTemplate.exchange(
//                 whatsappApiUrl,
//                 HttpMethod.POST,
//                 order,
//                 String.class
//             );

//             return null;
//         } catch (Exception e) {
//             e.printStackTrace();
//              return "Unable to Proceed ";
//         }
//     }
// }
