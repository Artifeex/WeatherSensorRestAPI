package ru.sandr.spring.WeatherSensorRestAPI.util.measurement;

public class MeasurementErrorResponse {

    private String error;

    public MeasurementErrorResponse(String error) {
        this.error = error;
    }

    public MeasurementErrorResponse() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
