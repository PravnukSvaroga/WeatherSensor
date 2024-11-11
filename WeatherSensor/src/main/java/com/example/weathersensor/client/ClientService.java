package com.example.weathersensor.client;

import com.example.weathersensor.dto.MeasurementDTO;
import com.example.weathersensor.dto.SensorDTO;
import com.example.weathersensor.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.internal.bytebuddy.matcher.FilterableList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class ClientService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final SensorRepository sensorRepository;
    public void sendMeasurementsToSelf(int count, String url) {
        for (int i = 0; i < count; i++) {
            MeasurementDTO measurement = randomGenerate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");
            HttpEntity<MeasurementDTO> request = new HttpEntity<>(measurement, headers);
            ResponseEntity<HttpStatus> response = restTemplate.postForEntity(url, request, HttpStatus.class);
        }

    }

    private MeasurementDTO randomGenerate() {
        List<String> sensors = sensorRepository.findDistinctNames();
        return new MeasurementDTO(
                new Random().nextDouble(200) - 100,
                new Random().nextBoolean(),
                new SensorDTO(sensors.get(new Random().nextInt(sensors.size())))
        );
    }
}
