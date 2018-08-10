package com.example.developer.yahooweather.model.api;

import com.example.developer.yahooweather.model.entity.YahooWeatherResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    String RESPONSE_FORMAT = "json";
    String ENVIRONMENT = "json";

    @GET("yql")
    Single<YahooWeatherResponse> getWeatherForecast(@Query(value = "q") String query,
                                                    @Query("format") String format,
                                                    @Query("env") String env);
}
