package com.example.tinkoff.viewmodel;

import com.example.tinkoff.di.AppComponent;
import com.example.tinkoff.model.NewsFeed;

public class NewsViewModel extends BaseViewModel<NewsFeed> {


    public NewsViewModel(AppComponent appComponent) {
        appComponent.inject(this);
    }

    @Override
    protected void loadData() {

    }
}
