package com.example.mg.zomato.Screens;

import android.app.Activity;

import com.example.mg.zomato.Screens.DI.IMainScope;
import com.example.mg.zomato.data.Models.Model;
import com.example.mg.zomato.data.IGetData;
import com.example.mg.zomato.data.PreferencesHelper;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@IMainScope
public class DataModel implements IMainContract.IModel {

    private static final String STATE_KEY = "STATE_KEY";
    private final Activity activity;
    private final IGetData mInstance;
    private final PreferencesHelper mHelper;


    @Inject
    public DataModel(Activity activity, IGetData mInstance, PreferencesHelper helper) {
        this.activity = activity;
        this.mInstance = mInstance;
        this.mHelper = helper;
    }


    @Override
    public Observable<Model> get() {
        return mInstance.get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
