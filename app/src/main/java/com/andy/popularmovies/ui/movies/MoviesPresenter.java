package com.andy.popularmovies.ui.movies;

import com.andy.popularmovies.data.model.Movie;
import com.andy.popularmovies.ui.base.BasePresenter;

/**
 * Created by andrewjoyce on 05/03/2017.
 */

public class MoviesPresenter extends BasePresenter<MoviesView> {

    public MoviesPresenter() {}

    public void loadPopularMovies() {

    }

    public void loadTopRatedMovies() {

    }

    public void openMovieDetail(Movie movie) {
        getMvpView().navigateToMovieDetail(movie);
    }
}
