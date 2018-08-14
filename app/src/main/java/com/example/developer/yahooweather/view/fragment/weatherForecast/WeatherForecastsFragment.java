package com.example.developer.yahooweather.view.fragment.weatherForecast;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.developer.yahooweather.App;
import com.example.developer.yahooweather.R;
import com.example.developer.yahooweather.model.imageLoader.IImageLoader;
import com.example.developer.yahooweather.presenter.WeatherForecastsPresenter;
import com.example.developer.yahooweather.view.adapter.ForecastsAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class WeatherForecastsFragment extends MvpAppCompatFragment implements WeatherForecastsView {
    @BindView(R.id.rv_fr_weather_forecasts_recycler)
    RecyclerView forecastsRecycler;

    @Inject
    IImageLoader<ImageView> imageLoader;

    @InjectPresenter
    WeatherForecastsPresenter presenter;

    private Unbinder unbinder;

    public WeatherForecastsFragment() {

    }

    public static Fragment newInstance() {
        return new WeatherForecastsFragment();
    }

    @ProvidePresenter
    WeatherForecastsPresenter providePresenter() {
        WeatherForecastsPresenter presenter = new WeatherForecastsPresenter();
        App.getInstance().getAppComponent().inject(presenter);
        return presenter;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_forecasts, container,
                false);
        App.getInstance().getAppComponent().inject(this);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initUi() {
        Context context = getContext();
        if (context != null) {
            forecastsRecycler.setLayoutManager(new LinearLayoutManager(context));
            forecastsRecycler.addItemDecoration(new DividerItemDecoration(context,
                    DividerItemDecoration.VERTICAL));
            forecastsRecycler.setAdapter(new ForecastsAdapter(presenter, imageLoader));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
