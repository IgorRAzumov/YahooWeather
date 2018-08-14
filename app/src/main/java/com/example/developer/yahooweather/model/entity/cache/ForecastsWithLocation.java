package com.example.developer.yahooweather.model.entity.cache;


import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ForecastsWithLocation extends RealmObject {
    FullWeatherForecast fullWeatherForecast;
    RealmList<WeatherForecast> forecasts;
    @PrimaryKey
    private String id;
    private String city;
    private String country;
    private String region;
    private String latitude;
    private String longitude;

    public static String createId(String latitude, String longitude) {
        return latitude + longitude;
    }

    public String getCity() {
        return city;
    }

    public ForecastsWithLocation setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public ForecastsWithLocation setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public ForecastsWithLocation setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getLattitude() {
        return latitude;
    }

    public ForecastsWithLocation setLattitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }

    public ForecastsWithLocation setLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getId() {
        return id;
    }

    public ForecastsWithLocation setId(String id) {
        this.id = id;
        return this;
    }

    public String getLatitude() {
        return latitude;
    }

    public ForecastsWithLocation setLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public RealmList<WeatherForecast> getForecasts() {
        return forecasts;
    }

    public ForecastsWithLocation setForecasts(RealmList<WeatherForecast> forecasts) {
        this.forecasts = forecasts;
        return this;
    }

    public FullWeatherForecast getFullWeatherForecast() {
        return fullWeatherForecast;
    }

    public ForecastsWithLocation setFullWeatherForecast(FullWeatherForecast fullWeatherForecast) {
        this.fullWeatherForecast = fullWeatherForecast;
        return this;
    }

    public void setFullWeatherForecastId(String weatherLocationId) {
        if (fullWeatherForecast != null) {
            fullWeatherForecast.setLocationId(weatherLocationId);
        }
    }

    public void setForecastsId(String weatherLocationId) {
        if (forecasts == null || forecasts.size() == 0) {
            return;
        }
        for (WeatherForecast forecast : forecasts) {
            // forecast.setLocationId(weatherLocationId);
        }
    }
}

