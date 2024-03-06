package ru.sandr.spring.WeatherSensorRestAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class MeasurementDTO {


    @NotEmpty(message = "Field value(temperature) should not be empty")
    @Min(value = -100, message = "Field value(temperature) should be greater than -100")
    @Max(value = 100, message = "Field value(temperature) should be smaller than 100")
    private double temperature;

    @NotEmpty(message = "Field raining should not be empty")
    private boolean isRaining;

    @NotEmpty(message = "Field sensor should not be empty")
    private SensorDTO sensorSource;

    public MeasurementDTO() {
    }

    public double getTemperature() {
        return temperature;
    }

    @JsonProperty("value")
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public boolean isRaining() {
        return isRaining;
    }

    @JsonProperty("raining")
    public void setRaining(boolean raining) {
        isRaining = raining;
    }

    public SensorDTO getSensorSource() {
        return sensorSource;
    }

    @JsonProperty("sensor")
    public void setSensorSource(SensorDTO sensorSource) {
        this.sensorSource = sensorSource;
    }
}
