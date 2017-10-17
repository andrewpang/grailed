package com.andrewpang.grailed.Api;

import com.andrewpang.grailed.ArticleData.ArticlePage;
import com.andrewpang.grailed.MarqueeData.Marquee;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiEndpointInterface {

    @GET("articles/ios_index")
    Call<ArticlePage> getArticlePage(@Query("page") String number);


    @GET("merchandise/marquee")
    Call<Marquee> getMarquee();
}
