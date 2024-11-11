package com.example.weathersensor.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MyErrorResponse {
    int statusCode;
    private String message;
    long timestamp;
}
