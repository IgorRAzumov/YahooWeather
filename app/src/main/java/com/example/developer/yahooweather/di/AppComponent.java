package com.example.developer.yahooweather.di;

import com.example.developer.yahooweather.di.module.RepositoryModule;
import com.example.developer.yahooweather.presenter.DailyWeatherPresenter;
import com.example.developer.yahooweather.presenter.MainPresenter;
import com.example.developer.yahooweather.presenter.WeatherForecastsPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = RepositoryModule.class)
public interface AppComponent {

    void inject(DailyWeatherPresenter presenter);

    void inject(MainPresenter presenter);

    void inject(WeatherForecastsPresenter presenter);
}
