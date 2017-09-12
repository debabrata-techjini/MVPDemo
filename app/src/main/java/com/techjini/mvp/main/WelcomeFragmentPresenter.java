package com.techjini.mvp.main;

import com.techjini.mvp.data.DataManager;

/**
 * Listens to user actions or events from the UI of the welcome fragment, retrieves the data from
 * the database, network or shared preferences and then updates the UI as required.
 *
 * @author Debu
 */
public class WelcomeFragmentPresenter implements WelcomeFragmentContract.Presenter {

  private final DataManager mDataManager;
  private final WelcomeFragmentContract.View mWelcomeFragmentView;

  public WelcomeFragmentPresenter(DataManager dataManager,
      WelcomeFragmentContract.View welcomeFragmentView) {
    mDataManager = dataManager;
    mWelcomeFragmentView = welcomeFragmentView;

    mWelcomeFragmentView.setPresenter(this);
  }

  /**
   * It's called when the welcome fragment is started / resumed. It helps to perform tasks in the
   * presenter when the corresponding fragment is started / resumed (e.g. loading some initial
   * data).
   */
  @Override public void start() {
  }

  /**
   * It's called when the welcome fragment is created.
   */
  @Override public void onWelcomeFragmentCreated() {
    if (mDataManager.getIsFirstTimeUser()) {
      mWelcomeFragmentView.showWelcomeMessage();
      mDataManager.setIsFirstTimeUser(false);
    } else {
      mWelcomeFragmentView.showWelcomeBackMessage();
    }
  }
}
