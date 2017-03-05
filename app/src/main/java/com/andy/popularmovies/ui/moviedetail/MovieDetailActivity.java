package com.andy.popularmovies.ui.moviedetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.andy.popularmovies.R;
import com.andy.popularmovies.data.model.Movie;

public class MovieDetailActivity extends AppCompatActivity implements MovieDetailView {

    public static final String BUNDLE_MOVIE = "BUNDLE_MOVIE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
    }

    @Override
    public void showMovieDetails(Movie movie) {

    }
}
