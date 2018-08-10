package com.example.developer.yahooweather.view.fragment.weatherForecast;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.developer.yahooweather.App;
import com.example.developer.yahooweather.R;
import com.example.developer.yahooweather.presenter.WeatherForecastPresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class WeatherForecastFragment extends MvpAppCompatFragment implements WeatherForecastView {

    @InjectPresenter
    WeatherForecastPresenter presenter;

    private Unbinder unbinder;

    public WeatherForecastFragment() {
    }

    public static WeatherForecastFragment newInstance() {
        return new WeatherForecastFragment();
    }

    @ProvidePresenter
    WeatherForecastPresenter provedePresenter() {
        WeatherForecastPresenter presenter = new WeatherForecastPresenter(
                AndroidSchedulers.mainThread());
        App.getInstance().getAppComponent().inject(presenter);
        return presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
