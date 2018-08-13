package com.example.developer.yahooweather.model.api;

import com.example.developer.yahooweather.model.entity.api.YahooWeatherResponse;

import io.reactivex.Single;


public class ApiHelper implements IApiHelper {
    private static final String RESPONSE_FORMAT = "json";
    private static final String ENVIRONMENT = "json";

    private final ApiService apiService;

    public ApiHelper(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Single<YahooWeatherResponse> getWeatherForecast(String latitude, String longitude) {
        return apiService.getWeatherForecast(createQuery(latitude, longitude), RESPONSE_FORMAT,
                ENVIRONMENT);
    }

    private String createQuery(String cityName) {
        return String.format(
                "select * from weather.forecast " +
                        "where woeid in (select woeid from geo.places(1) where text=\"%s\")",
                cityName);
    }

    private String createQuery(String latitude, String longitude) {
        return String.format(
                "select * from weather.forecast " +
                        "where woeid in (SELECT woeid FROM geo.places(1) WHERE text=\"(%s,$s)\")",
                latitude, longitude);
    }
}
