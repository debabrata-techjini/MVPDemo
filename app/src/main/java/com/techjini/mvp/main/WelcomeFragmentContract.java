package com.techjini.mvp.main;

import com.techjini.mvp.base.BasePresenter;
import com.techjini.mvp.base.BaseView;

/**
 * It specifies the contract between the view and the presenter of the welcome fragment.
 *
 * @author Debu
 */
public interface WelcomeFragmentContract {

  /**
   * It specifies all the methods to update the UI in the welcome fragment.
   */
  interface View extends BaseView<Presenter> {

    /**
     * Shows welcome message to the first-time-user.
     */
    void showWelcomeMessage();

    /**
     * Shows welcome message to the user next time onwards (i.e. after the first time use).
     */
    void showWelcomeBackMessage();
  }

  /**
   * It specifies all the methods to listen to user actions or events from the UI of the welcome
   * fragment or methods to fetch data from the database, network or shared preferences.
   */
  interface Presenter extends BasePresenter {

    /**
     * It's called when the welcome fragment is created.
     */
    void onWelcomeFragmentCreated();
  }
}
