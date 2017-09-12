package com.techjini.mvp.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.techjini.mvp.R;

/**
 * @author Debu
 */
public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    startWelcomeFragment();
  }

  private void startWelcomeFragment() {
    WelcomeFragment welcomeFragment = (WelcomeFragment) getSupportFragmentManager().
        findFragmentById(R.id.layout_fragment_container);

    if (welcomeFragment == null) {
      getSupportFragmentManager().beginTransaction()
          .add(R.id.layout_fragment_container, WelcomeFragment.newInstance())
          .commit();
    }
  }
}
