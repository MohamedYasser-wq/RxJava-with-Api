package com.example.test.ViewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.test.ApiData.RetoConnection;
import com.example.test.Data.PostModel;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class PostsViewModel extends ViewModel {

   public MutableLiveData<ArrayList<PostModel>>mutableLiveData=new MutableLiveData<>();

    public void GetAllPosts(){

        Observable observable = RetoConnection.getInst().GetAllPosts().
           subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer<ArrayList<PostModel>>observer=new Observer<ArrayList<PostModel>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArrayList<PostModel> value) {
                mutableLiveData.setValue(value);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("TAG", "onError: "+e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);

    }
}
