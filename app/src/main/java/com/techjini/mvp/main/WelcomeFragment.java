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
import com.techjini.mvp.data.preferences.PreferencesManager;
import com.techjini.mvp.util.AppConstants;

/**
 * @author Debu
 */
public class WelcomeFragment extends Fragment {

  private Activity mActivity;
  private PreferencesManager mPreferencesManager;

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
    mPreferencesManager = new PreferencesManager(mActivity, AppConstants.PREFERENCES_FILE_NAME);
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_welcome, container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    showWelcomeMessage();
  }

  private void showWelcomeMessage() {
    int welcomeMessageResource;

    if (mPreferencesManager.getIsFirstTimeUser()) {
      welcomeMessageResource = R.string.welcome;
      mPreferencesManager.setIsFirstTimeUser(false);
    } else {
      welcomeMessageResource = R.string.welcome_back;
    }

    Toast.makeText(mActivity, welcomeMessageResource, Toast.LENGTH_SHORT).show();
  }
}
