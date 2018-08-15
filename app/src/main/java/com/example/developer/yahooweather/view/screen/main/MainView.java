package com.example.developer.yahooweather.view.screen.main;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface MainView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void initUi();

    void showDailyWeatherFragment();

    void showWeatherForecastsFragment();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showCityName(String cityName);
}
