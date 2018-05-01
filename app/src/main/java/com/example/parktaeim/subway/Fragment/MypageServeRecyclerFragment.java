package com.example.parktaeim.subway.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.parktaeim.subway.Adapter.HoneyAllAdapter;
import com.example.parktaeim.subway.Model.HoneyAllItem;
import com.example.parktaeim.subway.R;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 5. 1..
 */

public class MypageServeRecyclerFragment extends Fragment {
    private View rootView;

    private ArrayList<HoneyAllItem> honeyAllItemArrayList = new ArrayList<>();
    private boolean isGrid = true;

    private RecyclerView recyclerView;
    private HoneyAllAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_mypage_serve_recycler,container,false);
        setUpRecyclerView();

        return rootView;
    }

    private void setUpRecyclerView() {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.mypageServe_recyclerView);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        for (int i = 0; i < 11; i++) {
            honeyAllItemArrayList.add(new HoneyAllItem("에그참치마요", "4900원", "에그 스크램블 + 핫소스+ 칠리 +후추 +토마토 + 베이컨 + 옥수수콘 + 슈레드치즈..", 4.0f, 4, 32, "dlsfkj"));
            honeyAllItemArrayList.add(new HoneyAllItem("에그참치마요", "4900원", "에그 스크램+ 슈레드치즈..", 4.0f, 4, 32, "dlsfkj"));
            honeyAllItemArrayList.add(new HoneyAllItem("에그참치마요", "4900원", "에그 스크램블 + 핫소스+ 칠리 +후추 +토마토 + 베이컨 + 옥수수콘 ", 4.0f, 4, 32, "dlsfkj"));
        }

        adapter = new HoneyAllAdapter(honeyAllItemArrayList, 2, getContext());
        recyclerView.setAdapter(adapter);


    }
}
