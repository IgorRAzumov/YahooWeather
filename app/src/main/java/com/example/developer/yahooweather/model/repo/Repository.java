package com.example.developer.yahooweather.model.repo;

import android.annotation.SuppressLint;

import com.example.developer.yahooweather.model.api.IApiHelper;
import com.example.developer.yahooweather.model.cache.ICache;
import com.example.developer.yahooweather.model.entity.cache.ForecastsWithLocation;
import com.example.developer.yahooweather.model.entity.cache.FullWeatherForecast;
import com.example.developer.yahooweather.model.entity.cache.WeatherForecast;
import com.example.developer.yahooweather.model.networkStatus.INetworkStatus;
import com.example.developer.yahooweather.model.utils.MapHelper;

import java.util.List;

import io.reactivex.Maybe;

public class Repository implements IRepository {
    private final IApiHelper weatherApi;
    private final ICache weatherCache;
    private final MapHelper mapHelper;
    private final INetworkStatus networkStatus;

    private ForecastsWithLocation currentWeatherForecast;

    public Repository(IApiHelper weatherApi, ICache weatherCache, MapHelper mapHelper,
                      INetworkStatus networkStatus) {
        this.weatherApi = weatherApi;
        this.weatherCache = weatherCache;
        this.mapHelper = mapHelper;
        this.networkStatus = networkStatus;
    }

    @SuppressLint("CheckResult")
    @Override
    public Maybe<ForecastsWithLocation> loadWeatherForecast(String latitude, String longitude) {
        if (networkStatus.isOnline()) {
            return weatherApi
                    .getWeatherForecast(latitude, longitude)
                    .map(mapHelper::mapApiResponse)
                    .doOnSuccess(weather -> {
                        currentWeatherForecast = weather;
                        weatherCache.saveForecastWithLocation(weather);
                    })
                    .toMaybe();
        }

        return weatherCache
                .getForecastWithLocation(latitude, longitude)
                .doOnSuccess(weather -> currentWeatherForecast = weather);
    }

    @Override
    public List<WeatherForecast> getCurrentWeatherForecast() {
        return currentWeatherForecast.getForecasts();
    }

    @Override
    public FullWeatherForecast getFullWeatherForecast() {
        return currentWeatherForecast.getFullWeatherForecast();
    }

    @Override
    public String createForecastImageUrl(String code) {
        return weatherApi.createForecastImageUrl(code);
    }
}
