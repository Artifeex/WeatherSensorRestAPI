package ru.sandr.spring.WeatherSensorRestAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public class MeasurementDTO {


    @NotNull(message = "Field value(temperature) should not be empty")
    @Min(value = -100, message = "Field value(temperature) should be greater than -100")
    @Max(value = 100, message = "Field value(temperature) should be smaller than 100")
    private Double temperature;

    @NotNull(message = "Field raining should not be empty")
    private Boolean isRaining;

    //@NotBlank(message = "Field sensor should not be empty")
    private SensorDTO sourceSensor;

    public MeasurementDTO() {
    }

    public MeasurementDTO(double temperature, boolean isRaining, SensorDTO sourceSensor) {
        this.temperature = temperature;
        this.isRaining = isRaining;
        this.sourceSensor = sourceSensor;
    }

    @JsonProperty("value")
    public double getTemperature() {
        return temperature;
    }

    @JsonProperty("value")
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @JsonProperty("raining")
    public boolean isRaining() {
        return isRaining;
    }

    @JsonProperty("raining")
    public void setRaining(boolean raining) {
        isRaining = raining;
    }

    @JsonProperty("sensor")
    public SensorDTO getSourceSensor() {
        return sourceSensor;
    }

    @JsonProperty("sensor")
    public void setSourceSensor(SensorDTO sourceSensor) {
        this.sourceSensor = sourceSensor;
    }
}
