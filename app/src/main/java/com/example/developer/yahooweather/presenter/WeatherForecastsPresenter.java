package com.example.developer.yahooweather.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.developer.yahooweather.model.entity.cache.WeatherForecast;
import com.example.developer.yahooweather.model.repo.IRepository;
import com.example.developer.yahooweather.view.adapter.IForecastRow;
import com.example.developer.yahooweather.view.fragment.weatherForecast.WeatherForecastsView;

import java.util.List;

import javax.inject.Inject;

@InjectViewState
public class WeatherForecastsPresenter extends MvpPresenter<WeatherForecastsView>
        implements IForecastsPresenter {
    @Inject
    IRepository repository;

    private List<WeatherForecast> forecastsList;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        forecastsList = repository.getCurrentWeatherForecast();
        getViewState().initUi();
    }

    @Override
    public void bindWeather(int position, IForecastRow rowView) {
        WeatherForecast forecast = forecastsList.get(position);
        rowView.setMinTemperature(forecast.getLow());
        rowView.setMaxTemperature(forecast.getHigh());
        rowView.setDate(forecast.getDate());
        rowView.setDay(forecast.getDay());
        rowView.setCondition(forecast.getText());
        rowView.setConditionImage(repository.createForecastImageUrl(forecast.getCode()));
    }

    @Override
    public int getForecastsCount() {
        return forecastsList == null ? 0 : forecastsList.size();
    }

    @Override
    public void onForecastClick(int position) {

    }
}
