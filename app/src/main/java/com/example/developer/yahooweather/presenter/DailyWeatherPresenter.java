package com.example.developer.yahooweather.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.developer.yahooweather.model.entity.cache.FullWeatherForecast;
import com.example.developer.yahooweather.model.repo.IRepository;
import com.example.developer.yahooweather.view.fragment.dailyWeatherForecast.DailyWeatherView;

import javax.inject.Inject;

@InjectViewState
public class DailyWeatherPresenter extends MvpPresenter<DailyWeatherView> {
    @Inject
    IRepository repository;

    private FullWeatherForecast dailyWeatherForecast;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        dailyWeatherForecast = repository.getFullWeatherForecast();
        getViewState().setDate(dailyWeatherForecast.getDate());
        getViewState().setTemperature(dailyWeatherForecast.getTemp());
        getViewState().setCondition(dailyWeatherForecast.getText());
    }
}
