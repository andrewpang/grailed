package com.andrewpang.grailed.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.andrewpang.grailed.FeedFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        final Bundle args = new Bundle();
        final FeedFragment feed = new FeedFragment();
        args.putInt("type", position);
        feed.setArguments(args);
        return feed;
    }

    @Override
    public int getCount() {
        return 2;
    }

}
