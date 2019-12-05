package com.example.tinkoff;

import android.app.Application;

import com.example.tinkoff.di.AppComponent;
import com.example.tinkoff.di.DaggerAppComponent;
import com.example.tinkoff.di.NetModule;

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .netModule(new NetModule("https://api.tinkoff.ru/v1/"))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
