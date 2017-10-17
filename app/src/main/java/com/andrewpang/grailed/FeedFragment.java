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
import com.andrewpang.grailed.MarqueeData.Item;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedFragment extends Fragment {
    private static final String TAG = "FEED_FRAGMENT";
    private View view;
    private int type;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerViewAdapter feedRecyclerViewAdapter;
    private LinearLayoutManager llm;
    private List list;

    public FeedFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_feed, container, false);

        type = getArguments().getInt("type");
        list = new ArrayList<>();

        if (type == RecyclerViewAdapter.ARTICLE_TYPE) {
            getArticles();
        } else if (type == RecyclerViewAdapter.ITEM_TYPE){
            list.add(new Item());
            list.add(new Item());
        }

        recyclerViewAdapter = new RecyclerViewAdapter(type, list);
        setupRecyclerView(recyclerViewAdapter);

        return view;
    }

    private void getArticles() {
        new ApiCaller().getArticlePageCall("1").enqueue(new Callback<ArticlePage>() {
            @Override
            public void onResponse(Call<ArticlePage> call, Response<ArticlePage> response) {
                int statusCode = response.code();
                ArticlePage page = response.body();

                list = page.getData();
                feedRecyclerViewAdapter = (RecyclerViewAdapter) recyclerViewAdapter;
//                feedRecyclerViewAdapter.addItems(list);
            }

            @Override
            public void onFailure(Call<ArticlePage> call, Throwable t) {
                // Log error here since request failed
            }
        });
    }

    private void addData(Data dreamEntry) {
        feedRecyclerViewAdapter = (RecyclerViewAdapter) recyclerViewAdapter;
        feedRecyclerViewAdapter.addItem(dreamEntry, 0);
        llm.scrollToPosition(0);
    }

    private void setupRecyclerView(RecyclerView.Adapter recyclerViewAdapter) {
        final RecyclerView feedRecyclerView = view.findViewById(R.id.feed_recycler_view);
        feedRecyclerView.setHasFixedSize(true);
        feedRecyclerView.setAdapter(recyclerViewAdapter);
        llm = new LinearLayoutManager(getActivity());
        feedRecyclerView.setLayoutManager(llm);
    }

}

//        new ApiCaller().getMarqueeCall().enqueue(new Callback<Marquee>() {
//            @Override
//            public void onResponse(Call<Marquee> call, Response<Marquee> response) {
//                int statusCode = response.code();
//                Marquee page = response.body();
//            }
//
//            @Override
//            public void onFailure(Call<Marquee> call, Throwable t) {
//                // Log error here since request failed
//            }
//        });


