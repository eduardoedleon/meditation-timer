package com.dleon.meditationtimer.presenter;

import com.dleon.meditationtimer.util.MeditationTimer;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;


/**
 * Presenter holds the main functions related to the main activity.
 *
 * @author eduardo.dleon
 */
public class MainActivityPresenter {

    /**
     * The number of millis in the future from the call
     * start until the countdown is done.
     */
    private static final int MILLIS_IN_FUTURE = 30000;

    private final MainActivityView view;
    private final MeditationTimer meditationTimer;

    @Contract(pure = true)
    public MainActivityPresenter(@NotNull MainActivityView view) {
        this.view = view;
        this.meditationTimer = new MeditationTimer(view, MILLIS_IN_FUTURE);
    }

    /**
     * Action to be executed when the play button is clicked.
     */
    public void onClickPlayButton() {
        this.meditationTimer.start();
        this.view.hidePlayButton();
        this.view.showStopButton();
    }

    /**
     * Action to be executed when the stop button is clicked.
     */
    public void onClickStopButton() {
        this.meditationTimer.stop();
        this.view.showPlayButton();
        this.view.hideStopButton();
    }
}
