package com.example.developer.yahooweather.di.module;


import com.example.developer.yahooweather.model.Repository;
import com.example.developer.yahooweather.model.api.IApiHelper;
import com.example.developer.yahooweather.model.cache.ICache;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton
@Module(includes = {ApiModule.class, CacheModule.class})
public class RepositoryModule {

    @Provides
    public Repository repository(IApiHelper apiHelper, ICache cache) {
        return new Repository(apiHelper, cache);
    }
}
