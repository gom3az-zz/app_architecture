package com.example.mg.zomato.Screens;


import com.example.mg.zomato.data.Models.Model;

import io.reactivex.Observable;

public interface IMainContract {
    interface IView {

        void showLoading();

        void hideLoading();

        void onStop();

    }

    interface IPresenter {

        void onStart();

        void onStop();


    }

    interface IModel {
        Observable<Model> get();

    }
}
