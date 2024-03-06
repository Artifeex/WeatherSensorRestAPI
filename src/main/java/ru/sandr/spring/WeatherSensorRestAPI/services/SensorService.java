package ru.sandr.spring.WeatherSensorRestAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sandr.spring.WeatherSensorRestAPI.model.Sensor;
import ru.sandr.spring.WeatherSensorRestAPI.repositories.MeasurementRepository;
import ru.sandr.spring.WeatherSensorRestAPI.repositories.SensorRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SensorService {

    private final MeasurementRepository measurementRepository;
    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(MeasurementRepository measurementRepository, SensorRepository sensorRepository) {
        this.measurementRepository = measurementRepository;
        this.sensorRepository = sensorRepository;
    }

    @Transactional
    public void registerSensor(Sensor sensor) {
        sensorRepository.save(sensor);
    }

    public Optional<Sensor> findSensorByName(String sensorName) {
        return sensorRepository.findByName(sensorName);
    }
}
