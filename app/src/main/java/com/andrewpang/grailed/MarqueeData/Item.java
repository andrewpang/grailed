package com.andrewpang.grailed.MarqueeData;

import com.andrewpang.grailed.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item extends Data {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
}
