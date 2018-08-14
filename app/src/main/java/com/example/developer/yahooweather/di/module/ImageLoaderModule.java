package com.example.developer.yahooweather.di.module;

import android.widget.ImageView;

import com.example.developer.yahooweather.model.imageLoader.IImageLoader;
import com.example.developer.yahooweather.model.imageLoader.android.ImageLoaderGlide;

import dagger.Module;
import dagger.Provides;

@Module
public class ImageLoaderModule {

    @Provides
    IImageLoader<ImageView> imageLoader() {
        return new ImageLoaderGlide();
    }
}
