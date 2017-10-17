package com.andrewpang.grailed.MarqueeData;

import com.andrewpang.grailed.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Marquee extends Data{

    @SerializedName("data")
    @Expose
    private List<Item> data = null;

    public List<Item> getData() {
        return data;
    }

    public void setData(List<Item> data) {
        this.data = data;
    }

}
