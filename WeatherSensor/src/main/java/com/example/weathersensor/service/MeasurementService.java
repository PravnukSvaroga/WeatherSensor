package com.example.weathersensor.service;

import com.example.weathersensor.dto.MeasurementDTO;
import com.example.weathersensor.entity.Measurement;
import com.example.weathersensor.entity.Sensor;
import com.example.weathersensor.mapper.MeasurementMapper;
import com.example.weathersensor.repository.MeasurementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MeasurementService {
    private final MeasurementRepository measurementRepository;
    private final MeasurementMapper measurementMapper;

    public void add(MeasurementDTO measurementDTO) {
        measurementRepository.save(measurementMapper.toEntity(measurementDTO));
    }

    public List<MeasurementDTO> findAll() {
        List<Measurement> measurements = measurementRepository.findAll();
        List<MeasurementDTO> measurementDTOs = new ArrayList<>();
        for (Measurement measurement: measurements)
            measurementDTOs.add(measurementMapper.toDTO(measurement));
        return measurementDTOs;
    }

    public int rainyDaysCount() {
        return measurementRepository.countAllByRainingIsTrue();
    }
}

