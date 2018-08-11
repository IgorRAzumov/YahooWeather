package com.example.developer.yahooweather.di.module;


import com.example.developer.yahooweather.model.api.IApiHelper;
import com.example.developer.yahooweather.model.cache.ICache;
import com.example.developer.yahooweather.model.repo.IRepository;
import com.example.developer.yahooweather.model.repo.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton
@Module(includes = {ApiModule.class, CacheModule.class})
public class RepositoryModule {

    @Singleton
    @Provides
    public IRepository repository(IApiHelper apiHelper, ICache cache) {
        return new Repository(apiHelper, cache);
    }
}
