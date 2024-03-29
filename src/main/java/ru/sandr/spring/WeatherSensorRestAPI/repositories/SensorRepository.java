package ru.sandr.spring.WeatherSensorRestAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sandr.spring.WeatherSensorRestAPI.model.Sensor;

import java.util.Optional;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {

    public Optional<Sensor> findByName(String sensorName);
}
