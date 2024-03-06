package ru.sandr.spring.WeatherSensorRestAPI.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "measurement")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "temperature")
    private int temperature;

    @Column(name = "is_raining")
    private boolean isRaining;

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    private Sensor sourceSensor;


    private Timestamp createdTime;

    public Measurement() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public boolean isRaining() {
        return isRaining;
    }

    public void setRaining(boolean raining) {
        isRaining = raining;
    }

    public Sensor getSourceSensor() {
        return sourceSensor;
    }

    public void setSourceSensor(Sensor sourceSensor) {
        this.sourceSensor = sourceSensor;
    }
}
