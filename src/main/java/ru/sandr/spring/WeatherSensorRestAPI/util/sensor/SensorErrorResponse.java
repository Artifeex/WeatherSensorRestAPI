package ru.sandr.spring.WeatherSensorRestAPI.util.sensor;

public class SensorErrorResponse {

    private String error;

    public SensorErrorResponse(String error) {
        this.error = error;
    }

    public SensorErrorResponse() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
