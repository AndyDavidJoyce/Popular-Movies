package com.andy.popularmovies.ui.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.andy.popularmovies.R;
import com.andy.popularmovies.data.model.Movie;
import com.andy.popularmovies.ui.moviedetail.MovieDetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesActivity extends AppCompatActivity implements MoviesView, OnMovieClickListener {

    @BindView(R.id.recycler_movies) RecyclerView moviesRecyclerView;
    @BindView(R.id.progress_movies) ProgressBar moviesProgressBar;

    //private MoviesPresenter moviesPresenter = new MoviesPresenter();
    private MoviesAdapter moviesAdapter = new MoviesAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        setUpPresenter();
        setUpMovieRecyclerView();
    }

    private void setUpPresenter() {
        //moviesPresenter.attachView(this);
    }

    private void setUpMovieRecyclerView() {
        moviesRecyclerView.setHasFixedSize(true);
        moviesRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        moviesRecyclerView.setAdapter(moviesAdapter);
    }

    @Override
    public void onMovieClicked(Movie movie) {
        //moviesPresenter.openMovieDetail(movie);
    }

    @Override
    public void showLoading(boolean loading) {
        moviesProgressBar.setVisibility(loading ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void showMovies(List<Movie> movies) {
        moviesAdapter.addMovies(movies);
    }

    @Override
    public void showError() {}

    @Override
    public void navigateToMovieDetail(Movie movie) {
        Intent intent = new Intent(this, MovieDetailActivity.class);
        intent.putExtra(MovieDetailActivity.BUNDLE_MOVIE, movie);
        startActivity(intent);
    }
}
