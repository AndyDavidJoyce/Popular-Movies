package com.andy.popularmovies.ui.moviedetail;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.andy.popularmovies.R;
import com.andy.popularmovies.data.model.Movie;
import com.andy.popularmovies.ui.widgets.SquareImageView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailActivity extends AppCompatActivity implements MovieDetailView {

    public static final String EXTRA_MOVIE = "EXTRA_MOVIE";

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.toolbarCollapseLayout) CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.imageMovieBackdrop) SquareImageView movieBackdropImageView;
    @BindView(R.id.fab_moviedetail_share) FloatingActionButton shareMovieFab;
    @BindView(R.id.text_moviedetail_release) TextView movieReleaseTextView;
    @BindView(R.id.text_moviedetail_votecount) TextView movieVoteCountTextView;
    @BindView(R.id.text_moviedetail_description) TextView movieDescriptionTextView;

    private MovieDetailPresenter movieDetailPresenter = new MovieDetailPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        setUpToolbar();
        setUpPresenter();
        getIntentExtras();
    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setUpPresenter() {
        movieDetailPresenter.attachView(this);
    }

    private void getIntentExtras() {
        if (getIntent().hasExtra(EXTRA_MOVIE)) movieDetailPresenter.setMovie((Movie)getIntent().getParcelableExtra(EXTRA_MOVIE));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        supportFinishAfterTransition();
        return true;
    }

    @Override
    public void showMovieDetails(final Movie movie) {
        getSupportActionBar().setTitle(movie.getTitle());
        Picasso.with(this).load(movie.getPosterImageUrl()).into(movieBackdropImageView);
        collapsingToolbarLayout.setTitleEnabled(false);
        movieReleaseTextView.setText(String.format(getString(R.string.movie_releasedate_text), movie.getRelease()));
        movieVoteCountTextView.setText(String.format(getString(R.string.movie_votecount_text), movie.getVoteCount()));
        movieDescriptionTextView.setText(movie.getOverview());
        shareMovieFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movieDetailPresenter.shareMovie(movie);
            }
        });
    }

    @Override
    public void showShareOptions(Movie movie) {
        try {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(android.content.Intent.EXTRA_TEXT, String.format(getString(R.string.movie_share_content), movie.getTitle(), movie.getOverview(), movie.getRelease(), movie.getVoteCount()));
            startActivity(Intent.createChooser(intent, getString(R.string.title_share_movie)));
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }
}
