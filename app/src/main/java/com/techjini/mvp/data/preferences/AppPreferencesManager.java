package com.techjini.mvp.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author Debu
 */
public class AppPreferencesManager {

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

  public boolean getIsFirstTimeUser() {
    return mSharedPreferences.getBoolean(PREFERENCES_KEY_IS_FIRST_TIME_USER, true);
  }

  public void setIsFirstTimeUser(boolean isFirstTimeUser) {
    mSharedPreferences.edit()
        .putBoolean(PREFERENCES_KEY_IS_FIRST_TIME_USER, isFirstTimeUser)
        .apply();
  }
}
