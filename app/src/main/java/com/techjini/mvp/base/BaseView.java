package com.techjini.mvp.base;

/**
 * It's the base interface that any view (activity, fragment, etc.) that wants to act as a view in
 * the MVP pattern must implement.
 *
 * @author Debu
 */
public interface BaseView<T extends BasePresenter> {

  void setPresenter(T presenter);
}
