package com.example.tinkoff.model;

import com.google.gson.annotations.SerializedName;

public class NewsText {

    @SerializedName("resultCode")
    private String resultCode;

    @SerializedName("content")
    private String content;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
