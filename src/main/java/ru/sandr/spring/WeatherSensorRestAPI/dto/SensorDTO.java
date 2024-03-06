package ru.sandr.spring.WeatherSensorRestAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class SensorDTO {

    @NotEmpty
    @Size(min = 3, max = 100, message = "Name of sensor should be between 3 and 100 characters")
    private String sensorName;

    public SensorDTO(String sensorName) {
        this.sensorName = sensorName;
    }

    public SensorDTO() {
    }

    public String getSensorName() {
        return sensorName;
    }

    @JsonProperty("name")
    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }
}
