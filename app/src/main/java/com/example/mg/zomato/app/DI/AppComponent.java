package com.example.mg.zomato.app.DI;

import com.bumptech.glide.RequestManager;
import com.example.mg.zomato.app.CoreApplication;
import com.example.mg.zomato.app.DI.modules.AppModule;
import com.example.mg.zomato.app.DI.modules.NetworkModule;
import com.example.mg.zomato.data.IGetData;
import com.example.mg.zomato.data.PreferencesHelper;

import dagger.Component;

@IApplicationScope
@Component(modules = {NetworkModule.class, AppModule.class})
public interface AppComponent {

    IGetData RetrofitClient();

    PreferencesHelper helper();

    RequestManager glide();

    void inject(CoreApplication application);


}
