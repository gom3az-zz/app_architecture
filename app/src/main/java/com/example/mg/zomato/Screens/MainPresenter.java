package com.example.mg.zomato.Screens;

import android.widget.Toast;

import com.example.mg.zomato.Screens.DI.IMainScope;
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

@IMainScope
public class MainPresenter implements IMainContract.IPresenter {
    private final MainActivityView mView;
    private CompositeDisposable disposable = new CompositeDisposable();
    private DataModel dataModel;

    @Inject
    public MainPresenter(MainActivityView view, DataModel model) {
        mView = view;
        dataModel = model;
    }

    @Override
    public void onStart() {
        disposable.add(
                ReactiveNetwork.observeNetworkConnectivity(mView.getContext())
                        .doOnSubscribe(__ -> mView.showLoading())
                       // .flatMap(connectivity -> dataModel.get())
                        .doOnNext(__ -> mView.hideLoading())
                        .subscribe(__ -> {
                                }
                        ));
    }


    @Override
    public void onStop() {
        disposable.clear();
        mView.onStop();
    }
}
