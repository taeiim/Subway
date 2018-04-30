package com.example.parktaeim.subway.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.parktaeim.subway.Adapter.ReviewAdapter;
import com.example.parktaeim.subway.Model.ReviewItem;
import com.example.parktaeim.subway.R;
import com.example.parktaeim.subway.SubwayAnimation;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 29..
 */

public class ReviewActivity extends AppCompatActivity {
    ToggleButton heartBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        ImageView backIcon = (ImageView) findViewById(R.id.review_backIcon);
        backIcon.setOnClickListener(v->finish());

        setUpProgressBar();
        setUpRecyclerView();
    }


    private void setUpRecyclerView() {
        ArrayList<ReviewItem> reviewItemArrayList = new ArrayList<>();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.review_recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        for (int i = 0; i < 10; i++) {
            reviewItemArrayList.add(new ReviewItem("dls", "태임태임", "2018.04.02", 4.0f, 22, "굉장히 맛있어요!! 근데 양파 안넣는게 더 맛있는 듯  하하하하 친구도 맛있다 그랬어요 다음에 와서 또 먹어야지"));
        }

        ReviewAdapter adapter = new ReviewAdapter(reviewItemArrayList);
        recyclerView.setAdapter(adapter);
    }

    private void setUpProgressBar() {
        int[] reviewCnt = {107, 42, 2, 0, 16}; // star 5,4,3,2,1

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

        ProgressBar[] progressBars = {score5progressBar, score4progressBar, score3progressBar, score2progressBar, score1progressBar};
        TextView[] starCntTvs = {star5cntTv, star4cntTv, star3cntTv, star2cntTv, star1cntTv};

        int max = 0;
        for (int i = 0; i < 5; i++) {
            if (reviewCnt[i] > max) max = reviewCnt[i];
        }

        for (int i = 0; i < 5; i++) {
            progressBars[i].setMax(max);
            progressBars[i].setProgress(reviewCnt[i]);
            starCntTvs[i].setText(String.valueOf(reviewCnt[i]));
        }
    }

}
