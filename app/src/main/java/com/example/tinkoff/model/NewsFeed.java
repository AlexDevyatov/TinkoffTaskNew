package com.example.tinkoff.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsFeed {

    @SerializedName("resultCode")
    private String resultCode;

    @SerializedName("payload")
    private List<News> newsList;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}
