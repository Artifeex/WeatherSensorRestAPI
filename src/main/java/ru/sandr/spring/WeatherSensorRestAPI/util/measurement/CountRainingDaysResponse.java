package ru.sandr.spring.WeatherSensorRestAPI.util.measurement;

public class CountRainingDaysResponse {

    int countRainingDays;

    public CountRainingDaysResponse(int countRainingDays) {
        this.countRainingDays = countRainingDays;
    }

    public int getCountRainingDays() {
        return countRainingDays;
    }

    public void setCountRainingDays(int countRainingDays) {
        this.countRainingDays = countRainingDays;
    }
}
