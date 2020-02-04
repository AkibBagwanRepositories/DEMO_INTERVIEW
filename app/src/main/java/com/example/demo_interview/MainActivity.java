package com.example.demo_interview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Photo> photoList;
    PhotoAdapter photoAdapter;
    CompositeDisposable disposable = new CompositeDisposable();
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        showLoading();
        disposable.add(call()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        hideLoading();
                        photoAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideLoading();
                        Toast.makeText(getBaseContext(), "Error while loading" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }));
    }

    private Completable call() {
        return Completable.fromAction(new Action() {
            @Override
            public void run() {
                List<Photo> photos = APIManager.getListOfPhotos();
                photoList.clear();
                if (photos != null)
                    photoList.addAll(photos);
            }
        });
    }

    private void init() {
        recyclerView = findViewById(R.id.rv_photos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        photoList = new ArrayList<>();
        photoAdapter = new PhotoAdapter(photoList, this);
        recyclerView.setAdapter(photoAdapter);
    }

    void showLoading() {
        if (dialog == null)
            dialog = ProgressDialog.show(this, "Loading",
                    "Loading data from server. Please wait...", true);
    }

    void hideLoading() {
        if (dialog != null)
            dialog.hide();
    }
}
