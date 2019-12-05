package com.example.tinkoff.model;

import com.google.gson.annotations.SerializedName;

public class PublicationDate implements Comparable<PublicationDate>{

    @SerializedName("milliseconds")
    private Long millis;

    public Long getMillis() {
        return millis;
    }

    public void setMillis(Long millis) {
        this.millis = millis;
    }

    @Override
    public int compareTo(PublicationDate publicationDate) {
        return millis.compareTo(publicationDate.getMillis());
    }
}
