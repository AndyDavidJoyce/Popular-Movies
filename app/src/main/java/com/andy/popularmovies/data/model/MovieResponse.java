package com.andy.popularmovies.data.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by andrewjoyce on 04/03/2017.
 */

public class MovieResponse {

    @SerializedName("results")
    private List<Movie> movies;
    @SerializedName("total_results")
    private int results;
    @SerializedName("total_pages")
    private int pages;

    public MovieResponse() {}

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }
}

