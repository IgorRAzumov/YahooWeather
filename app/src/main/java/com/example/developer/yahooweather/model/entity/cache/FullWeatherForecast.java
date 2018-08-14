package com.example.developer.yahooweather.model.entity.cache;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FullWeatherForecast extends RealmObject {
    @PrimaryKey
    private String locationId;

    private String pubDate;

    private String description;

    private String sunrise;
    private String sunset;

    private String chill;
    private String direction;
    private String speed;

    private String code;
    private String date;
    private String temp;
    private String text;

    private RealmList<WeatherForecast> forecast = null;

    public String getLocationId() {
        return locationId;
    }

    public FullWeatherForecast setLocationId(String locationId) {
        this.locationId = locationId;
        return this;
    }

    public String getPubDate() {
        return pubDate;
    }

    public FullWeatherForecast setPubDate(String pubDate) {
        this.pubDate = pubDate;
        return this;
    }

    public RealmList<WeatherForecast> getForecast() {
        return forecast;
    }

    public FullWeatherForecast setForecast(RealmList<WeatherForecast> forecast) {
        this.forecast = forecast;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FullWeatherForecast setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getSunrise() {
        return sunrise;
    }

    public FullWeatherForecast setSunrise(String sunrise) {
        this.sunrise = sunrise;
        return this;
    }

    public String getSunset() {
        return sunset;
    }

    public FullWeatherForecast setSunset(String sunset) {
        this.sunset = sunset;
        return this;
    }

    public String getChill() {
        return chill;
    }

    public FullWeatherForecast setChill(String chill) {
        this.chill = chill;
        return this;
    }

    public String getDirection() {
        return direction;
    }

    public FullWeatherForecast setDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public String getSpeed() {
        return speed;
    }

    public FullWeatherForecast setSpeed(String speed) {
        this.speed = speed;
        return this;
    }

    public String getCode() {
        return code;
    }

    public FullWeatherForecast setCode(String code) {
        this.code = code;
        return this;
    }

    public String getDate() {
        return date;
    }

    public FullWeatherForecast setDate(String date) {
        this.date = date;
        return this;
    }

    public String getTemp() {
        return temp;
    }

    public FullWeatherForecast setTemp(String temp) {
        this.temp = temp;
        return this;
    }

    public String getText() {
        return text;
    }

    public FullWeatherForecast setText(String text) {
        this.text = text;
        return this;
    }
}
