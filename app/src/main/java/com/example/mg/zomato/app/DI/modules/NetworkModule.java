package com.example.mg.zomato.app.DI.modules;

import android.content.Context;

import com.example.mg.zomato.app.DI.IApplicationContext;
import com.example.mg.zomato.app.DI.IApplicationScope;
import com.example.mg.zomato.data.IGetData;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    //// TODO: 8/1/2018 update with ur url
    private  static final String URL = "https://google.com/";
    @Provides
    @IApplicationScope
    public Cache provideCache(File cacheFile) {
        return new Cache(cacheFile, 10 * 1024);
    }

    @Provides
    @IApplicationScope
    public File provideCacheFile(@IApplicationContext Context context) {
        return new File(context.getCacheDir(), "okHttp_cache");

    }

    @Provides
    @IApplicationScope
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();
    }

    @Provides
    @IApplicationScope
    public HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        return interceptor;
    }

    @Provides
    @IApplicationScope
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @IApplicationScope
    public IGetData provideRetrofitClient(Retrofit retrofit) {
        return retrofit
                .create(IGetData.class);
    }

}
