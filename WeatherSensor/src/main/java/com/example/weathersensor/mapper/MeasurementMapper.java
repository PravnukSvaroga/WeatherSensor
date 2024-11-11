package com.example.weathersensor.mapper;

import com.example.weathersensor.dto.MeasurementDTO;
import com.example.weathersensor.entity.Measurement;
import com.example.weathersensor.repository.MeasurementRepository;
import com.example.weathersensor.repository.SensorRepository;
import com.example.weathersensor.util.exceptions.SensorNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MeasurementMapper {
    private final SensorRepository sensorRepository;
    private final SensorMapper sensorMapper;
    public MeasurementDTO toDTO(Measurement measurement) {
        return new MeasurementDTO(
                measurement.getValue(),
                measurement.getRaining(),
                sensorMapper.toDTO(measurement.getSensor())
        );
    }
    public Measurement toEntity(MeasurementDTO measurementDTO) {
        Measurement measurement = new Measurement();
        measurement.setValue(measurementDTO.value());
        measurement.setRaining(measurementDTO.raining());
        measurement.setSensor(sensorRepository.findByName(measurementDTO.sensor().name()).orElseThrow(
                () -> new SensorNotFoundException("Sensor with name: " + measurementDTO.sensor().name() + " not found.")));
        return measurement;
    }

}
