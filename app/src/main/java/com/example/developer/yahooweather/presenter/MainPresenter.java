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
    private final static String NOVOSIBIRSK_CITY_NAME = "novosibirsk";
    private final Scheduler scheduler;
    @Inject
    IRepository repository;

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
                .loadWeatherForecast(NOVOSIBIRSK_CITY_NAME)
                .subscribeOn(Schedulers.io())
                .observeOn(scheduler)
                .subscribe(weatherResponse -> {
                    getViewState().hideLoading();
                    getViewState().showCityName(weatherResponse.getQuery().getResults().getChannel()
                            .getLocation().getCity());
                    getViewState().showDailyWeatherFragment();
                    getViewState().showWeatherForecastsFragment();
                }, throwable -> {
                    getViewState().hideLoading();
                    getViewState().showErrorLoadWeatherMsg();
                    Timber.e(throwable);
                });
    }
}
