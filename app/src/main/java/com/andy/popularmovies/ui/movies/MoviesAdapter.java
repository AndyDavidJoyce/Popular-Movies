package com.andy.popularmovies.ui.movies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.andy.popularmovies.R;
import com.andy.popularmovies.data.model.Movie;
import com.andy.popularmovies.ui.base.BaseAdapter;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andrewjoyce on 04/03/2017.
 */

public class MoviesAdapter extends BaseAdapter<Movie, MoviesAdapter.MovieViewHolder> {

    private Context context;
    private OnMovieClickListener onMovieClickListener;

    public MoviesAdapter(Context context, OnMovieClickListener onMovieClickListener) {
        this.context = context;
        this.onMovieClickListener = onMovieClickListener;
    }

    @Override
    public MovieViewHolder onCreateCustomViewHolder(ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false));
    }

    @Override
    public void onBindCustomViewHolder(final MovieViewHolder holder, int position) {
        final Movie movie = getItemAtPosition(position);
        Picasso.with(holder.itemView.getContext()).load(movie.getPosterImageUrl()).into(holder.movieThumbNailImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMovieClickListener.onMovieClicked(movie);
            }
        });
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_movie_thumbnail) ImageView movieThumbNailImageView;

        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
