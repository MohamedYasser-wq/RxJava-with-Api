package com.example.test.ApiData;

import com.example.test.Data.PostModel;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_Interface {


@GET("/posts")
Observable<ArrayList<PostModel>> GetAllPosts();





}
