package com.example.mg.zomato.Screens;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.FrameLayout;

import com.bumptech.glide.RequestManager;
import com.example.mg.zomato.R;
import com.example.mg.zomato.Screens.DI.IMainScope;
import com.example.mg.zomato.utils.DialogUtils;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import butterknife.ButterKnife;
import butterknife.Unbinder;

@SuppressLint("ViewConstructor")
@IMainScope
public class MainActivityView extends FrameLayout implements IMainContract.IView {


    private Unbinder unbinder;

    private ProgressDialog progressDialog;

    @Inject
    public MainActivityView(@NonNull Activity activity, RequestManager glide) {
        super(activity);
        inflate(getContext(), R.layout.activity_main, this);
        unbinder = ButterKnife.bind(this);

    }

    @Override
    public void showLoading() {
        progressDialog = DialogUtils.showLoadingDialog(getContext());

    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void onStop() {
        if (unbinder != null) unbinder.unbind();
    }
}
