package com.andy.popularmovies.ui.movies;

import com.andy.popularmovies.data.model.Category;
import com.andy.popularmovies.data.model.Movie;
import com.andy.popularmovies.data.repository.MovieRepository;
import com.andy.popularmovies.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by andrewjoyce on 05/03/2017.
 */

public class MoviesPresenter extends BasePresenter<MoviesView> {

    private MovieRepository movieRepository;

    @Inject
    public MoviesPresenter(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void setMovies(ArrayList<Movie> movies) {
        getMvpView().showMovies(movies);
    }

    public void loadMoviesWithCategory(Category category) {
        switch(category) {
            case POPULAR:
                loadPopularMovies();
                break;
            case TOPRATED:
                loadTopRatedMovies();
                break;
        }
    }

    public void openMovieDetails(Movie movie) {
        getMvpView().navigateToMovieDetail(movie);
    }

    private void loadPopularMovies() {
        getMvpView().showLoading(true);
        movieRepository.loadPopularMovies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<List<Movie>>() {
                    @Override
                    public void onCompleted() {}

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            getMvpView().showLoading(false);
                        }
                    }

                    @Override
                    public void onNext(List<Movie> movies) {
                        if (isViewAttached()) {
                            getMvpView().showLoading(false);
                            getMvpView().showMovies(movies);
                        }
                    }
                });
    }

    private void loadTopRatedMovies() {
        getMvpView().showLoading(true);
        movieRepository.loadTopRatedMovies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<List<Movie>>() {
                    @Override
                    public void onCompleted() {}

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            getMvpView().showLoading(false);
                        }
                    }

                    @Override
                    public void onNext(List<Movie> movies) {
                        if (isViewAttached()) {
                            getMvpView().showLoading(false);
                            getMvpView().showMovies(movies);
                        }
                    }
                });
    }
}
