package com.example.mg.zomato.Screens.DI;

import android.app.Activity;

import com.bumptech.glide.RequestManager;
import com.example.mg.zomato.Screens.DataModel;
import com.example.mg.zomato.Screens.IMainContract;
import com.example.mg.zomato.Screens.MainActivityView;
import com.example.mg.zomato.Screens.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    private final Activity mainActivity;

    public MainModule(Activity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @IMainScope
    Activity activity() {
        return mainActivity;
    }

    @Provides
    @IMainScope
    IMainContract.IView view(MainActivityView view) {
        return view;
    }

    @Provides
    @IMainScope
    IMainContract.IModel model(DataModel model) {
        return model;
    }

    @Provides
    @IMainScope
    IMainContract.IPresenter presenter(MainPresenter presenter) {
        return presenter;
    }

}
