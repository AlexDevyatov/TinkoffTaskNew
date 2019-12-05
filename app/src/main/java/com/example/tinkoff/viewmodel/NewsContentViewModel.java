package com.example.tinkoff.viewmodel;

import android.util.Log;

import com.example.tinkoff.di.AppComponent;
import com.example.tinkoff.model.NewsContent;
import com.example.tinkoff.repository.Repository;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NewsContentViewModel extends BaseViewModel<NewsContent> {

    @Inject
    Repository repository;

    private int newsId;

    public NewsContentViewModel(AppComponent appComponent, int newsId) {
        appComponent.inject(this);
        this.newsId = newsId;
    }

    public void request() {
        loadData();
    }

    @Override
    protected void loadData() {
        repository
                .getContent(newsId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<NewsContent>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(NewsContent newsContent) {
                        data.postValue(newsContent);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("GetNewsContentRequest", e.getMessage());
                    }
                });
    }
}
