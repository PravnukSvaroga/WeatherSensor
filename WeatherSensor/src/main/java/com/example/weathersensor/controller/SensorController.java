package com.example.weathersensor.controller;

import com.example.weathersensor.dto.SensorDTO;
import com.example.weathersensor.entity.Sensor;
import com.example.weathersensor.service.SensorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sensors")
public class SensorController {
    private final SensorService service;

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid SensorDTO sensorDTO) {
        service.registration(sensorDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
