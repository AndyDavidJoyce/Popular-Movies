package com.andy.popularmovies.injection;

import com.andy.popularmovies.ui.movies.MoviesActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by andrewjoyce on 05/03/2017.
 */

@Singleton
@Component(modules = {NetModule.class})
public interface ApplicationComponent {
    void inject(MoviesActivity moviesActivity);
}
