package com.andrewpang.grailed;

import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.andrewpang.grailed.Adapters.RecyclerViewAdapter;
import com.andrewpang.grailed.Adapters.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private RecyclerViewAdapter recyclerViewAdapter;
    private LinearLayoutManager llm;
    private ViewPagerAdapter viewPagerAdapter;

    TabLayout.Tab articlesFeed;
    TabLayout.Tab itemsFeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupTabLayout();

    }

    private void setupTabLayout() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        createTabs();
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void createTabs() {
        articlesFeed = tabs.newTab();
        itemsFeed = tabs.newTab();

        articlesFeed.setText("Articles");
        itemsFeed.setText("Items");

        tabs.addTab(articlesFeed, 0);
        tabs.addTab(itemsFeed, 1);

        tabs.setTabTextColors(ContextCompat.getColorStateList(this, R.color.tab_selector));
        tabs.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.blue_grey_200));
    }

}
