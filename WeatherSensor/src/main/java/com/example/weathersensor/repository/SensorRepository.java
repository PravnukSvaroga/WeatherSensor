package com.example.weathersensor.repository;

import com.example.weathersensor.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    Optional<Sensor> findByName(String name);
    @Query("SELECT DISTINCT s.name FROM Sensor s")
    List<String> findDistinctNames();
}
