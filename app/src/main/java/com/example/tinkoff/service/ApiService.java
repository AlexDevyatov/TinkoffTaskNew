package com.example.tinkoff.service;

import com.example.tinkoff.model.NewsFeed;
import com.example.tinkoff.model.NewsText;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("news")
    Single<NewsFeed> getNewsFeed();

    @GET("news_content")
    Single<NewsText> getContent(@Query("id") int newsId);
}
