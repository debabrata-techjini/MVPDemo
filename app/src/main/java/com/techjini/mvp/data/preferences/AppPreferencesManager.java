package com.techjini.mvp.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * It's a singleton class, which implements PreferencesManager to read from and write to the shared
 * preferences.
 *
 * @author Debu
 */
public class AppPreferencesManager implements PreferencesManager {

  private static final String PREFERENCES_KEY_IS_FIRST_TIME_USER = "isFirstTimeUser";
  private static AppPreferencesManager sAppPreferencesManager;
  private final SharedPreferences mSharedPreferences;

  private AppPreferencesManager(Context context, String preferencesFileName) {
    mSharedPreferences = context.getSharedPreferences(preferencesFileName, Context.MODE_PRIVATE);
  }

  public static AppPreferencesManager getInstance(Context context, String preferencesFileName) {
    if (sAppPreferencesManager == null) {
      sAppPreferencesManager = new AppPreferencesManager(context, preferencesFileName);
    }

    return sAppPreferencesManager;
  }

  /**
   * Gets the is-first-time-user value from the preferences.
   *
   * @return true if the user is a first-time-user.
   */
  @Override public boolean getIsFirstTimeUser() {
    return mSharedPreferences.getBoolean(PREFERENCES_KEY_IS_FIRST_TIME_USER, true);
  }

  /**
   * Sets the is-first-time-user value to the preferences.
   *
   * @param isFirstTimeUser whether the user is a first-time-user
   */
  @Override public void setIsFirstTimeUser(boolean isFirstTimeUser) {
    mSharedPreferences.edit()
        .putBoolean(PREFERENCES_KEY_IS_FIRST_TIME_USER, isFirstTimeUser)
        .apply();
  }
}
