package com.dleon.meditationtimer.presenter;

import org.jetbrains.annotations.NotNull;

/**
 * This interface holds the main methods related to activity view.
 *
 * @author eduardo.dleon
 */
public interface MainActivityView {

    void setTimerText(@NotNull String text);

    void showToastMessage(@NotNull String message);

    void showPlayButton();

    void hidePlayButton();

    void showStopButton();

    void hideStopButton();

    @NotNull String getTimerText();
}
