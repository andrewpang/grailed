package com.andrewpang.grailed;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.andrewpang.grailed.Adapters.RecyclerViewAdapter;
import com.andrewpang.grailed.Api.ApiCaller;
import com.andrewpang.grailed.ArticleData.ArticlePage;
import com.andrewpang.grailed.MarqueeData.Marquee;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedFragment extends Fragment {

    private View view;
    private List list;
    private RecyclerView.Adapter recyclerViewAdapter;

    public FeedFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_feed, container, false);

        int type = getArguments().getInt("type");
        list = new ArrayList<>();

        if (type == RecyclerViewAdapter.ARTICLE_TYPE) {
            getArticles();
        } else if (type == RecyclerViewAdapter.ITEM_TYPE) {
            getItems();
        }

        recyclerViewAdapter = new RecyclerViewAdapter(getContext(), type, list);
        setupRecyclerView(recyclerViewAdapter);

        return view;
    }

    private void getArticles() {
        new ApiCaller().getArticlePageCall("1").enqueue(new Callback<ArticlePage>() {
            @Override
            public void onResponse(Call<ArticlePage> call, Response<ArticlePage> response) {
                updateAdapterData(response.body());
            }

            @Override
            public void onFailure(Call<ArticlePage> call, Throwable t) {
                // Log error here since request failed
            }
        });
    }

    private void getItems() {
        new ApiCaller().getMarqueeCall().enqueue(new Callback<Marquee>() {
            @Override
            public void onResponse(Call<Marquee> call, Response<Marquee> response) {
                updateAdapterData(response.body());
            }

            @Override
            public void onFailure(Call<Marquee> call, Throwable t) {
                // Log error here since request failed
            }
        });
    }

    private void updateAdapterData(HasDataList page) {
        list = page.getData();
        RecyclerViewAdapter feedRecyclerViewAdapter = (RecyclerViewAdapter) recyclerViewAdapter;
        feedRecyclerViewAdapter.addItems(list);
    }

    private void setupRecyclerView(RecyclerView.Adapter recyclerViewAdapter) {
        final RecyclerView feedRecyclerView = view.findViewById(R.id.feed_recycler_view);
        feedRecyclerView.setHasFixedSize(true);
        feedRecyclerView.setAdapter(recyclerViewAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        feedRecyclerView.setLayoutManager(llm);
    }
}


