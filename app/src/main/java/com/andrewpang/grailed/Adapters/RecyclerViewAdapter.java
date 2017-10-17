package com.andrewpang.grailed.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.andrewpang.grailed.ArticleData.Article;
import com.andrewpang.grailed.Data;
import com.andrewpang.grailed.Holders.ArticleDataHolder;
import com.andrewpang.grailed.Holders.DataHolder;
import com.andrewpang.grailed.Holders.ItemDataHolder;
import com.andrewpang.grailed.MarqueeData.Item;
import com.andrewpang.grailed.R;
import com.bumptech.glide.Glide;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<DataHolder> {

    private List dataSet;
    private DataHolder dataHolder;
    private int type;
    private View view;
    private Context context;

    public static final int ARTICLE_TYPE = 0;
    public static final int ITEM_TYPE = 1;

    public RecyclerViewAdapter(Context context, int type, List dataSet) {
        this.context = context;
        this.type = type;
        this.dataSet = dataSet;
    }

    @Override
    public DataHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        final int layoutId = getLayoutIdFromType();
        view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        dataHolder = createDataHolderFromType();
        return dataHolder;
    }

    private int getLayoutIdFromType() {
        switch (type) {
            case ARTICLE_TYPE:
                return R.layout.article_card_view_row;
            case ITEM_TYPE:
            default:
                return R.layout.item_card_view_row;
        }
    }

    private DataHolder createDataHolderFromType() {
        switch (type) {
            case ARTICLE_TYPE:
                return new ArticleDataHolder(view);
            case ITEM_TYPE:
            default:
                return new ItemDataHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(DataHolder holder, int position) {
        if (holder instanceof ArticleDataHolder) {
            bindArticleViewHolder((ArticleDataHolder) holder, position);
        } else if (holder instanceof ItemDataHolder) {
            bindItemViewHolder((ItemDataHolder) holder, position);
        }
    }

    private void bindArticleViewHolder(ArticleDataHolder articleDataHolder, int position) {
        final Article article = (Article) dataSet.get(position);
        articleDataHolder.getTitleTextView().setText(article.getTitle());
        articleDataHolder.getDateTextView().setText(article.getParsedDate());
        Glide.with(context)
             .load(article.getHero())
             .into(articleDataHolder.getArticleImageView());
    }

    private void bindItemViewHolder(ItemDataHolder itemDataHolder, int position) {
        final Item item = (Item) dataSet.get(position);
        itemDataHolder.getTitleTextView().setText(item.getName());
        Glide.with(context)
             .load(item.getImageUrl())
             .into(itemDataHolder.getItemImageView());
    }

    public void addItems(List<Data> dataObj) {
        dataSet.clear();
        dataSet.addAll(dataObj);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}

