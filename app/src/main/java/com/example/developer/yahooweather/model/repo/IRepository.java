package com.example.developer.yahooweather.model.repo;

import com.example.developer.yahooweather.model.entity.Forecast;
import com.example.developer.yahooweather.model.entity.Item;
import com.example.developer.yahooweather.model.entity.YahooWeatherResponse;

import java.util.List;

import io.reactivex.Single;

public interface IRepository {
    Single<YahooWeatherResponse> loadWeatherForecast(String cityName);

    List<Forecast> getCurrentWeatherForecast();

    Item getCurrentWeatherItem();
}
