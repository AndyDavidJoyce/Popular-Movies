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
    @SerializedName("backdrop_path")
    private String backdrop;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("release_date")
    private String release;

    public Movie() {}

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop() {
        return "http://image.tmdb.org/t/p/w500/" + backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getPosterImageUrl() {
        return "http://image.tmdb.org/t/p/w185/" + posterImageUrl;
    }

    public void setPosterImageUrl(String posterImageUrl) {
        this.posterImageUrl = posterImageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(String voteCount) {
        this.voteCount = voteCount;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }



    @Override
    public String toString() {
        return "Movie{" +
                "adult=" + adult +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity='" + popularity + '\'' +
                ", voteCount='" + voteCount + '\'' +
                ", posterImageUrl='" + posterImageUrl + '\'' +
                ", backdrop='" + backdrop + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.overview);
        dest.writeString(this.popularity);
        dest.writeString(this.voteCount);
        dest.writeString(this.posterImageUrl);
        dest.writeString(this.backdrop);
        dest.writeByte(this.adult ? (byte) 1 : (byte) 0);
        dest.writeString(this.release);
    }

    protected Movie(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.overview = in.readString();
        this.popularity = in.readString();
        this.voteCount = in.readString();
        this.posterImageUrl = in.readString();
        this.backdrop = in.readString();
        this.adult = in.readByte() != 0;
        this.release = in.readString();
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
