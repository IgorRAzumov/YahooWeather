package com.example.developer.yahooweather.di.module;


import com.example.developer.yahooweather.model.api.IApiHelper;
import com.example.developer.yahooweather.model.cache.ICache;
import com.example.developer.yahooweather.model.networkStatus.INetworkStatus;
import com.example.developer.yahooweather.model.networkStatus.android.NetworkStatus;
import com.example.developer.yahooweather.model.repo.IRepository;
import com.example.developer.yahooweather.model.repo.Repository;
import com.example.developer.yahooweather.model.utils.MapHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton
@Module(includes = {ApiModule.class, CacheModule.class})
public class RepositoryModule {

    @Singleton
    @Provides
    public IRepository repository(IApiHelper apiHelper, ICache cache, MapHelper mapHelper,
                                  INetworkStatus networkStatus) {
        return new Repository(apiHelper, cache, mapHelper, networkStatus);
    }

    @Provides
    public MapHelper mapHelper() {
        return new MapHelper();
    }

    @Provides
    public INetworkStatus networkStatus() {
        return new NetworkStatus();
    }

}
