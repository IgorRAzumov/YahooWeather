package com.example.developer.yahooweather.view.fragment.weatherForecast;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface WeatherForecastsView extends MvpView {

    void initUi();
}
