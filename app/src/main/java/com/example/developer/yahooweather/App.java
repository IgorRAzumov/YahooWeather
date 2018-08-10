package com.example.developer.yahooweather;

import android.app.Application;

import com.example.developer.yahooweather.di.AppComponent;
import com.example.developer.yahooweather.di.DaggerAppComponent;

import io.realm.Realm;
import timber.log.Timber;

public class App extends Application {

    private static App instance;

    private AppComponent appComponent;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Realm.init(this);
        Timber.plant(new Timber.DebugTree());
        appComponent = DaggerAppComponent.create();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
