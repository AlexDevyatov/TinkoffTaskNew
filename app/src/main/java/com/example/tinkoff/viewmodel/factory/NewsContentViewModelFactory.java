package com.example.tinkoff.viewmodel.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.tinkoff.di.AppComponent;
import com.example.tinkoff.viewmodel.NewsContentViewModel;

public class NewsContentViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final AppComponent appComponent;

    private int newsId;

    public NewsContentViewModelFactory(AppComponent appComponent, int newsId) {
        this.appComponent = appComponent;
        this.newsId = newsId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == NewsContentViewModel.class) {
            return (T) new NewsContentViewModel(appComponent, newsId);
        }
        return null;
    }
}
