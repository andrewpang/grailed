package com.andrewpang.grailed.Holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.andrewpang.grailed.R;

public class ArticleDataHolder extends DataHolder {

    TextView titleTextView;
    TextView dateTextView;
    ImageView articleImageView;

    public ArticleDataHolder(View itemView) {
        super(itemView);

        titleTextView = itemView.findViewById(R.id.titleTextView);
        dateTextView = itemView.findViewById(R.id.dateTextView);
        articleImageView = itemView.findViewById(R.id.articleImageView);
    }

    public TextView getTitleTextView() {
        return titleTextView;
    }

    public TextView getDateTextView() {
        return dateTextView;
    }

    public ImageView getArticleImageView() {
        return articleImageView;
    }
}
