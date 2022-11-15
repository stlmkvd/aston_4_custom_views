package com.stlmkvd.aston_custom_views;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ClockViewModel extends ViewModel {

    private final MutableLiveData<Long> timeInSeconds = new MutableLiveData<>();
    private Thread counterThread;

    {
        setTimeInSeconds(System.currentTimeMillis() / 1000);
    }

    public void setTimeInSeconds(long timeInSeconds) {
        if (counterThread != null) {
            counterThread.interrupt();

        }
        counterThread = new Thread(() -> {
            long seconds = timeInSeconds;
            while (!counterThread.isInterrupted()) {
                this.timeInSeconds.postValue(seconds);
                try {
                    Thread.sleep(1000);
                    seconds++;
                } catch (InterruptedException e) {
                    return;
                }
            }
        });
        counterThread.start();
    }

    public MutableLiveData<Long> getTimeInSeconds() {
        return timeInSeconds;
    }
}
