package com.andy.popularmovies.ui.base;

/**
 * Created by andrewjoyce on 04/03/2017.
 */

public interface Presenter<T extends MvpView> {
    void attachView(T view);
    void detachView();
}
