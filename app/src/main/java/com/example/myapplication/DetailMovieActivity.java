package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    private TextView tvTitle, tvReleaseDate, tvPopularity, tvVoteAverage, tvOverview;
    private ImageView ivPoster;
    private Button btnBuyTicket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        getSupportActionBar().setTitle("Movie");

        tvTitle = findViewById(R.id.tv_contentTitle);
        tvReleaseDate = findViewById(R.id.tv_contentReleaseDate);
        tvPopularity = findViewById(R.id.tv_contentPopularity);
        tvVoteAverage = findViewById(R.id.tv_contentVoteAverage);
        tvOverview = findViewById(R.id.tv_contentOverview);
        ivPoster = findViewById(R.id.iv_contentPoster);
        btnBuyTicket = findViewById(R.id.btn_buy_ticket);

        Movie movie = this.getIntent().getParcelableExtra(EXTRA_MOVIE);

        Intent intent = this.getIntent();

        tvTitle.setText(movie.getTitle());
        tvReleaseDate.setText(movie.getReleaseDate());
        tvPopularity.setText(movie.getPopularity());
        tvVoteAverage.setText(movie.getVoteAverage());
        tvOverview.setText(movie.getOverview());
        Picasso.with(DetailMovieActivity.this).load(Constant.IMAGE_URL + intent.getStringExtra("poster")).placeholder(R.mipmap.ic_launcher).into(ivPoster);
        btnBuyTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btn_buy_ticket) {
                    Intent moveIntent = new Intent(DetailMovieActivity.this, TicketActivity.class);
                    startActivity(moveIntent);
                }
            }
        });
    }
}