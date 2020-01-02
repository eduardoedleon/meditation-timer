package com.dleon.meditationtimer.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dleon.meditationtimer.R;
import com.dleon.meditationtimer.presenter.MainActivityPresenter;
import com.dleon.meditationtimer.presenter.MainActivityView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private MainActivityPresenter presenter;

    private TextView timerTextView;
    private FloatingActionButton playButton;
    private FloatingActionButton stopButton;
    private FloatingActionButton settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeToolbar();

        this.presenter = new MainActivityPresenter(this);
        this.timerTextView = findViewById(R.id.timer_text_view);

        initializePlayButton();
        initializeStopButton();

        this.settingsButton = findViewById(R.id.settings_button);
    }

    private void initializeToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initializePlayButton() {
        this.playButton = findViewById(R.id.play_button);
        this.playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.presenter.onClickPlayButton();
            }
        });
    }

    private void initializeStopButton() {
        this.stopButton = findViewById(R.id.stop_button);
        this.stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.presenter.onClickStopButton();
            }
        });
        hideStopButton();
    }

    @Override
    public void setTimerText(@NotNull String text) {
        this.timerTextView.setText(text);
    }

    @Override
    public void showToastMessage(@NotNull String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPlayButton() {
        this.playButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePlayButton() {
        this.playButton.setVisibility(View.GONE);
    }

    @Override
    public void showStopButton() {
        this.stopButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideStopButton() {
        this.stopButton.setVisibility(View.GONE);
    }

    @Override
    public @NotNull String getTimerText() {
        return this.timerTextView.getText().toString();
    }
}
