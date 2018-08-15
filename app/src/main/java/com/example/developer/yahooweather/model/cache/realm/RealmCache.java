package com.example.developer.yahooweather.model.cache.realm;

import com.example.developer.yahooweather.model.cache.ICache;
import com.example.developer.yahooweather.model.entity.cache.ForecastsWithLocation;

import io.reactivex.Maybe;
import io.realm.Realm;

public class RealmCache implements ICache {
    private static final String ID = "id";

    @Override
    public Maybe<ForecastsWithLocation> getForecastWithLocation(String latitude, String longitude) {
        return Maybe.create(emitter -> {
            try (Realm realm = Realm.getDefaultInstance()) {
                ForecastsWithLocation forecastsWithLocation = getForecastWithLocation(latitude,
                        longitude, realm);
                if (forecastsWithLocation == null) {
                    emitter.onComplete();
                } else {
                    emitter.onSuccess(realm.copyFromRealm(forecastsWithLocation));
                }
            }
        });
    }

    @Override
    public void saveForecastWithLocation(ForecastsWithLocation weather) {
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(innerRealm -> {
                String weatherLocationId = ForecastsWithLocation.createId(weather.getLatitude(),
                        weather.getLongitude());

                weather.setId(weatherLocationId);
                weather.setFullWeatherForecastId(weatherLocationId);

                realm.insertOrUpdate(weather);
            });
        }
    }

    private ForecastsWithLocation getForecastWithLocation(String latitude, String longitude,
                                                          Realm realm) {
        return realm
                .where(ForecastsWithLocation.class)
                .equalTo(ID, ForecastsWithLocation.createId(latitude, longitude))
                .findFirst();
    }
}
