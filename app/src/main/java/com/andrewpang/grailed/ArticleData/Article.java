package com.andrewpang.grailed.ArticleData;

import com.andrewpang.grailed.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Article extends Data {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("hero")
    @Expose
    private String hero;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }
}
