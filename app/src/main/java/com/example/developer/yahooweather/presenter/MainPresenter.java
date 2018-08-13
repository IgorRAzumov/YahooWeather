package com.example.developer.yahooweather.presenter;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.developer.yahooweather.model.repo.IRepository;
import com.example.developer.yahooweather.view.screen.main.MainView;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    private final static String NOVOSIBIRSK_LATITUDE = "54.99152";
    private final static String NOVOSIBIRSK_LONGITUDE = "82.957916";

    @Inject
    IRepository repository;

    private final Scheduler scheduler;

    public MainPresenter(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().initUi();
        getViewState().showLoading();
        loadWeatherForecast();
    }


    @SuppressLint("CheckResult")
    private void loadWeatherForecast() {
        repository
                .loadWeatherForecast(NOVOSIBIRSK_LATITUDE, NOVOSIBIRSK_LONGITUDE)
                .subscribeOn(Schedulers.io())
                .observeOn(scheduler)
                .subscribe(weatherWithLocation -> {
                    getViewState().hideLoading();
                    getViewState().showCityName(weatherWithLocation.getCity());
                    getViewState().showDailyWeatherFragment();
                    getViewState().showWeatherForecastsFragment();
                }, throwable -> {
                    getViewState().hideLoading();
                    getViewState().showErrorLoadWeatherMsg();
                    Timber.e(throwable);
                });
    }
}
