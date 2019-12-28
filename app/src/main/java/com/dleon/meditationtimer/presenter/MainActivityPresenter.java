package com.dleon.meditationtimer.presenter;

import android.os.CountDownTimer;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

/**
 * Presenter holds the main functions related to the main activity.
 */
public class MainActivityPresenter {

    private static final int MILLIS_IN_FUTURE = 30000;
    private static final int COUNT_DOWN_INTERVAL = 1000;
    private static final String TIME_FORMAT = "%02d:%02d";

    private final MainActivityView view;
    private CountDownTimer countDownTimer;

    @Contract(pure = true)
    public MainActivityPresenter(@NotNull MainActivityView view) {
        this.view = view;
    }

    public void onClickPlayButton() {

        this.countDownTimer = new CountDownTimer(MILLIS_IN_FUTURE, COUNT_DOWN_INTERVAL) {
            public void onTick(long millisUntilFinished) {

                long minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
                long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished);

                String time = String.format(TIME_FORMAT, minutes, seconds);

                MainActivityPresenter.this.view.setTimerText(time);
            }

            public void onFinish() {
//                mTextField.setText("done!");
            }
        }.start();
    }
}
