package com.example.developer.yahooweather.model.api;

import com.example.developer.yahooweather.model.entity.YahooWeatherResponse;

import io.reactivex.Single;

public interface IApiHelper {

    Single<YahooWeatherResponse> getWeatherForecast(String cityName);
}
