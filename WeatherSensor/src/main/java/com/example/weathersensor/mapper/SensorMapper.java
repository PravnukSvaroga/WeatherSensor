package com.example.weathersensor.mapper;

import com.example.weathersensor.dto.SensorDTO;
import com.example.weathersensor.entity.Sensor;
import org.springframework.stereotype.Component;

@Component
public class SensorMapper {
    public Sensor toEntity(SensorDTO sensorDTO) {
        Sensor sensor = new Sensor();
        sensor.setName(sensorDTO.name());
        return sensor;
    }

    public SensorDTO toDTO(Sensor sensor) {
        return new SensorDTO(sensor.getName());
    }

}
