package com.andy.popularmovies.ui.movies;

import com.andy.popularmovies.data.model.Movie;
import com.andy.popularmovies.ui.base.MvpView;

import java.util.List;

/**
 * Created by andrewjoyce on 04/03/2017.
 */

interface MoviesView extends MvpView {
    void showLoading(boolean loading);
    void showMovies(List<Movie> movies);
    void navigateToMovieDetail(Movie movie);
}
