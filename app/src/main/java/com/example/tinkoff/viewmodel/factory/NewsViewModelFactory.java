package com.example.tinkoff.viewmodel.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.tinkoff.di.AppComponent;
import com.example.tinkoff.viewmodel.NewsViewModel;

public class NewsViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final AppComponent appComponent;

    public NewsViewModelFactory(AppComponent appComponent) {
        this.appComponent = appComponent;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == NewsViewModel.class) {
            return (T) new NewsViewModel(appComponent);
        }
        return null;
    }
}
