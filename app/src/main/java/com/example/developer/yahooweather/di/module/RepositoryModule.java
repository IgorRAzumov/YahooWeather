package com.example.developer.yahooweather.di.module;


import com.example.developer.yahooweather.model.Repository;
import com.example.developer.yahooweather.model.api.ApiService;
import com.example.developer.yahooweather.model.cache.ICache;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton
@Module(includes = {ApiModule.class, CacheModule.class})
public class RepositoryModule {

    @Provides
    public Repository repository(ApiService apiService, ICache cache) {
        return new Repository(apiService, cache);
    }
}
