package com.andy.popularmovies.ui.moviedetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.andy.popularmovies.R;

public class MovieDetailActivity extends AppCompatActivity {

    private static final String BUNDLE_MOVIE = "BUNDLE_MOVIE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
    }


}
