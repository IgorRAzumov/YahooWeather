package com.example.developer.yahooweather.view.fragment.dailyWeatherForecast;

import com.arellomobile.mvp.MvpView;

public interface DailyWeatherView extends MvpView {
    void setDate(String date);

    void setTemperature(String temp);

    void setCondition(String text);
}
