package com.techjini.mvp.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.techjini.mvp.R;
import com.techjini.mvp.data.AppDataManager;
import com.techjini.mvp.data.DataManager;
import com.techjini.mvp.data.database.AppDatabaseManager;
import com.techjini.mvp.data.file.AppFileManager;
import com.techjini.mvp.data.network.AppApiManager;
import com.techjini.mvp.data.preferences.AppPreferencesManager;
import com.techjini.mvp.util.AppConstants;

/**
 * When the user launches the app, it shows the main activity. As soon as the main activity is
 * created, it starts the welcome fragment.
 *
 * @author Debu
 */
public class MainActivity extends AppCompatActivity {

  private WelcomeFragment mWelcomeFragment;
  private WelcomeFragmentPresenter mWelcomeFragmentPresenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    startWelcomeFragment();
    initializeWelcomeFragmentPresenter();
  }

  /**
   * Starts the welcome fragment, if it's already not started.
   */
  private void startWelcomeFragment() {
    mWelcomeFragment = (WelcomeFragment) getSupportFragmentManager().
        findFragmentById(R.id.layout_fragment_container);

    if (mWelcomeFragment == null) {
      mWelcomeFragment = WelcomeFragment.newInstance();
      getSupportFragmentManager().beginTransaction()
          .add(R.id.layout_fragment_container, mWelcomeFragment)
          .commit();
    }
  }

  /**
   * Initializes the welcome fragment presenter. When the presenter is initialized in it's
   * constructor, the presenter is set to the welcome fragment.
   */
  private void initializeWelcomeFragmentPresenter() {
    DataManager dataManager =
        AppDataManager.getInstance(AppDatabaseManager.getInstance(), AppApiManager.getInstance(),
            AppPreferencesManager.getInstance(this, AppConstants.PREFERENCES_FILE_NAME),
            AppFileManager.getInstance());
    mWelcomeFragmentPresenter = new WelcomeFragmentPresenter(dataManager, mWelcomeFragment);
  }
}
