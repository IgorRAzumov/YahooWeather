package com.example.developer.yahooweather.model;

import com.example.developer.yahooweather.model.api.IApiHelper;
import com.example.developer.yahooweather.model.cache.ICache;
import com.example.developer.yahooweather.model.entity.YahooWeatherResponse;

import io.reactivex.Single;

public class Repository {
    private final IApiHelper weatherApi;
    private final ICache weatherCache;

    public Repository(IApiHelper weatherApi, ICache weatherCache) {
        this.weatherApi = weatherApi;
        this.weatherCache = weatherCache;
    }

    public Single<YahooWeatherResponse> loadWeatherForecast(String cityName) {
        return weatherApi
                .getWeatherForecast(cityName)
                .doOnSuccess(weatherCache::save);
    }
}
