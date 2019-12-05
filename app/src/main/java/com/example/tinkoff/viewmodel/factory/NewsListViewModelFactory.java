package com.example.tinkoff.viewmodel.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.tinkoff.di.AppComponent;
import com.example.tinkoff.viewmodel.NewsListViewModel;

public class NewsListViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final AppComponent appComponent;

    public NewsListViewModelFactory(AppComponent appComponent) {
        this.appComponent = appComponent;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == NewsListViewModel.class) {
            return (T) new NewsListViewModel(appComponent);
        }
        return null;
    }
}
