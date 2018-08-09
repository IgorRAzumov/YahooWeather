package com.example.developer.yahooweather.di.module;

import com.example.developer.yahooweather.model.cache.ICache;
import com.example.developer.yahooweather.model.cache.realm.RealmCache;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton
@Module
public class CacheModule {

    @Provides
    public ICache realmCache() {
        return new RealmCache();
    }
}
