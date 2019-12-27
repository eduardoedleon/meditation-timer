package com.dleon.meditationtimer.presenter;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class MainActivityPresenter
{
    private final MainActivityView view;

    @Contract(pure = true)
    public MainActivityPresenter(@NotNull MainActivityView view) {
        this.view = view;
    }


}
