package com.dleon.meditationtimer.util;

import android.os.CountDownTimer;

import com.dleon.meditationtimer.presenter.MainActivityPresenter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class MeditationTimer extends CountDownTimer {

    private static final String TIME_FORMAT = "%02d:%02d";

    private final AtomicBoolean timerRunning;
    private final MainActivityPresenter presenter;

    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     * @param presenter         The presenter to execute the necessary methods.
     */
    public MeditationTimer(long millisInFuture, long countDownInterval, MainActivityPresenter presenter) {
        super(millisInFuture, countDownInterval);
        this.timerRunning = new AtomicBoolean(false);
        this.presenter = presenter;
    }

    public void onTick(long millisUntilFinished) {

        if (!isTimerRunning()) {
            this.timerRunning.set(true);
        }

        long minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished);

        String time = String.format(TIME_FORMAT, minutes, seconds);

        this.presenter.getView().setTimerText(time);
    }

    public void onFinish() {
        this.timerRunning.set(false);
    }

    private boolean isTimerRunning() {
        return this.timerRunning.get();
    }
}
