package com.example.tinkoff.repository;

import com.example.tinkoff.model.NewsFeed;
import com.example.tinkoff.model.NewsText;
import com.example.tinkoff.service.ApiService;

import io.reactivex.Single;

public class Repository {

    private ApiService service;

    public Repository(ApiService service) {
        this.service = service;
    }

    public Single<NewsFeed> getNewsFeed() {
        return service.getNewsFeed();
    }

    public Single<NewsText> getContent(int newsId) {
        return service.getContent(newsId);
    }
}
