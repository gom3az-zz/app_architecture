package com.example.mg.zomato.app;

import android.app.Activity;
import android.app.Application;

import com.example.mg.zomato.app.DI.AppComponent;
import com.example.mg.zomato.app.DI.DaggerAppComponent;
import com.example.mg.zomato.app.DI.modules.AppModule;
import com.example.mg.zomato.app.DI.modules.NetworkModule;


public class CoreApplication extends Application {
    private AppComponent mComponent;

    public static CoreApplication get(Activity activity) {
        return (CoreApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    public AppComponent getAppComponent() {
        return mComponent;
    }


    private void initDagger() {
        AppModule appModule = new AppModule(this);
        NetworkModule networkModule = new NetworkModule();

        //// TODO: 8/1/2018 comment these and rebuild
        mComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .networkModule(networkModule)
                .build();

        mComponent.inject(this);
    }
}
