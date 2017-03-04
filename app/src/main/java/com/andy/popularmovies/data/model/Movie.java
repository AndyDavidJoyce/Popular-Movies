package com.andy.popularmovies.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by andrewjoyce on 04/03/2017.
 */

public class Movie implements Parcelable {


    private String id;
    private String title;
    private String overview;
    private String popularity;
    @SerializedName("vote_count")
    private String voteCount;
    @SerializedName("poster_path")
    private String posterImageUrl;
    @SerializedName("adult")
    private boolean adult;

    public Movie() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterImageUrl() {
        return posterImageUrl;
    }

    public void setPosterImageUrl(String posterImageUrl) {
        this.posterImageUrl = posterImageUrl;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(String voteCount) {
        this.voteCount = voteCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.overview);
        dest.writeString(this.title);
        dest.writeString(this.popularity);
        dest.writeString(this.voteCount);
        dest.writeString(this.posterImageUrl);
        dest.writeByte(this.adult ? (byte) 1 : (byte) 0);
    }

    protected Movie(Parcel in) {
        this.id = in.readString();
        this.overview = in.readString();
        this.title = in.readString();
        this.popularity = in.readString();
        this.voteCount = in.readString();
        this.posterImageUrl = in.readString();
        this.adult = in.readByte() != 0;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
