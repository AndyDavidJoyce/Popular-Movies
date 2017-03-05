package com.andy.popularmovies.data.remote;

import com.andy.popularmovies.data.model.MovieResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by andrewjoyce on 04/03/2017.
 */

public interface MoviesService {

    @GET("popular")
    Observable<MovieResponse> getPopularMovies();

    @GET("top_rated")
    Observable<MovieResponse> getTopRatedMovies();
}
