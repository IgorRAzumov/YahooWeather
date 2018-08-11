package com.example.developer.yahooweather.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.developer.yahooweather.model.entity.Item;
import com.example.developer.yahooweather.model.repo.IRepository;
import com.example.developer.yahooweather.view.fragment.dailyWeatherForecast.DailyWeatherView;

import javax.inject.Inject;

@InjectViewState
public class DailyWeatherPresenter extends MvpPresenter<DailyWeatherView> {
    @Inject
    IRepository repository;

    private Item item;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        item = repository.getCurrentWeatherItem();
        getViewState().setDate(item.getCondition().getDate());
        getViewState().setTemperature(item.getCondition().getTemp());
        getViewState().setCondition(item.getCondition().getText());
    }
}
