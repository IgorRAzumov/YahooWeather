package com.example.developer.yahooweather.view.fragment.dailyWeatherForecast;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface DailyWeatherView extends MvpView {
    void setTemperature(String temp);

    void setCondition(String text);

    void setSunset(String sunset);

    void setSunshine(String sunshine);

    void showConditionImage(String url);
}
