// package com.booking.demo.service;

// import java.net.URLEncoder;
// import java.nio.charset.StandardCharsets;
// import java.util.List;
// import java.util.Map;

// import org.json.JSONArray;
// import org.json.JSONObject;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.http.HttpEntity;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;


// @Service
// public class DistanceService {

//     @Value("${openroute.api.key}")
//     private String apiKey;

//     @Value("${openroute.api.url}")
//     private String apiUrl;

//     public double calculateDistance(double[] start, double[] end) {
//         RestTemplate restTemplate = new RestTemplate();

//         HttpHeaders headers = new HttpHeaders();
//         headers.setContentType(MediaType.APPLICATION_JSON);
//         headers.set("Authorization", apiKey);

//         Map<String, Object> coordinates = Map.of("coordinates", new double[][]{start, end});

//         HttpEntity<Map<String, Object>> request = new HttpEntity<>(coordinates, headers);

//         ResponseEntity<Map> response = restTemplate.postForEntity(apiUrl, request, Map.class);

//         if (response.getStatusCode() == HttpStatus.OK) {
//             var routes = (List<Map<String, Object>>) response.getBody().get("routes");
//             var summary = (Map<String, Object>) routes.get(0).get("summary");
//             double distanceMeters = ((Number) summary.get("distance")).doubleValue();
//             return distanceMeters / 1000.0; // convert to kilometers
//         } else {
//             throw new RuntimeException("Failed to calculate distance");
//         }
//     }

//     public  double[] getCoordinates(String placeName) {
//     String url = "https://api.openrouteservice.org/geocode/search"
//         + "?api_key=" + apiKey
//         + "&text=" + URLEncoder.encode(placeName, StandardCharsets.UTF_8);

//     RestTemplate restTemplate = new RestTemplate();
//     ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

//     JSONObject json = new JSONObject(response.getBody());
//     JSONArray coordinates = json
//         .getJSONArray("features")
//         .getJSONObject(0)
//         .getJSONObject("geometry")
//         .getJSONArray("coordinates");

//     double lon = coordinates.getDouble(0);
//     double lat = coordinates.getDouble(1);
//     return new double[] {lon, lat};
// }

// }
