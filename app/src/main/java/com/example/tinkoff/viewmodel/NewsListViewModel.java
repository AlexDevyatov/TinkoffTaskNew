package com.example.tinkoff.viewmodel;

import android.util.Log;

import com.example.tinkoff.di.AppComponent;
import com.example.tinkoff.model.NewsFeed;
import com.example.tinkoff.repository.Repository;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NewsListViewModel extends BaseViewModel<NewsFeed> {

    @Inject
    Repository repository;

    public NewsListViewModel(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public void request() {
        loadData();
    }

    @Override
    protected void loadData() {
        repository
                .getNewsFeed()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<NewsFeed>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(NewsFeed newsFeed) {
                        data.postValue(newsFeed);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("GetNewsRequest", e.getMessage());
                    }
                });
    }
}
