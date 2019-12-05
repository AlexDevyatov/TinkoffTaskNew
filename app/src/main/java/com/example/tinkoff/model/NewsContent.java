package com.example.tinkoff.model;

import com.google.gson.annotations.SerializedName;

public class NewsContent {

    @SerializedName("resultCode")
    private String resultCode;

    @SerializedName("payload")
    private Payload payload;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }
}
