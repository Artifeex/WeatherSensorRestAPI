package ru.sandr.spring.WeatherSensorRestAPI.util;

import ru.sandr.spring.WeatherSensorRestAPI.dto.MeasurementDTO;
import ru.sandr.spring.WeatherSensorRestAPI.dto.SensorDTO;
import ru.sandr.spring.WeatherSensorRestAPI.model.Measurement;
import ru.sandr.spring.WeatherSensorRestAPI.model.Sensor;

public class Converter {

    public static Sensor convertToSensor(SensorDTO sensorDTO) {
        return new Sensor(sensorDTO.getSensorName());
    }

    public static SensorDTO convertToSensorDTO(Sensor sensor) {
        return new SensorDTO(sensor.getName());
    }

    public static MeasurementDTO convertToMeasurementDTO(Measurement measurement) {
        return new MeasurementDTO(measurement.getTemperature(), measurement.isRaining(),
                convertToSensorDTO(measurement.getSourceSensor()));
    }

    public static Measurement convertToMeasurement(MeasurementDTO measurementDTO) {
        return new Measurement(measurementDTO.getTemperature(), measurementDTO.isRaining(),
                convertToSensor(measurementDTO.getSourceSensor()));
    }

}
