package com.example.parktaeim.subway.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.parktaeim.subway.R;

/**
 * Created by parktaeim on 2018. 4. 29..
 */

public class ReviewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        ImageView backIcon = (ImageView) findViewById(R.id.review_backIcon);
        backIcon.setOnClickListener(v->finish());

        setUpProgressBar();
    }

    private void setUpProgressBar() {
        int[] reviewCnt = {107,42,2,0,16}; // star 5,4,3,2,1

        ProgressBar score5progressBar = (ProgressBar) findViewById(R.id.score5progressBar);
        ProgressBar score4progressBar = (ProgressBar) findViewById(R.id.score4progressBar);
        ProgressBar score3progressBar = (ProgressBar) findViewById(R.id.score3progressBar);
        ProgressBar score2progressBar = (ProgressBar) findViewById(R.id.score2progressBar);
        ProgressBar score1progressBar = (ProgressBar) findViewById(R.id.score1progressBar);

        TextView star5cntTv = (TextView) findViewById(R.id.star5cntTv);
        TextView star4cntTv = (TextView) findViewById(R.id.star4cntTv);
        TextView star3cntTv = (TextView) findViewById(R.id.star3cntTv);
        TextView star2cntTv = (TextView) findViewById(R.id.star2cntTv);
        TextView star1cntTv = (TextView) findViewById(R.id.star1cntTv);

        ProgressBar[] progressBars = {score5progressBar,score4progressBar,score3progressBar,score2progressBar,score1progressBar};
        TextView[] starCntTvs = {star5cntTv,star4cntTv,star3cntTv,star2cntTv,star1cntTv};

        int max = 0;
        for(int i=0; i<5 ;i++){
            if(reviewCnt[i] > max)  max = reviewCnt[i];
        }

        for(int i=0; i<5; i++){
            progressBars[i].setMax(max);
            progressBars[i].setProgress(reviewCnt[i]);
            starCntTvs[i].setText(String.valueOf(reviewCnt[i]));
        }
    }
}
