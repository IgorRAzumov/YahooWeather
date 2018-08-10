package com.example.developer.yahooweather.model.cache;

import com.example.developer.yahooweather.model.entity.YahooWeatherResponse;

public interface ICache {
    void save(YahooWeatherResponse weatherResponse);

}
