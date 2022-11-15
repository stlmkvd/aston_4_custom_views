package com.stlmkvd.aston_custom_views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;

public class CustomFragmentsPager extends View {

    ViewPager2 pager;

    public CustomFragmentsPager(Context context) {
        super(context);
    }

    public CustomFragmentsPager(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomFragmentsPager(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomFragmentsPager(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
