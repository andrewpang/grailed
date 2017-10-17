package com.andrewpang.grailed.ArticleData;

import com.andrewpang.grailed.HasDataList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ArticlePage implements HasDataList {

    @SerializedName("data")
    @Expose
    private List<Article> data = null;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;

    public List<Article> getData() {
        return data;
    }

    public void setData(List<Article> data) {
        this.data = data;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
}
