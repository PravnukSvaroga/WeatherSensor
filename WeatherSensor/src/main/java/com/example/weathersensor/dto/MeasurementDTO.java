package com.example.weathersensor.dto;

import lombok.Builder;

@Builder
public record MeasurementDTO(Double value, Boolean raining, SensorDTO sensor) {
}
