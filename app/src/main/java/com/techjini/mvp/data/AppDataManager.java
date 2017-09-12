package com.techjini.mvp.data;

import com.techjini.mvp.data.database.AppDatabaseManager;
import com.techjini.mvp.data.file.FileManager;
import com.techjini.mvp.data.network.AppApiManager;
import com.techjini.mvp.data.preferences.AppPreferencesManager;

/**
 * It is the one point of contact for any data related operation in the application. It delegates
 * the services provided by different data providers - database, network and preferences.
 *
 * @author Debu
 */
public class AppDataManager implements DataManager {

  private static AppDataManager sAppDataManager;
  private final AppDatabaseManager mAppDatabaseManager;
  private final AppApiManager mAppApiManager;
  private final AppPreferencesManager mAppPreferencesManager;
  private final FileManager mFileManager;

  private AppDataManager(AppDatabaseManager appDatabaseManager, AppApiManager appApiManager,
      AppPreferencesManager appPreferencesManager, FileManager fileManager) {
    mAppDatabaseManager = appDatabaseManager;
    mAppApiManager = appApiManager;
    mAppPreferencesManager = appPreferencesManager;
    mFileManager = fileManager;
  }

  public static AppDataManager getInstance(AppDatabaseManager appDatabaseManager,
      AppApiManager appApiManager, AppPreferencesManager appPreferencesManager,
      FileManager fileManager) {
    if (sAppDataManager == null) {
      sAppDataManager =
          new AppDataManager(appDatabaseManager, appApiManager, appPreferencesManager, fileManager);
    }

    return sAppDataManager;
  }

  @Override public boolean getIsFirstTimeUser() {
    return mAppPreferencesManager.getIsFirstTimeUser();
  }

  @Override public void setIsFirstTimeUser(boolean isFirstTimeUser) {
    mAppPreferencesManager.setIsFirstTimeUser(isFirstTimeUser);
  }
}
