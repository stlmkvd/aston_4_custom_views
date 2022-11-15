package com.stlmkvd.aston_custom_views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ClockView extends FrameLayout {

    private static final String TAG = "ClockView";

    private final ImageView clockFace;
    private final ImageView hoursArrow;
    private final ImageView minutesArrow;
    private final ImageView secondsArrow;
    private final LayoutParams paramsForImageViews;


    {
        paramsForImageViews
                = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        clockFace = createImageView(R.drawable.clockface);
        hoursArrow = createImageView(R.drawable.hour_arrow);
        minutesArrow = createImageView(R.drawable.minute_arrow);
        secondsArrow = createImageView(R.drawable.seconds_arrow);
        addView(clockFace);
        addView(minutesArrow);
        addView(hoursArrow);
        addView(secondsArrow);
    }

    public ClockView(@NonNull Context context) {
        super(context);
    }

    public ClockView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ClockView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ClockView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private ImageView createImageView(int drawableId) {
        @SuppressLint("UseCompatLoadingForDrawables")
        Drawable d = getResources().getDrawable(drawableId, null);
        ImageView view = new ImageView(getContext());
        view.setLayoutParams(paramsForImageViews);
        view.setAdjustViewBounds(true);
        view.setImageDrawable(d);
        return view;
    }

    public void setTimeInSeconds(long timeInSeconds) {
        long seconds = timeInSeconds % 60;
        float secondsRotationDegree = 6f * seconds;
        secondsArrow.setRotation(secondsRotationDegree);

        long minutes = timeInSeconds / 60 % 60;
        float minutesRotationDegree = 6f * minutes;
        minutesArrow.setRotation(minutesRotationDegree);

        long hours = (timeInSeconds / 3600 + 3) % 12;
        float hoursRotationDegree = 6f * (hours * 5 + minutes / 12f);
        hoursArrow.setRotation(hoursRotationDegree);
    }
}

