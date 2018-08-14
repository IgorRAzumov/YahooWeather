package com.example.developer.yahooweather.model.api;

import com.example.developer.yahooweather.model.entity.api.YahooWeatherResponse;

import io.reactivex.Single;

public interface IApiHelper {

    Single<YahooWeatherResponse> getWeatherForecast(String latitude, String longitude);
}
