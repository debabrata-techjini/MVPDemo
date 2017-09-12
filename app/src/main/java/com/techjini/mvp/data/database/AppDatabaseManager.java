package com.techjini.mvp.data.database;

/**
 * @author Debu
 */
public class AppDatabaseManager implements DatabaseManager {

  private static AppDatabaseManager sAppDatabaseManager;

  private AppDatabaseManager() {
  }

  public static AppDatabaseManager getInstance() {
    if (sAppDatabaseManager == null) {
      sAppDatabaseManager = new AppDatabaseManager();
    }

    return sAppDatabaseManager;
  }
}
