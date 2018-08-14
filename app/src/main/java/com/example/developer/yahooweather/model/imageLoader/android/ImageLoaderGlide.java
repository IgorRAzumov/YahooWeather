package com.example.developer.yahooweather.model.imageLoader.android;


import android.widget.ImageView;

import com.example.developer.yahooweather.model.imageLoader.IImageLoader;


public class ImageLoaderGlide implements IImageLoader<ImageView> {
    @Override
    public void loadImageToContainer(String url, ImageView container) {
        GlideApp
                .with(container.getContext())
                .load(url)
                .fitCenter()
                .into(container);
    }
}



