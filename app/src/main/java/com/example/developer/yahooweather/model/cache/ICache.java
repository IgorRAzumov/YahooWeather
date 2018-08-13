package com.example.developer.yahooweather.model.cache;

import com.example.developer.yahooweather.model.entity.cache.ForecastsWithLocation;

import io.reactivex.Maybe;

public interface ICache {

    Maybe<ForecastsWithLocation> getForecastWithLocation(String latitude, String longitude);

    void saveForecastWithLocation(ForecastsWithLocation weather);
}
