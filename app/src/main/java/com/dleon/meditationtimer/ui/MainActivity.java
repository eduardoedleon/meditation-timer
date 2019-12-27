package com.dleon.meditationtimer.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.dleon.meditationtimer.R;
import com.dleon.meditationtimer.presenter.MainActivityPresenter;
import com.dleon.meditationtimer.presenter.MainActivityView;
import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements MainActivityView
{
  private MainActivityPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);


    this.presenter = new MainActivityPresenter(this);

    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View view)
      {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
          .setAction("Action", null).show();
      }
    });
  }

  @Override
  public void setTimerText(@NotNull String text)
  {

  }
}
