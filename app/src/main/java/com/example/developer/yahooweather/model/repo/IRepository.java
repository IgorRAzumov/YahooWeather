package com.example.developer.yahooweather.model.repo;

import com.example.developer.yahooweather.model.entity.cache.ForecastsWithLocation;
import com.example.developer.yahooweather.model.entity.cache.FullWeatherForecast;
import com.example.developer.yahooweather.model.entity.cache.WeatherForecast;

import java.util.List;

import io.reactivex.Single;

public interface IRepository {
    Single<ForecastsWithLocation> loadWeatherForecast(String latitude, String longitude);

    List<WeatherForecast> getCurrentWeatherForecast();

    FullWeatherForecast getFullWeatherForecast();
}
