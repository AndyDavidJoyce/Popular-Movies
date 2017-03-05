package com.andy.popularmovies.ui.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.andy.popularmovies.R;
import com.andy.popularmovies.data.model.Movie;
import com.andy.popularmovies.ui.moviedetail.MovieDetailActivity;

import java.util.List;

public class MoviesActivity extends AppCompatActivity implements MoviesView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        setUpPresenter();
        setUpMovieRecyclerView();
    }

    private void setUpPresenter() {

    }

    private void setUpMovieRecyclerView() {

    }

    @Override
    public void showLoading(boolean loading) {

    }

    @Override
    public void showMovies(List<Movie> movies) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void navigateToMovieDetail(Movie movie) {
        Intent intent = new Intent(this, MovieDetailActivity.class);
        intent.putExtra(MovieDetailActivity.BUNDLE_MOVIE, movie);
        startActivity(intent);
    }
}
