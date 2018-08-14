package com.example.developer.yahooweather.view.screen.main;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.developer.yahooweather.App;
import com.example.developer.yahooweather.R;
import com.example.developer.yahooweather.presenter.MainPresenter;
import com.example.developer.yahooweather.view.fragment.dailyWeatherForecast.DailyWeatherFragment;
import com.example.developer.yahooweather.view.fragment.weatherForecast.WeatherForecastsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    @BindView(R.id.tb_act_main_toolbar)
    Toolbar toolbar;
    @BindView(R.id.pb_act_main_loading)
    ProgressBar progressBar;

    @InjectPresenter
    MainPresenter presenter;

    @ProvidePresenter
    MainPresenter providePresenter() {
        MainPresenter presenter = new MainPresenter(
                AndroidSchedulers.mainThread());
        App.getInstance().getAppComponent().inject(presenter);
        return presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void initUi() {
        setSupportActionBar(toolbar);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showDailyWeatherFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_act_main_daily_frame, DailyWeatherFragment.newInstance())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }


    @Override
    public void showWeatherForecastsFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_act_main_forecast_frame, WeatherForecastsFragment.newInstance())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @Override
    public void showErrorLoadWeatherMsg() {
        Timber.d("ERROR_LOADING_AHTUNG");
    }

    @Override
    public void showCityName(String cityName) {
        toolbar.setTitle(cityName);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showCheckNetworkMessage() {
        Timber.d("error load weather check network");
    }
}
