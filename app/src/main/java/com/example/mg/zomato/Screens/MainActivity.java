package com.example.mg.zomato.Screens;

import android.os.Bundle;


import com.example.mg.zomato.Screens.DI.DaggerMainComponent;
import com.example.mg.zomato.Screens.DI.MainModule;
import com.example.mg.zomato.app.CoreApplication;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainActivityView view;
    @Inject
    MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //// TODO: 8/1/2018 comment these and rebuild

        DaggerMainComponent
                .builder()
                .appComponent(CoreApplication.get(this).getAppComponent())
                .mainModule(new MainModule(this))
                .build().inject(this);

        setContentView(view);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    protected void onStop() {
        mPresenter.onStop();
        super.onStop();
    }

}
