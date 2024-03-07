package ru.sandr.spring.WeatherSensorRestAPI.util.measurement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.sandr.spring.WeatherSensorRestAPI.dto.MeasurementDTO;
import ru.sandr.spring.WeatherSensorRestAPI.dto.SensorDTO;
import ru.sandr.spring.WeatherSensorRestAPI.services.SensorService;

@Component
public class MeasurementValidator implements Validator {

    private final SensorService sensorService;

    @Autowired
    public MeasurementValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return SensorDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MeasurementDTO measurementDTO = (MeasurementDTO) target;
        if(sensorService.findSensorByName(measurementDTO.getSourceSensor().getSensorName()).isEmpty()) {
            errors.rejectValue("sourceSensor", "", "Sensor with this name doesn't exist!");
        }
    }
}
