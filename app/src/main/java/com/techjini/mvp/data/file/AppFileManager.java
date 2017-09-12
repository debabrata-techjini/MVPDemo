package com.techjini.mvp.data.file;

/**
 * @author Debu
 */
public class AppFileManager implements FileManager {

  private static AppFileManager sAppFileManager;

  private AppFileManager() {
  }

  public static AppFileManager getInstance() {
    if (sAppFileManager == null) {
      sAppFileManager = new AppFileManager();
    }

    return sAppFileManager;
  }
}
