package com.dleon.meditationtimer.util;

import com.dleon.meditationtimer.presenter.MainActivityView;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class MeditationTimerTest {

    private static final int MILLIS_IN_FUTURE = 30000;
    private static final String DEFAULT_TEXT_FORMATTED = "00:30";

    private MeditationTimer meditationTimer;

    @Mock
    private MainActivityView view;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        this.meditationTimer = new MeditationTimer(this.view, MILLIS_IN_FUTURE);
    }

    @Test
    public void onTickTest() {
        // Given
        long millisUntilFinished = 15000;

        // When
        this.meditationTimer.onTick(millisUntilFinished);

        // Then
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(this.view).setTimerText(captor.capture());

        String value = captor.getValue();
        Assert.assertThat(value, CoreMatchers.is("00:15"));
    }

    @Test
    public void stopTest() {
        // When
        this.meditationTimer.stop();

        // Then
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(this.view).setTimerText(captor.capture());

        String value = captor.getValue();
        Assert.assertThat(value, CoreMatchers.is("00:30"));
    }

    @Test
    public void finishTest() {
        // When
        this.meditationTimer.onFinish();

        // Then
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(this.view).setTimerText(captor.capture());

        String value = captor.getValue();
        Assert.assertThat(value, CoreMatchers.is(DEFAULT_TEXT_FORMATTED));

        // Also
        Mockito.verify(this.view).showPlayButton();
        Mockito.verify(this.view).hideStopButton();
    }
}
