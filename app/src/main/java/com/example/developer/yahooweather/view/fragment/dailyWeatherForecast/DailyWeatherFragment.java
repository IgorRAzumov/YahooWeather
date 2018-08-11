package com.example.developer.yahooweather.view.fragment.dailyWeatherForecast;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.developer.yahooweather.App;
import com.example.developer.yahooweather.R;
import com.example.developer.yahooweather.presenter.DailyWeatherPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DailyWeatherFragment extends MvpAppCompatFragment implements DailyWeatherView {
    @BindView(R.id.tv_fr_daily_weather_date)
    TextView dateText;
    @BindView(R.id.tv_fr_daily_weather_temp)
    TextView temperatureText;
    @BindView(R.id.tv_fr_daily_weather_condition)
    TextView conditionText;

    @InjectPresenter
    DailyWeatherPresenter presenter;

    private Unbinder unbinder;

    public DailyWeatherFragment() {
    }

    public static DailyWeatherFragment newInstance() {
        return new DailyWeatherFragment();
    }

    @ProvidePresenter
    DailyWeatherPresenter providePresenter() {
        DailyWeatherPresenter presenter = new DailyWeatherPresenter();
        App.getInstance().getAppComponent().inject(presenter);
        return presenter;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily_weather, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void setDate(String date) {
        dateText.setText(date);
    }

    @Override
    public void setTemperature(String temp) {
        temperatureText.setText(temp);
    }

    @Override
    public void setCondition(String text) {
        conditionText.setText(text);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
