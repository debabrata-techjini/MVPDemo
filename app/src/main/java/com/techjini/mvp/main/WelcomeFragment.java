package com.techjini.mvp.main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.techjini.mvp.R;

/**
 * Shows "Welcome" to the first-time-user, otherwise shows "Welcome back".
 *
 * @author Debu
 */
public class WelcomeFragment extends Fragment implements WelcomeFragmentContract.View {

  private Activity mActivity;
  private WelcomeFragmentContract.Presenter mWelcomeFragmentPresenter;

  public WelcomeFragment() {
    // Required empty public constructor
  }

  public static WelcomeFragment newInstance() {
    return new WelcomeFragment();
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);

    mActivity = (Activity) context;
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_welcome, container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    mWelcomeFragmentPresenter.onWelcomeFragmentCreated();
  }

  @Override public void onResume() {
    super.onResume();

    mWelcomeFragmentPresenter.start();
  }

  /**
   * Shows welcome message to the first-time-user.
   */
  @Override public void showWelcomeMessage() {
    Toast.makeText(mActivity, R.string.welcome, Toast.LENGTH_SHORT).show();
  }

  /**
   * Shows welcome message to the user next time onwards (i.e. after the first time use).
   */
  @Override public void showWelcomeBackMessage() {
    Toast.makeText(mActivity, R.string.welcome_back, Toast.LENGTH_SHORT).show();
  }

  /**
   * Sets the presenter (which is called from the corresponding presenter class) to the view. The
   * welcome fragment uses this presenter to handle all the user actions and events.
   *
   * @param presenter the presenter to set to the view.
   */
  @Override public void setPresenter(WelcomeFragmentContract.Presenter presenter) {
    mWelcomeFragmentPresenter = presenter;
  }
}
