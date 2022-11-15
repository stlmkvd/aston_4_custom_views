package com.stlmkvd.aston_custom_views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.stlmkvd.aston_custom_views.adapters.TaskFragmentsAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private ViewPager2 pager;
    private final List<Class<? extends Fragment>> fragments = new ArrayList<Class<? extends Fragment>>() {
        {
            //you can easily dispatch your fragments for pager here
            add(TitleFragment.class);
            add(ClockFragment.class);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.view_pager);
        pager.setAdapter(new TaskFragmentsAdapter(this, fragments));
    }

    @Override
    public void onBackPressed() {
        if (pager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            pager.setCurrentItem(pager.getCurrentItem() - 1);
        }
    }
}