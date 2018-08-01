package com.example.mg.zomato.app.DI.modules;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.mg.zomato.app.CoreApplication;
import com.example.mg.zomato.app.DI.IApplicationContext;
import com.example.mg.zomato.app.DI.IApplicationScope;
import com.example.mg.zomato.data.AppPreferencesHelper;
import com.example.mg.zomato.data.PreferencesHelper;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private CoreApplication applicationContext;

    public AppModule(CoreApplication application) {
        applicationContext = application;
    }

    @Provides
    @IApplicationContext
    @IApplicationScope
    public Context provideAppContext() {
        return applicationContext;
    }


    @Provides
    @IApplicationScope
    public PreferencesHelper providePreferencesHelper(AppPreferencesHelper helper) {
        return helper;
    }

    @Provides
    @IApplicationScope
    RequestManager glide() {
        return Glide.with(applicationContext);
    }
}
