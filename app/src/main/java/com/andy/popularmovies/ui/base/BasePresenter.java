package com.andy.popularmovies.ui.base;

/**
 * Created by andrewjoyce on 04/03/2017.
 */

public class BasePresenter<T extends MvpView> implements Presenter<T> {

    private T view;

    public T getMvpView() {
        return view;
    }

    public boolean isViewAttached() {
        return view != null;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new NullPointerException("No View is Attached");
    }

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
