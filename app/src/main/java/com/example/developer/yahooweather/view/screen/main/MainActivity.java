package com.example.developer.yahooweather.view.screen.main;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.developer.yahooweather.R;
import com.example.developer.yahooweather.presenter.MainPresenter;
import com.example.developer.yahooweather.view.fragment.weatherForecast.WeatherForecastFragment;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showMainFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_activity_main_frame, WeatherForecastFragment.newInstance())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}
