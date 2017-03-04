package com.andy.popularmovies.data;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by andrewjoyce on 04/03/2017.
 */

public interface MoviesService {

    @GET("/popular")
    Observable<String> getPopularMovies();

    @GET("/popular")
    Observable<String> getTopRatedMovies();
}
