package com.andy.popularmovies.data.repository;

import com.andy.popularmovies.data.model.Movie;
import com.andy.popularmovies.data.model.MovieResponse;
import com.andy.popularmovies.data.remote.MoviesService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by andrewjoyce on 04/03/2017.
 */

public class MovieRepository {

    private MoviesService moviesService;

    @Inject
    public MovieRepository(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    public Observable<List<Movie>> loadTopRatedMovies() {
        return moviesService.getTopRatedMovies()
                .map(new Func1<MovieResponse, List<Movie>>() {
                    @Override
                    public List<Movie> call(MovieResponse movieResponse) {
                        return movieResponse.getMovies();
                    }
                });
    }

    public Observable<List<Movie>> loadPopularMovies() {
        return moviesService.getPopularMovies()
                .map(new Func1<MovieResponse, List<Movie>>() {
                    @Override
                    public List<Movie> call(MovieResponse movieResponse) {
                        return movieResponse.getMovies();
                    }
                });
    }
}
