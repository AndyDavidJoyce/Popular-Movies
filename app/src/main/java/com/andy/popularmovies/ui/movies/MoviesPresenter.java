package com.andy.popularmovies.ui.movies;

import com.andy.popularmovies.data.model.Movie;
import com.andy.popularmovies.data.repository.MovieRepository;
import com.andy.popularmovies.ui.base.BasePresenter;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by andrewjoyce on 05/03/2017.
 */

public class MoviesPresenter extends BasePresenter<MoviesView> {

    private MovieRepository movieRepository;

    public MoviesPresenter(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void loadPopularMovies() {
        getMvpView().showLoading(true);
        movieRepository.loadPopularMovies()
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<List<Movie>>() {
                    @Override
                    public void onCompleted() {}

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            getMvpView().showLoading(false);
                            getMvpView().showError();
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

    public void loadTopRatedMovies() {
        getMvpView().showLoading(true);
        movieRepository.loadTopRatedMovies()
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<List<Movie>>() {
                    @Override
                    public void onCompleted() {}

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            getMvpView().showLoading(false);
                            getMvpView().showError();
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

    public void openMovieDetail(Movie movie) {
        getMvpView().navigateToMovieDetail(movie);
    }
}
