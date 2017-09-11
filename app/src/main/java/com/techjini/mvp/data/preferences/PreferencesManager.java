package com.techjini.mvp.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author Debu
 */
public class PreferencesManager {

  private static final String PREFERENCES_KEY_IS_FIRST_TIME_USER = "isFirstTimeUser";
  private final SharedPreferences mSharedPreferences;

  public PreferencesManager(Context context, String preferencesFileName) {
    mSharedPreferences = context.getSharedPreferences(preferencesFileName, Context.MODE_PRIVATE);
  }

  public boolean getIsFirstTimeUser() {
    return mSharedPreferences.getBoolean(PREFERENCES_KEY_IS_FIRST_TIME_USER, true);
  }

  public void setIsFirstTimeUser(boolean isFirstTimeUser) {
    mSharedPreferences.edit()
        .putBoolean(PREFERENCES_KEY_IS_FIRST_TIME_USER, isFirstTimeUser)
        .apply();
  }
}
