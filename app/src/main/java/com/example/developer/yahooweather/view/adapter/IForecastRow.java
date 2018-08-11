package com.example.developer.yahooweather.view.adapter;

public interface IForecastRow {
    void setDate(String date);

    void setMinTemperature(String temperature);

    void setMaxTemperature(String temperature);

    void setDay(String day);

    void setCondition(String condition);
}
