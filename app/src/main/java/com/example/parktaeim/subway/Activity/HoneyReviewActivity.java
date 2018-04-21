package com.example.parktaeim.subway.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.parktaeim.subway.R;

/**
 * Created by parktaeim on 2018. 4. 20..
 */

public class HoneyReviewActivity extends AppCompatActivity {
    private RatingBar ratingBar;
    private TextView ratingTv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        ratingBar = (RatingBar) findViewById(R.id.review_ratingBar);
        ratingTv = (TextView) findViewById(R.id.review_ratingTv);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingTv.setText(String.valueOf(rating));
            }
        });

    }
}
