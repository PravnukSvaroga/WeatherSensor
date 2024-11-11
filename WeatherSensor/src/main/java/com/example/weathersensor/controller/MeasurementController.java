package com.example.weathersensor.controller;

import com.example.weathersensor.dto.MeasurementDTO;
import com.example.weathersensor.entity.Measurement;
import com.example.weathersensor.service.MeasurementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurements")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MeasurementController {

    private final MeasurementService service;

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid MeasurementDTO measurementDTO) {
        service.add(measurementDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping()
    public List<MeasurementDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/rainyDaysCount")
    public int rainyDaysCount() {
        return service.rainyDaysCount();
    }

}
