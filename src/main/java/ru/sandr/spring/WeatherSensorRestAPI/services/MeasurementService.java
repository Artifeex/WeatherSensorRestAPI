package ru.sandr.spring.WeatherSensorRestAPI.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sandr.spring.WeatherSensorRestAPI.repositories.MeasurementRepository;

@Service
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepository measurementRepository;


    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    public void addMeasurement() {

    }
}
