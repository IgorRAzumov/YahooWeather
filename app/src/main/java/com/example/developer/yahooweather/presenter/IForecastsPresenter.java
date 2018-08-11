package com.example.developer.yahooweather.presenter;

import com.example.developer.yahooweather.view.adapter.IForecastRow;

public interface IForecastsPresenter {
    void bindWeather(int pos, IForecastRow rowView);

    int getForecastsCount();

    void onForecastClick(int position);
}
