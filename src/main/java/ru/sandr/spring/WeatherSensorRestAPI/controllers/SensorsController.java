package ru.sandr.spring.WeatherSensorRestAPI.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.sandr.spring.WeatherSensorRestAPI.dto.SensorDTO;
import ru.sandr.spring.WeatherSensorRestAPI.model.Sensor;
import ru.sandr.spring.WeatherSensorRestAPI.services.SensorService;
import ru.sandr.spring.WeatherSensorRestAPI.util.sensor.SensorErrorResponse;
import ru.sandr.spring.WeatherSensorRestAPI.util.sensor.SensorNotCreatedException;
import ru.sandr.spring.WeatherSensorRestAPI.util.sensor.SensorValidator;

import java.util.List;

@RestController
public class SensorsController {

    private final SensorService sensorService;
    private final SensorValidator sensorValidator;

    @Autowired
    public SensorsController(SensorService sensorService, SensorValidator sensorValidator) {
        this.sensorService = sensorService;
        this.sensorValidator = sensorValidator;
    }

    @PostMapping("/sensors/registration")
    public ResponseEntity<Void> sensorRegistration(@RequestBody @Valid SensorDTO sensorDTO, BindingResult bindingResult) {
        sensorValidator.validate(sensorDTO, bindingResult);
        if(bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error : errors) {
                errorMessage.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append(";");
            }
            throw new SensorNotCreatedException(errorMessage.toString());
        }
        sensorService.registerSensor(convertToSensor(sensorDTO));
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler
    public ResponseEntity<SensorErrorResponse> handleException(SensorNotCreatedException exception) {
        return new ResponseEntity<>(new SensorErrorResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    private Sensor convertToSensor(SensorDTO sensorDTO) {
        return new Sensor(sensorDTO.getSensorName());
    }

}
