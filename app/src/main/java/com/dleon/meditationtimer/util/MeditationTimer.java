package com.dleon.meditationtimer.util;

import android.os.CountDownTimer;

import com.dleon.meditationtimer.presenter.MainActivityView;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

/**
 * Meditation timer implements mandatory methods from {@link CountDownTimer} to execute timer.
 *
 * @author eduardo.dleon
 */
public class MeditationTimer extends CountDownTimer {

    /**
     * The interval along the way to receive {@link #onTick(long)} callbacks.
     */
    private static final int COUNT_DOWN_INTERVAL = 1000;

    /**
     * Time format of the count down timer.
     */
    private static final String TIME_FORMAT = "%02d:%02d";

    private final long millisInFuture;
    private final MainActivityView view;

    /**
     * @param view           The view to refresh the necessary ui.
     * @param millisInFuture The number of millis in the future from the call
     *                       to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                       is called.
     */
    public MeditationTimer(
            @NotNull MainActivityView view,
            long millisInFuture) {

        super(millisInFuture, COUNT_DOWN_INTERVAL);

        this.millisInFuture = millisInFuture;
        this.view = view;
    }

    public void onTick(long millisUntilFinished) {
        setTimerTextOnView(millisUntilFinished);
    }

    /**
     * Additional method to stop timer and init the text view.
     */
    public void stop() {
        cancel();
        setTimerTextOnView(this.millisInFuture);
    }

    public void onFinish() {
        setTimerTextOnView(this.millisInFuture);
        this.view.showPlayButton();
        this.view.hideStopButton();
    }

    /**
     * Simple method to set text on text view.
     */
    private void setTimerTextOnView(long millisUntilFinished) {
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished);

        String time = String.format(TIME_FORMAT, minutes, seconds);

        this.view.setTimerText(time);
    }
}
