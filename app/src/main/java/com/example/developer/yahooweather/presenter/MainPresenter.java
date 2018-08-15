package com.example.developer.yahooweather.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.developer.yahooweather.model.repo.IRepository;
import com.example.developer.yahooweather.view.screen.main.MainView;

import javax.inject.Inject;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    @Inject
    IRepository repository;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().initUi();
        getViewState().showDailyWeatherFragment();
        getViewState().showWeatherForecastsFragment();
        getViewState().showCityName(repository.getCurrentWeatherLocation());
    }
}
