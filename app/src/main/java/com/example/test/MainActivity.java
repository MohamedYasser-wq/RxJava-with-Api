package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ListAdapter;

import com.example.test.Data.PostModel;
import com.example.test.Presentation.RecPosts;
import com.example.test.ViewModel.PostsViewModel;
import com.example.test.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.disposables.Disposable;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PostsViewModel postsViewModel;
    private RecPosts recPosts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        postsViewModel=new ViewModelProvider(this).get(PostsViewModel.class);

    GetData();

    }


    public  void GetData(){
        postsViewModel.GetAllPosts();
        postsViewModel.mutableLiveData.observe(this, new Observer<ArrayList<PostModel>>() {
            @Override
            public void onChanged(ArrayList<PostModel> postModels) {
                SetAdapter(postModels);
            }
        });

    }

    private void SetAdapter(ArrayList<PostModel> postModels) {
        recPosts=new RecPosts(postModels);
       binding.RecyclerView.setAdapter(recPosts);
    }


}
