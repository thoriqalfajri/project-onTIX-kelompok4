package com.example.myapplication.ui.movie;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import retrofit2.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.myapplication.ApiClient;
import com.example.myapplication.ApiInterface;
import com.example.myapplication.Constant;
import com.example.myapplication.DetailMovieActivity;
import com.example.myapplication.Movie;
import com.example.myapplication.MovieAdapter;
import com.example.myapplication.MovieResponse;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MovieFragment extends Fragment implements MovieAdapter.ListItemClickListener {
    private List<Movie> list = new ArrayList<>();
    private RecyclerView rvMovie;
    private MovieAdapter movieAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_movie, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMovie = view.findViewById(R.id.rv_list);
    }

    @Override
    public void onStart() {
        super.onStart();
        movieAdapter = new MovieAdapter(getActivity());

        setLayout();
        getMovie();
    }

    private void setLayout(){
        rvMovie.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rvMovie.setHasFixedSize(true);
        rvMovie.setAdapter(movieAdapter);
    }

    private void getMovie() {
        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
        Call<MovieResponse> call = service.getMovie(Constant.API_KEY, "en-US");
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NonNull Call<MovieResponse> call, @NonNull Response<MovieResponse> response) {
                if (response.body() != null) {
                    MovieResponse apiResponse = response.body();
                    list = apiResponse.getResults();
                    movieAdapter.setListMovie(list, MovieFragment.this);
                    movieAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void onListItemClick(int clickedItemIndex, Movie movie) {
        movie = list.get(clickedItemIndex);

        Movie movies = new Movie();
        movies.setTitle(movie.getTitle());
        movies.setPoster(movie.getPoster());
        movies.setReleaseDate(movie.getReleaseDate());
        movies.setPopularity(movie.getPopularity());
        movies.setVoteAverage(movie.getVoteAverage());
        movies.setOverview(movie.getOverview());

        Intent intent = new Intent(getActivity(), DetailMovieActivity.class);
        intent.putExtra("poster", movie.getPoster());
        intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movies);
        startActivity(intent);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}