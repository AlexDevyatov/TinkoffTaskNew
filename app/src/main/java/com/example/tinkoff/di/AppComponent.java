package com.example.tinkoff.di;

import com.example.tinkoff.viewmodel.NewsViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetModule.class})
public interface AppComponent {

    void inject(NewsViewModel newsViewModel);
}
