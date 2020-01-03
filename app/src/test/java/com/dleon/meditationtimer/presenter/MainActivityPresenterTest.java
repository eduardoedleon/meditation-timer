package com.dleon.meditationtimer.presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class MainActivityPresenterTest {

    private MainActivityPresenter presenter;

    @Mock
    private MainActivityView view;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        this.presenter = new MainActivityPresenter(this.view);
    }

    @Test
    public void onClickPlayButtonTest() {
        // When
        this.presenter.onClickPlayButton();

        // Then
        Mockito.verify(this.view).hidePlayButton();
        Mockito.verify(this.view).showStopButton();
    }

    @Test
    public void onClickStopButtonTest() {
        // When
        this.presenter.onClickStopButton();

        // Then
        Mockito.verify(this.view).showPlayButton();
        Mockito.verify(this.view).hideStopButton();
    }
}
