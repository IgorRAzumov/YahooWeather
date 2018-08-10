package com.example.developer.yahooweather.di;

import com.example.developer.yahooweather.di.module.RepositoryModule;
import com.example.developer.yahooweather.presenter.WeatherForecastPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = RepositoryModule.class)
public interface AppComponent {

    void inject(WeatherForecastPresenter presenter);
}
