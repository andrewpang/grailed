package com.andrewpang.grailed.Adapters;

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
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<DataHolder> {

    private List dataSet;
    private DataHolder dataHolder;
    private int type;
    private View view;

    public static final int ARTICLE_TYPE = 0;
    public static final int ITEM_TYPE = 1;

//        public interface CardClickListener {
//            void onItemClick(int position, View v);
//        }
//
//        public static void setCardClickListener(CardClickListener cardClickListener) {
//            FeedRecyclerViewAdapter.cardClickListener = cardClickListener;
//        }

    public RecyclerViewAdapter(int type, List dataSet) {
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
            final ArticleDataHolder articleDataHolder = (ArticleDataHolder) holder;
            final Article article = (Article) dataSet.get(position);

//            articleDataHolder.dateTextView.setText("hi"
        } else if (holder instanceof ItemDataHolder) {
            final ItemDataHolder itemDataHolder = (ItemDataHolder) holder;
            final Item item = (Item) dataSet.get(position);
        }

    }

    public void addItems(List<Data> dataObj) {
        for (int i = 0; i < dataObj.size(); i++) {
            addItem(dataObj.get(i), i);
        }
    }

    public void addItem(Data dataObj, int index) {
        dataSet.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        dataSet.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}

