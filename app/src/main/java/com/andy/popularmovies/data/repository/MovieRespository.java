package com.andy.popularmovies.data.repository;

import com.andy.popularmovies.data.model.Movie;

import java.util.List;

import rx.Observable;

/**
 * Created by andrewjoyce on 04/03/2017.
 */

public interface MovieRespository {
    Observable<List<Movie>> getPopularMovies();
    Observable<List<Movie>> getTopRatedMovies();
}
