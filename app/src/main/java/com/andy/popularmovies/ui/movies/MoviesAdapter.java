package com.andy.popularmovies.ui.movies;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.andy.popularmovies.data.model.Movie;

import java.util.List;

/**
 * Created by andrewjoyce on 04/03/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movies;

    public MoviesAdapter() {}

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return movies == null ? 0 : movies.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        public MovieViewHolder(View itemView) {
            super(itemView);
        }
    }
}
