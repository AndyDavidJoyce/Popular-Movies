package com.andy.popularmovies.ui.movies;

/**
 * Created by andrewjoyce on 04/03/2017.
 */

import com.andy.popularmovies.data.model.Movie;
import com.andy.popularmovies.ui.base.MvpView;

import java.util.List;

interface MoviesView extends MvpView {

    void showLoading(boolean loading);
    void showMovies(List<Movie> movies);
    void showError();
    void navigateToMovieDetail(Movie movie);

}
