package com.dleon.meditationtimer.presenter;

import com.dleon.meditationtimer.util.MeditationTimer;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;


/**
 * Presenter holds the main functions related to the main activity.
 */
public class MainActivityPresenter {

    private static final int MILLIS_IN_FUTURE = 30000;
    private static final int COUNT_DOWN_INTERVAL = 1000;

    private final MainActivityView view;
    private final MeditationTimer meditationTimer;

    @Contract(pure = true)
    public MainActivityPresenter(@NotNull MainActivityView view) {
        this.view = view;
        this.meditationTimer = new MeditationTimer(MILLIS_IN_FUTURE, COUNT_DOWN_INTERVAL, this);
    }

    public void onClickPlayButton() {
        if (!this.meditationTimer.isTimerRunning()) {
            this.meditationTimer.start();
        }else{
            this.view.showToastMessage("The timer is ");
        }
    }

    public @NotNull MainActivityView getView() {
        return this.view;
    }
}
