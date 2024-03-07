package ru.sandr.spring.WeatherSensorRestAPI.util.measurement;

public class MeasurementNotAddedException extends RuntimeException {

    public MeasurementNotAddedException(String msg) {
        super(msg);
    }
}
