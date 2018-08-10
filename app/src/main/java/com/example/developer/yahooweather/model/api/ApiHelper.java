package com.example.developer.yahooweather.model.api;

import com.example.developer.yahooweather.model.entity.YahooWeatherResponse;

import io.reactivex.Single;


public class ApiHelper implements IApiHelper {
    private static final String RESPONSE_FORMAT = "json";
    private static final String ENVIRONMENT = "json";

    private final ApiService apiService;

    public ApiHelper(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Single<YahooWeatherResponse> getWeatherForecast(String cityName) {
        return apiService.getWeatherForecast(createQuery(cityName), RESPONSE_FORMAT, ENVIRONMENT);
    }

    private String createQuery(String cityName) {
        return String.format(
                "select * from weather.forecast " +
                        "where woeid in (select woeid from geo.places(1) where text=\"%s\")",
                cityName);
    }
}
