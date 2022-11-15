package com.stlmkvd.aston_custom_views.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class TaskFragmentsAdapter extends FragmentStateAdapter {

    private final List<Class<? extends Fragment>> fragments;

    public TaskFragmentsAdapter(FragmentActivity fa, List<Class<? extends Fragment>> fragments) {
        super(fa);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        try {
            return fragments.get(position).newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException("Could not instantiate fragment " +
                    fragments.get(position).getCanonicalName());
        }
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
