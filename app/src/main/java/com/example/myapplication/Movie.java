package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Movie implements Parcelable {
    @SerializedName("original_title")
    public String title;

    @SerializedName("poster_path")
    public String poster;

    @SerializedName("release_date")
    public String releaseDate;

    @SerializedName("popularity")
    public String popularity;

    @SerializedName("vote_average")
    public String voteAverage;

    @SerializedName("overview")
    public String overview;

    public Movie() {

    }

    protected Movie(Parcel in) {
        title = in.readString();
        poster = in.readString();
        releaseDate = in.readString();
        popularity = in.readString();
        voteAverage = in.readString();
        overview = in.readString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(poster);
        parcel.writeString(releaseDate);
        parcel.writeString(popularity);
        parcel.writeString(voteAverage);
        parcel.writeString(overview);
    }
}