package com.example.weathersensor.service;

import com.example.weathersensor.dto.SensorDTO;
import com.example.weathersensor.entity.Sensor;
import com.example.weathersensor.repository.SensorRepository;
import com.example.weathersensor.util.exceptions.SensorNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service

public class SensorService {
    private final SensorRepository sensorRepository;

    public void registration(SensorDTO sensorDTO) {
        sensorRepository.save(convertToSensor(sensorDTO));
    }

    public Sensor findById(int id) {
        return sensorRepository.findById(id).orElseThrow(
                () -> new SensorNotFoundException("Sensor with id: " + id + " not found.")
        );
    }

    public Sensor findByName(String name) {
        return sensorRepository.findByName(name).orElseThrow(
                () -> new SensorNotFoundException("Sensor with name: " + name + " not found.")
        );
    }
    private Sensor convertToSensor(SensorDTO sensorDTO) {
        Sensor sensor = new Sensor();
        sensor.setName(sensorDTO.name());
        return sensor;
    }
}
