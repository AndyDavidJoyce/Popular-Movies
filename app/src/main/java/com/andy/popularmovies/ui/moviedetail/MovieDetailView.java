package com.andy.popularmovies.ui.moviedetail;

import com.andy.popularmovies.data.model.Movie;
import com.andy.popularmovies.ui.base.MvpView;

/**
 * Created by andrewjoyce on 05/03/2017.
 */

public interface MovieDetailView extends MvpView {
    void showMovieDetails(Movie movie);
    void showShareOptions(Movie movie);
}
