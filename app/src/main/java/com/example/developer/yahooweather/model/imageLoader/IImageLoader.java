package com.example.developer.yahooweather.model.imageLoader;

public interface IImageLoader<C> {

    void loadImageToContainer(String url, C container);
}
