package com.example.parktaeim.subway.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.parktaeim.subway.Adapter.ReviewAdapter;
import com.example.parktaeim.subway.Model.ReviewItem;
import com.example.parktaeim.subway.R;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 24..
 */

public class HoneyDetailReviewFragment extends Fragment {
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_honeydetail_review, container,false);

        setUpProgressBar();
        setUpRecyclerView();

        return rootView;
    }

    private void setUpRecyclerView() {
        ArrayList<ReviewItem> reviewItemArrayList = new ArrayList<>();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.honeyReview_recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);

        for (int i = 0; i < 10; i++) {
            reviewItemArrayList.add(new ReviewItem("dls", "태임태임", "2018.04.02", 4.0f, 22, "굉장히 맛있어요!! 근데 양파 안넣는게 더 맛있는 듯  하하하하 친구도 맛있다 그랬어요 다음에 와서 또 먹어야지"));
        }

        ReviewAdapter adapter = new ReviewAdapter(reviewItemArrayList);
        recyclerView.setAdapter(adapter);
    }

    private void setUpProgressBar() {
        int[] reviewCnt = {107, 42, 2, 0, 16}; // star 5,4,3,2,1

        ProgressBar score5progressBar = (ProgressBar) rootView.findViewById(R.id.honeyReview_score5progressBar);
        ProgressBar score4progressBar = (ProgressBar) rootView.findViewById(R.id.honeyReview_score4progressBar);
        ProgressBar score3progressBar = (ProgressBar) rootView.findViewById(R.id.honeyReview_score3progressBar);
        ProgressBar score2progressBar = (ProgressBar) rootView.findViewById(R.id.honeyReview_score2progressBar);
        ProgressBar score1progressBar = (ProgressBar) rootView.findViewById(R.id.honeyReview_score1progressBar);

        TextView star5cntTv = (TextView) rootView.findViewById(R.id.honeyReview_star5cntTv);
        TextView star4cntTv = (TextView) rootView.findViewById(R.id.honeyReview_star4cntTv);
        TextView star3cntTv = (TextView) rootView.findViewById(R.id.honeyReview_star3cntTv);
        TextView star2cntTv = (TextView) rootView.findViewById(R.id.honeyReview_star2cntTv);
        TextView star1cntTv = (TextView) rootView.findViewById(R.id.honeyReview_star1cntTv);

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
