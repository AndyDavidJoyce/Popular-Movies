package com.andy.popularmovies.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andy.popularmovies.data.Movie;

import java.util.List;

/**
 * Created by Andy on 09/02/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movie> movieList;

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(0, parent, false));
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
    }

    @Override
    public int getItemCount() {
        return movieList == null ? 0 : movieList.size();
    }

    public void setMovies(List<Movie> movies) {

    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        public MovieViewHolder(View itemView) {
            super(itemView);
        }

        public void bindMovie(Movie movie) {

        }
    }

}
