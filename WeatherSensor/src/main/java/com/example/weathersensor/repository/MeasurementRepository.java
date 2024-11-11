package com.example.weathersensor.repository;

import com.example.weathersensor.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
    int countAllByRainingIsTrue();
}
