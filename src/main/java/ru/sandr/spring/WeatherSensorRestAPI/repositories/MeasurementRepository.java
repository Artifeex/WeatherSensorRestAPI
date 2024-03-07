package ru.sandr.spring.WeatherSensorRestAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sandr.spring.WeatherSensorRestAPI.model.Measurement;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {

    int countMeasurementByIsRaining(boolean isRaining);
}
