package com.example.tinkoff.di;

import com.example.tinkoff.viewmodel.NewsContentViewModel;
import com.example.tinkoff.viewmodel.NewsListViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetModule.class})
public interface AppComponent {

    void inject(NewsListViewModel newsListViewModel);

    void inject(NewsContentViewModel newsContentViewModel);
}
