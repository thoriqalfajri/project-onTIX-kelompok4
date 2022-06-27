package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private Context context;
    private final List<Movie> listMovie = new ArrayList<>();
    private ListItemClickListener listItemClickListener;

    public MovieAdapter(Context context) {
        this.context = context;
    }

    public interface ListItemClickListener{
        void onListItemClick(int clickedItemIndex, Movie movie);
    }

    public void setListMovie(List<Movie> movieList, ListItemClickListener listItemClickListener){
        this.listMovie.clear();
        this.listMovie.addAll(movieList);
        this.listItemClickListener = listItemClickListener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final Movie movie = listMovie.get(position);

        holder.tvTitle.setText(movie.getTitle());
        Picasso.with(context).load(Constant.IMAGE_URL + movie.poster).placeholder(R.drawable.ic_launcher_background).fit().centerCrop().into(holder.ivPoster);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listItemClickListener.onListItemClick(position, movie);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        ImageView ivPoster;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            ivPoster = itemView.findViewById(R.id.iv_poster);
        }
    }
}