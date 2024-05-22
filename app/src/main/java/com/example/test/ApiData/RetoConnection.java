package com.example.test.ApiData;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetoConnection {

    private static Retrofit retrofit;

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Api_Interface getInst() {
        return getRetrofit().create(Api_Interface.class);
    }

}
