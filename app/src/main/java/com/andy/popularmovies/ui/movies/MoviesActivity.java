package com.andy.popularmovies.ui.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.andy.popularmovies.PopularMoviesApplication;
import com.andy.popularmovies.R;
import com.andy.popularmovies.data.model.Category;
import com.andy.popularmovies.data.model.Movie;
import com.andy.popularmovies.ui.moviedetail.MovieDetailActivity;
import com.andy.popularmovies.ui.widgets.GridItemDecoration;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesActivity extends AppCompatActivity implements MoviesView, OnMovieClickListener {

    private final String STATE_POSITION = "STATE_POSITION";
    private final String STATE_CATEGORY = "STATE_CATEGORY";
    private final String STATE_MOVIES = "STATE_MOVIES";

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.recycler_movies) RecyclerView moviesRecyclerView;
    @BindView(R.id.progress_movies) ProgressBar moviesProgressBar;

    @Inject MoviesPresenter moviesPresenter;

    private Category category = Category.POPULAR;
    private ArrayList<Movie> movieList = new ArrayList<>();
    private MoviesAdapter moviesAdapter = new MoviesAdapter(this, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((PopularMoviesApplication)getApplication()).getComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        checkBundle(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_movies, menu);
        if (category == Category.POPULAR) {
            menu.getItem(0).setChecked(true);
        } else {
            menu.getItem(1).setChecked(true);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_sort_popularity) {
            category = Category.POPULAR;
        } else if (item.getItemId() == R.id.menu_sort_toprated ) {
            category = Category.TOPRATED;
        }

        item.setChecked(true);
        moviesPresenter.loadMoviesWithCategory(category);
        moviesRecyclerView.smoothScrollToPosition(0);
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(STATE_POSITION, moviesRecyclerView.getLayoutManager().onSaveInstanceState());
        outState.putParcelableArrayList(STATE_MOVIES, movieList);
        outState.putSerializable(STATE_CATEGORY, category);
    }

    private void checkBundle(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            moviesRecyclerView.getLayoutManager().onRestoreInstanceState(savedInstanceState.getParcelable(STATE_POSITION));
            category = (Category) savedInstanceState.getSerializable(STATE_CATEGORY);
            ArrayList<Movie> movies = savedInstanceState.getParcelableArrayList(STATE_MOVIES);
            moviesPresenter.setMovies(movies);
        } else {
            moviesPresenter.loadMoviesWithCategory(category);
        }
    }

    private void init() {
        setUpPresenter();
        setUpToolbar();
        setUpMovieRecyclerView();
    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.title_movies);
    }

    private void setUpPresenter() {
        moviesPresenter.attachView(this);
    }

    private void setUpMovieRecyclerView() {
        moviesRecyclerView.setLayoutManager(new GridLayoutManager(this, getResources().getInteger(R.integer.movie_column_count)));
        moviesRecyclerView.addItemDecoration(new GridItemDecoration(getResources().getInteger(R.integer.movie_column_count), 40, true));
        moviesRecyclerView.setAdapter(moviesAdapter);
        moviesRecyclerView.setHasFixedSize(true);
    }

    @Override
    public void showLoading(boolean loading) {
        moviesProgressBar.setVisibility(loading ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void showMovies(List<Movie> movies) {
        movieList = new ArrayList<Movie>(movies);
        moviesAdapter.setContent(movies);
    }

    @Override
    public void navigateToMovieDetail(Movie movie) {
        Intent intent = new Intent(this, MovieDetailActivity.class);
        intent.putExtra(MovieDetailActivity.EXTRA_MOVIE, movie);
        startActivity(intent);
    }

    @Override
    public void onMovieClicked(Movie movie) {
        moviesPresenter.openMovieDetails(movie);
    }
}
