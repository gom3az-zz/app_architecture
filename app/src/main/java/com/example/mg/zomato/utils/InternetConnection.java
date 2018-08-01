package com.example.mg.zomato.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.Objects;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.subjects.PublishSubject;

public class InternetConnection {
    private PublishSubject<Boolean> onlineSubject = PublishSubject.create();

    private static InternetConnection instance;

    public static  synchronized InternetConnection getInstance() {
        if (instance == null)
            instance = new InternetConnection();

        return instance;
    }

    boolean isConnected(Context context) {
        ConnectivityManager manager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = Objects.requireNonNull(manager).getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }

    public Observable<Boolean> onlineSignal() {
        return onlineSubject;
    }

    Observer<Boolean> onlineObserver() {
        return onlineSubject;
    }
}