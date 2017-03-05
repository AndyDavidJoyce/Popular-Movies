package com.andy.popularmovies.ui.movies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.andy.popularmovies.R;
import com.andy.popularmovies.data.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by andrewjoyce on 04/03/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private OnMovieClickListener movieClickListener;
    private List<Movie> movies = new ArrayList<>();

    public MoviesAdapter(OnMovieClickListener movieClickListener) {
        this.movieClickListener = movieClickListener;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        final Movie movie = movies.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {movieClickListener.onMovieClicked(movie);
            }
        });
        Picasso.with(holder.itemView.getContext()).load(movie.getPosterImageUrl()).into(holder.movieThumbNailImageView);
    }

    public void addMovies(List<Movie> movies) {
        this.movies.clear();
        this.movies.addAll(movies);
        notifyItemRangeChanged(0, movies.size());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        private ImageView movieThumbNailImageView;

        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
