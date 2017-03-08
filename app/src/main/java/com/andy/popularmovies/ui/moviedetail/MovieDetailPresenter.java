package com.andy.popularmovies.ui.moviedetail;

import com.andy.popularmovies.data.model.Movie;
import com.andy.popularmovies.ui.base.BasePresenter;

/**
 * Created by andrewjoyce on 05/03/2017.
 */

public class MovieDetailPresenter extends BasePresenter<MovieDetailView> {

    public void setMovie(Movie movie) {
        getMvpView().showMovieDetails(movie);
    }
    public void shareMovie(Movie movie) { getMvpView().showShareOptions(movie);}
}
