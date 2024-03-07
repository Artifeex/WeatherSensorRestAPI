package ru.sandr.spring.WeatherSensorRestAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sandr.spring.WeatherSensorRestAPI.dto.MeasurementDTO;
import ru.sandr.spring.WeatherSensorRestAPI.model.Measurement;
import ru.sandr.spring.WeatherSensorRestAPI.model.Sensor;
import ru.sandr.spring.WeatherSensorRestAPI.repositories.MeasurementRepository;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    private final SensorService sensorService;


    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, SensorService sensorService) {
        this.measurementRepository = measurementRepository;
        this.sensorService = sensorService;
    }

    public List<Measurement> getMeasurements() {
        return measurementRepository.findAll();
    }

    public int countRainingDays() {
        return measurementRepository.countMeasurementByIsRaining(true);
    }

    @Transactional()
    public void addMeasurement(Measurement measurement) {
        measurement.setCreatedTime(new Date());
        Sensor sourceSensor = sensorService.findSensorByName(measurement.getSourceSensor().getName()).orElse(null);
        measurement.setSourceSensor(sourceSensor);
        measurementRepository.save(measurement);
    }
}
