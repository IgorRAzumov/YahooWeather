package com.example.developer.yahooweather.presenter;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.developer.yahooweather.model.repo.IRepository;
import com.example.developer.yahooweather.view.screen.splash.SplashView;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@InjectViewState
public class SplashPresenter extends MvpPresenter<SplashView> {
    private final static String NOVOSIBIRSK_LATITUDE = "54.99152";
    private final static String NOVOSIBIRSK_LONGITUDE = "82.957916";
    private final Scheduler scheduler;
    @Inject
    IRepository repository;

    public SplashPresenter(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadWeatherForecast();
        getViewState().setLoading(false);
        getViewState().startLoadingAnim();
    }


    @SuppressLint("CheckResult")
    private void loadWeatherForecast() {
        repository
                .loadWeatherForecast(NOVOSIBIRSK_LATITUDE, NOVOSIBIRSK_LONGITUDE)
                .subscribeOn(Schedulers.io())
                .observeOn(scheduler)
                .subscribe(weatherWithLocation -> {
                    getViewState().setLoading(true);
                }, throwable -> {
                    getViewState().setLoading(true);
                    getViewState().showErrorLoadWeatherMsg();
                    Timber.e(throwable);
                }, () -> {
                    getViewState().setLoading(true);
                    getViewState().showCheckNetworkMessage();
                });
    }
}
