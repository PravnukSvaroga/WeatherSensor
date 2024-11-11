package com.example.weathersensor.util;

import org.springframework.dao.DataIntegrityViolationException;

public class NotRegisteredException extends DataIntegrityViolationException {
    public NotRegisteredException(String message) {
        super(message);
    }
}
