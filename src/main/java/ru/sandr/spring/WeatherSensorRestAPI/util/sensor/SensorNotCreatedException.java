package ru.sandr.spring.WeatherSensorRestAPI.util.sensor;

public class SensorNotCreatedException extends RuntimeException{

    public SensorNotCreatedException(String msg) {
        super(msg);
    }
}
