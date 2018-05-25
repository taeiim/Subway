package com.example.parktaeim.subway.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.example.parktaeim.subway.Adapter.HoneyRankAdapter;
import com.example.parktaeim.subway.Model.HoneyAllItem;
import com.example.parktaeim.subway.R;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 16..
 */

public class HoneyRankActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private HoneyRankAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<HoneyAllItem> honeyRankItemArrayList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_honey_rank);

        setUpRecyclerView();

        ImageView backIcon = (ImageView) findViewById(R.id.honeyRank_backIcon);
        backIcon.setOnClickListener(v->finish());

    }

    private void setUpRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.honeyRank_recyclerView);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i < 10; i++) {
            honeyRankItemArrayList.add(new HoneyAllItem("에그참치마요", "에그 스크램블 + 핫소스+ 칠리 +후추 +토마토 + 베이컨", "dlskfsd"));
            honeyRankItemArrayList.add(new HoneyAllItem("에그참치마요", "에그 스크램블 + 핫소스+ 칠리 +후추 +토마토 + 베이컨 + 옥수수콘 + 슈레드치즈", "dlskfsd"));
            honeyRankItemArrayList.add(new HoneyAllItem("에그참치마요", "에그 스크램블 + 핫소스+ 칠리 +후추 +토마토 + 베이컨 + 옥수수콘 + 슈레드치즈 + 베이컨 + 옥수수콘 + 슈레드치즈", "dlskfsd"));
        }

        adapter = new HoneyRankAdapter(honeyRankItemArrayList);
        recyclerView.setAdapter(adapter);

    }
}
