package com.example.parktaeim.subway.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.parktaeim.subway.Adapter.HoneyRankAdapter;
import com.example.parktaeim.subway.Model.HoneyRankItem;
import com.example.parktaeim.subway.R;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 16..
 */

public class HoneyRankActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private HoneyRankAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<HoneyRankItem> honeyRankItemArrayList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_honey_rank);

        recyclerView = (RecyclerView) findViewById(R.id.honeyRank_recyclerView);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        honeyRankItemArrayList.add(new HoneyRankItem("에그참치마요","에그 스크램블 + 핫소스+ 칠리 +후추 +토마토 + 베이컨 + 옥수수콘 + 슈레드치즈",4.2f,26,173,"닝라니ㅏ"));
        honeyRankItemArrayList.add(new HoneyRankItem("에그참치마요","ㄴㄹㄴ이ㅏㄹㄴㅇ",2.2f,26,173,"닝라니ㅏ"));
        honeyRankItemArrayList.add(new HoneyRankItem("에그참치마요","에그 스크램블 + 핫소스+ 칠리 +후추 +토마토 + 베이컨 + 옥수수콘 + 슈레드치즈",4.2f,26,173,"닝라니ㅏ"));
        honeyRankItemArrayList.add(new HoneyRankItem("에그참치마요","ㄴㄹㄴ이ㅏㄹㄴㅇ",1.6f,26,173,"닝라니ㅏ"));
        honeyRankItemArrayList.add(new HoneyRankItem("에그참치마요","ㄴㄹㄴ이ㅏㄹㄴㅇ",4.2f,26,173,"닝라니ㅏ"));
        honeyRankItemArrayList.add(new HoneyRankItem("에그참치마요","에그 스크램블 + 핫소스+ 칠리 +후추 +토마토 + 베이컨 + 옥수수콘 + 슈레드치즈",4.2f,26,173,"닝라니ㅏ"));
        honeyRankItemArrayList.add(new HoneyRankItem("에그참치마요","에그 스크램블 + 핫소스+ 칠리 +후추 +토마토 + 베이컨 + 옥수수콘 + 슈레드치즈",4.2f,26,173,"닝라니ㅏ"));
        honeyRankItemArrayList.add(new HoneyRankItem("에그참치마요","에그 스크램블 + 핫소스+ 칠리 +후추 +토마토 + 베이컨 + 옥수수콘 + 슈레드치즈",4.2f,26,173,"닝라니ㅏ"));
        honeyRankItemArrayList.add(new HoneyRankItem("에그참치마요","에그 스크램블 + 핫소스+ 칠리 +후추 +토마토 + 베이컨 + 옥수수콘 + 슈레드치즈",4.2f,26,173,"닝라니ㅏ"));


        adapter = new HoneyRankAdapter(honeyRankItemArrayList);
        recyclerView.setAdapter(adapter);


    }
}
