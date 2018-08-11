package com.example.developer.yahooweather.model.repo;

import com.example.developer.yahooweather.model.api.IApiHelper;
import com.example.developer.yahooweather.model.cache.ICache;
import com.example.developer.yahooweather.model.entity.Forecast;
import com.example.developer.yahooweather.model.entity.Item;
import com.example.developer.yahooweather.model.entity.YahooWeatherResponse;

import java.util.List;

import io.reactivex.Single;

public class Repository implements IRepository {
    private final IApiHelper weatherApi;
    private final ICache weatherCache;
    private YahooWeatherResponse currentWeatherForecast;

    public Repository(IApiHelper weatherApi, ICache weatherCache) {
        this.weatherApi = weatherApi;
        this.weatherCache = weatherCache;
    }

    @Override
    public Single<YahooWeatherResponse> loadWeatherForecast(String cityName) {
        return weatherApi
                .getWeatherForecast(cityName)
                .doOnSuccess(response -> {
                    weatherCache.save(response);
                    currentWeatherForecast = response;
                });
    }

    @Override
    public List<Forecast> getCurrentWeatherForecast() {
        return currentWeatherForecast.getQuery().getResults().getChannel().getItem().getForecast();
    }

    @Override
    public Item getCurrentWeatherItem() {
        return currentWeatherForecast.getQuery().getResults().getChannel().getItem();
    }
}
