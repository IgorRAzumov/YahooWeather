package com.example.developer.yahooweather.view.screen.main;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface MainView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void initUi();

    void showLoading();

    void showDailyWeatherFragment();

    void showWeatherForecastsFragment();

    void showErrorLoadWeatherMsg();

    void showCityName(String cityName);

    void hideLoading();

    void showCheckNetworkMessage();
}
