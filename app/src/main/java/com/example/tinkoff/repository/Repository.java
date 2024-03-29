package com.example.tinkoff.repository;

import com.example.tinkoff.model.NewsFeed;
import com.example.tinkoff.model.NewsContent;
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

    public Single<NewsContent> getContent(int newsId) {
        return service.getContent(newsId);
    }
}
