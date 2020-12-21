package com.arpa404.a211;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TabLayout tl = findViewById(R.id.tab_layout);

        tl.addTab(tl.newTab().setText("Top Stories"));
        tl.addTab(tl.newTab().setText("Tech News"));
        tl.addTab(tl.newTab().setText("Cooking"));

        tl.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager vp = findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tl.getTabCount());
        vp.setAdapter(adapter);
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tl));

        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}