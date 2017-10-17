package com.andrewpang.grailed.Holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.andrewpang.grailed.R;

public class ItemDataHolder extends DataHolder {

    TextView titleTextView;
    ImageView itemImageView;

    public ItemDataHolder(View itemView) {
        super(itemView);

        titleTextView = itemView.findViewById(R.id.titleTextView);
        itemImageView = itemView.findViewById(R.id.itemImageView);
    }

    public TextView getTitleTextView() {
        return titleTextView;
    }

    public ImageView getItemImageView() {
        return itemImageView;
    }
}
