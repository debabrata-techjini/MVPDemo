package com.techjini.mvp.data.network;

/**
 * @author Debu
 */
public class AppApiManager implements ApiManager {

  private static AppApiManager sAppApiManager;

  private AppApiManager() {
  }

  public static AppApiManager getInstance() {
    if (sAppApiManager == null) {
      sAppApiManager = new AppApiManager();
    }

    return sAppApiManager;
  }
}
