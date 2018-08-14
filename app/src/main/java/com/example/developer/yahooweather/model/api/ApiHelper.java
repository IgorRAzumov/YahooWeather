package com.example.developer.yahooweather.model.api;

import com.example.developer.yahooweather.model.entity.api.YahooWeatherResponse;

import io.reactivex.Single;


public class ApiHelper implements IApiHelper {
    private static final String UNITS_CELSIUS = "c";
    private static final String RESPONSE_FORMAT = "json";
    private static final String ENVIRONMENT = "store://datatables.org/alltableswithkeys";

    private final ApiService apiService;

    public ApiHelper(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Single<YahooWeatherResponse> getWeatherForecast(String latitude, String longitude) {
        return apiService.getWeatherForecast(createQuery(latitude, longitude, UNITS_CELSIUS),
                RESPONSE_FORMAT, ENVIRONMENT);
    }

    @Override
    public String createForecastImageUrl(String code) {
        return String.format("http://l.yimg.com/a/i/us/we/52/%s.gif", code);
    }

    private String createQuery(String latitude, String longitude, String units) {
        return String.format(
                "select * from weather.forecast " +
                        "where woeid in (SELECT woeid FROM geo.places(1) WHERE text=\"(%s,%s)\") " +
                        "and u ='%s'",
                latitude, longitude, units);
    }
}
