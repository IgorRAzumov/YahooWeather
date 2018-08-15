package com.example.developer.yahooweather.model.utils;

import com.example.developer.yahooweather.model.entity.api.Astronomy;
import com.example.developer.yahooweather.model.entity.api.Channel;
import com.example.developer.yahooweather.model.entity.api.Condition;
import com.example.developer.yahooweather.model.entity.api.Forecast;
import com.example.developer.yahooweather.model.entity.api.Item;
import com.example.developer.yahooweather.model.entity.api.Location;
import com.example.developer.yahooweather.model.entity.api.Wind;
import com.example.developer.yahooweather.model.entity.api.YahooWeatherResponse;
import com.example.developer.yahooweather.model.entity.cache.ForecastsWithLocation;
import com.example.developer.yahooweather.model.entity.cache.FullWeatherForecast;
import com.example.developer.yahooweather.model.entity.cache.WeatherForecast;

import java.util.List;

import io.realm.RealmList;

public class MapHelper {

    public ForecastsWithLocation mapApiResponse(YahooWeatherResponse response) {
        Channel channel = response.getQuery().getResults().getChannel();
        Astronomy astronomy = channel.getAstronomy();
        Location location = channel.getLocation();
        Wind wind = channel.getWind();
        Item item = channel.getItem();
        Condition condition = item.getCondition();

        String locationId = ForecastsWithLocation.createId(item.getLat(), item.getLong());

        List<WeatherForecast> forecastList = getForecastList(item, locationId);
        FullWeatherForecast fullWeatherForecast = getFullWeatherForecast(item, wind, condition,
                astronomy, locationId);
        return getForecastWithLocation(location, item,
                fullWeatherForecast, forecastList, locationId);
    }

    private ForecastsWithLocation getForecastWithLocation(Location location, Item item,
                                                          FullWeatherForecast fullWeatherForecasts,
                                                          List<WeatherForecast> forecasts,
                                                          String locationId) {
        return new ForecastsWithLocation()
                .setId(locationId)
                .setCity(location.getCity())
                .setCountry(location.getCountry())
                .setRegion(location.getRegion())
                .setLatitude(item.getLat())
                .setLongitude(item.getLong())
                .setFullWeatherForecast(fullWeatherForecasts)
                .setForecasts((RealmList<WeatherForecast>) forecasts);

    }

    private List<WeatherForecast> getForecastList(Item item, String locationId) {
        List<WeatherForecast> weatherForecasts = new RealmList<>();
        for (Forecast forecast : item.getForecast()) {
            weatherForecasts.add(new WeatherForecast()
                    .setText(forecast.getText())
                    .setCode(forecast.getCode())
                    .setDate(forecast.getDate())
                    .setDay(forecast.getDay())
                    .setHigh(forecast.getHigh())
                    .setLow(forecast.getLow()));
        }
        return weatherForecasts;
    }

    private FullWeatherForecast getFullWeatherForecast(Item item, Wind wind, Condition condition,
                                                       Astronomy astronomy, String locationId) {
        return new FullWeatherForecast()
                .setLocationId(locationId)
                .setPubDate(item.getPubDate())
                .setDescription(item.getDescription())
                .setSunrise(astronomy.getSunrise())
                .setSunset(astronomy.getSunset())
                .setChill(wind.getChill())
                .setDirection(wind.getDirection())
                .setSpeed(wind.getSpeed())
                .setCode(condition.getCode())
                .setDate(condition.getDate())
                .setTemp(condition.getTemp())
                .setText(condition.getText());
    }
}
