package com.example.weathersensor.client;

import com.example.weathersensor.dto.MeasurementDTO;
import com.example.weathersensor.dto.SensorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class ClientController {
    private final ClientService clientService;
    @GetMapping("/sendMeasurement")
    public ResponseEntity<HttpStatus> sendMeasurementToSelf(@RequestParam int count) {
        String url = "http://localhost:8080/measurements/add";
        clientService.sendMeasurementsToSelf(count, url);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
