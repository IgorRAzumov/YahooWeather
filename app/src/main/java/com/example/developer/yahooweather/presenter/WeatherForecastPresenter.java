package com.example.developer.yahooweather.presenter;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.developer.yahooweather.model.Repository;
import com.example.developer.yahooweather.view.fragment.weatherForecast.WeatherForecastView;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@InjectViewState
public class WeatherForecastPresenter extends MvpPresenter<WeatherForecastView> {
    private final static String NOVOSIBIRSK_CITY_NAME = "novosibirsk";

    @Inject
    Repository repository;

    private Scheduler scheduler;

    public WeatherForecastPresenter(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadWeatherForecast();
    }

    @SuppressLint("CheckResult")
    private void loadWeatherForecast() {
        repository
                .loadWeatherForecast(NOVOSIBIRSK_CITY_NAME)
                .subscribeOn(Schedulers.io())
                .observeOn(scheduler)
                .subscribe(weatherResponse -> {
                            Timber.d(weatherResponse.toString());
                        },
                        Timber::e);
    }
}
