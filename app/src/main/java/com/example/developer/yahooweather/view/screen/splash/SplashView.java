package com.example.developer.yahooweather.view.screen.splash;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface SplashView extends MvpView {

    void startLoadingAnim();

    void setLoading(boolean loading);

    void showErrorLoadWeatherMsg();

    void showMainScreen();
}
