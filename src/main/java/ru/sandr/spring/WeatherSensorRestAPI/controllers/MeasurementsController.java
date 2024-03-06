package ru.sandr.spring.WeatherSensorRestAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sandr.spring.WeatherSensorRestAPI.dto.MeasurementDTO;
import ru.sandr.spring.WeatherSensorRestAPI.model.Measurement;
import ru.sandr.spring.WeatherSensorRestAPI.services.MeasurementService;
import ru.sandr.spring.WeatherSensorRestAPI.util.measurement.MeasurementValidator;

@Controller
@RequestMapping("/measurement")
public class MeasurementsController {

    private final MeasurementService measurementService;
    private final MeasurementValidator measurementValidator;


    @Autowired
    public MeasurementsController(MeasurementService measurementService, MeasurementValidator measurementValidator) {
        this.measurementService = measurementService;
        this.measurementValidator = measurementValidator;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addMeasurement(@RequestBody MeasurementDTO measurementDTO, BindingResult bindingResult) {
        measurementValidator.validate(measurementDTO, bindingResult);

    }

    private Measurement convertToMeasurement(MeasurementDTO measurementDTO) {

    }
}
