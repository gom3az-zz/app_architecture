package com.example.mg.zomato.data;


import com.example.mg.zomato.data.Models.Model;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IGetData {

    //// TODO: 8/1/2018 add your get method
    @GET("/")
    Observable<Model> get();


}
