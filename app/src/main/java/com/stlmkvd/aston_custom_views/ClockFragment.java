package com.stlmkvd.aston_custom_views;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.stlmkvd.aston_custom_views.ClockView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.stlmkvd.aston_custom_views.databinding.FragmentClockBinding;


public class ClockFragment extends Fragment {

    private static final String TAG = "ClockFragment";

    ClockView clockView;
    ClockViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(ClockViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_clock, container, false);
        clockView = v.findViewById(R.id.clock);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onstart()");
        viewModel.getTimeInSeconds().observe(this, (time) -> {
            clockView.setTimeInSeconds(time);
        });
    }
}
