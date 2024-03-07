package ru.sandr.spring.WeatherSensorRestAPI.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.sandr.spring.WeatherSensorRestAPI.dto.MeasurementDTO;
import ru.sandr.spring.WeatherSensorRestAPI.model.Measurement;
import ru.sandr.spring.WeatherSensorRestAPI.services.MeasurementService;
import ru.sandr.spring.WeatherSensorRestAPI.util.Converter;
import ru.sandr.spring.WeatherSensorRestAPI.util.measurement.CountRainingDaysResponse;
import ru.sandr.spring.WeatherSensorRestAPI.util.measurement.MeasurementErrorResponse;
import ru.sandr.spring.WeatherSensorRestAPI.util.measurement.MeasurementNotAddedException;
import ru.sandr.spring.WeatherSensorRestAPI.util.measurement.MeasurementValidator;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/measurement")
public class MeasurementsController {

    private final MeasurementService measurementService;
    private final MeasurementValidator measurementValidator;

    private final ModelMapper modelMapper;


    @Autowired
    public MeasurementsController(MeasurementService measurementService, MeasurementValidator measurementValidator, ModelMapper modelMapper) {
        this.measurementService = measurementService;
        this.measurementValidator = measurementValidator;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addMeasurement(@RequestBody @Valid MeasurementDTO measurementDTO, BindingResult bindingResult) {
        measurementValidator.validate(measurementDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (var error : errors) {
                errorMessage.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append(";");
            }
            throw new MeasurementNotAddedException(errorMessage.toString());
        }
        measurementService.addMeasurement(Converter.convertToMeasurement(measurementDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping()
    public List<MeasurementDTO> getListMeasurements() {
        return measurementService.getMeasurements().stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private MeasurementDTO convertToDto(Measurement measurement) {
        return modelMapper.map(measurement, MeasurementDTO.class);
    }

    @ExceptionHandler
    private ResponseEntity<MeasurementErrorResponse> exceptionHandler(MeasurementNotAddedException exception) {
        return new ResponseEntity<>(new MeasurementErrorResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/rainyDaysCount")
    public ResponseEntity<CountRainingDaysResponse> getCountRainingDays() {
        return new ResponseEntity<>(new CountRainingDaysResponse(measurementService.countRainingDays()), HttpStatus.OK);
    }

}
