package com.example.developer.yahooweather.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.developer.yahooweather.R;
import com.example.developer.yahooweather.model.imageLoader.IImageLoader;
import com.example.developer.yahooweather.presenter.IForecastsPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForecastsAdapter extends RecyclerView.Adapter<ForecastsAdapter.ViewHolder> {
    private final IForecastsPresenter presenter;

    private final IImageLoader<ImageView> imageLoader;

    public ForecastsAdapter(IForecastsPresenter presenter, IImageLoader<ImageView> imageLoader) {
        this.presenter = presenter;
        this.imageLoader = imageLoader;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.forecasts_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setTag(position);
        presenter.bindWeather(position, holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getForecastsCount();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements IForecastRow {
        @BindView(R.id.tv_forecast_item_temp_max)
        TextView maxTemperatureText;
        @BindView(R.id.tv_forecast_item_temp_min)
        TextView minTemperatureText;
        @BindView(R.id.tv_forecast_item_condition)
        TextView conditionText;
        @BindView(R.id.tv_forecast_item_date)
        TextView dateText;
        @BindView(R.id.tv_forecast_item_day)
        TextView dayText;
        @BindView(R.id.iv_forecast_item_condition)
        ImageView forecastConditionImage;


        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setDate(String date) {
            dateText.setText(date);
        }

        @Override
        public void setMinTemperature(String temperature) {
            minTemperatureText.setText(temperature);
        }

        @Override
        public void setMaxTemperature(String temperature) {
            maxTemperatureText.setText(temperature);
        }

        @Override
        public void setDay(String day) {
            dayText.setText(day);
        }

        @Override
        public void setCondition(String condition) {
            conditionText.setText(condition);
        }

        @Override
        public void setConditionImage(String url) {
            imageLoader.loadImageToContainer(url, forecastConditionImage);
        }
    }
}
