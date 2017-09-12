package com.techjini.mvp.data.preferences;

/**
 * It specifies abstract methods to read from and write to the shared preferences.
 *
 * @author Debu
 */
public interface PreferencesManager {

  /**
   * Gets the is-first-time-user value from the preferences.
   *
   * @return true if the user is a first-time-user.
   */
  boolean getIsFirstTimeUser();

  /**
   * Sets the is-first-time-user value to the preferences.
   *
   * @param isFirstTimeUser whether the user is a first-time-user
   */
  void setIsFirstTimeUser(boolean isFirstTimeUser);
}
