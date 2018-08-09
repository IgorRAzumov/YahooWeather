package com.example.developer.yahooweather.model;

import com.example.developer.yahooweather.model.api.ApiService;
import com.example.developer.yahooweather.model.cache.ICache;

public class Repository {
    private final ApiService weatherApi;
    private final ICache weatherCache;

    public Repository(ApiService weatherApi, ICache weatherCache) {
        this.weatherApi = weatherApi;
        this.weatherCache = weatherCache;
    }
}
