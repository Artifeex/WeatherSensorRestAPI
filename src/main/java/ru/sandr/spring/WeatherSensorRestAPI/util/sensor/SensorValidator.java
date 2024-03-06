package ru.sandr.spring.WeatherSensorRestAPI.util.sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.sandr.spring.WeatherSensorRestAPI.dto.SensorDTO;
import ru.sandr.spring.WeatherSensorRestAPI.model.Sensor;
import ru.sandr.spring.WeatherSensorRestAPI.services.SensorService;

@Component
public class SensorValidator implements Validator {

    private final SensorService sensorService;

    @Autowired
    public SensorValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return SensorDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SensorDTO sensorToValidate = (SensorDTO) target;
        if(sensorService.findSensorByName(sensorToValidate.getSensorName()).isPresent()) {
            errors.rejectValue("sensorName", "", "Sensor with this name is already exist!");
        }
    }
}
