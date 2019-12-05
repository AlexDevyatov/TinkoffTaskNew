package com.example.tinkoff.model;

import com.google.gson.annotations.SerializedName;

public class News implements Comparable<News> {

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("text")
    private String text;

    @SerializedName("publicationDate")
    private PublicationDate publicationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public PublicationDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(PublicationDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public int compareTo(News news) {
        return publicationDate.compareTo(news.getPublicationDate());
    }
}
