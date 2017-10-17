package com.andrewpang.grailed.Api;

import com.andrewpang.grailed.ArticleData.ArticlePage;
import com.andrewpang.grailed.MarqueeData.Marquee;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCaller {

    public static String BASE_URL = "https://www.grailed.com/api/";
    private Retrofit retrofit;
    private ApiEndpointInterface apiService;

    public ApiCaller() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiEndpointInterface.class);
    }

    public Call<ArticlePage> getArticlePageCall(String pageNumber) {
        return apiService.getArticlePage(pageNumber);
    }

    public Call<Marquee> getMarqueeCall() {
        return apiService.getMarquee();
    }
}
