package com.example.tinkoff.model;

import com.google.gson.annotations.SerializedName;

public class Payload {

    @SerializedName("content")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
