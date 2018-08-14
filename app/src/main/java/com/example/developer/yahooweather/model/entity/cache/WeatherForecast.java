package com.example.developer.yahooweather.model.entity.cache;

import io.realm.RealmObject;

public class WeatherForecast extends RealmObject {
    /*@Required
    @PrimaryKey
    private String location_id;
*/
    private String code;
    private String text;

    private String date;
    private String day;

    private String high;
    private String low;

    public String getCode() {
        return code;
    }

    public WeatherForecast setCode(String code) {
        this.code = code;
        return this;
    }

    public String getDate() {
        return date;
    }

    public WeatherForecast setDate(String date) {
        this.date = date;
        return this;
    }

    public String getDay() {
        return day;
    }

    public WeatherForecast setDay(String day) {
        this.day = day;
        return this;
    }

    public String getHigh() {
        return high;
    }

    public WeatherForecast setHigh(String high) {
        this.high = high;
        return this;
    }

    public String getLow() {
        return low;
    }

    public WeatherForecast setLow(String low) {
        this.low = low;
        return this;
    }

    public String getText() {
        return text;
    }

    public WeatherForecast setText(String text) {
        this.text = text;
        return this;
    }
/*
    public String getLocationId() {
        return location_id;

    }

    public WeatherForecast setLocationId(String locationId) {
        this.location_id = locationId;
        return this;
    }*/
}
