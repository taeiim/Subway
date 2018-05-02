package com.example.parktaeim.subway.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.example.parktaeim.subway.Adapter.HoneyAllAdapter;
import com.example.parktaeim.subway.Model.HoneyAllItem;
import com.example.parktaeim.subway.R;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 5. 2..
 */

public class RelateHoneyActivity extends AppCompatActivity {
    private ArrayList<HoneyAllItem> relateHoneyItemArrayList = new ArrayList<>();
    private boolean isGrid = true;

    private RecyclerView recyclerViewGrid;
    private RecyclerView recyclerViewLinear;
    private HoneyAllAdapter gridAdapter;
    private HoneyAllAdapter linearAdapter;
    private StaggeredGridLayoutManager gridLayoutManager;
    private RecyclerView.LayoutManager linearLayoutManager;
    private ImageView changeRecycleIcon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatehoney);

        setUpRecyclerView();

    }

    private void setUpRecyclerView() {
        recyclerViewGrid = (RecyclerView) findViewById(R.id.relateHoney_recyclerViewGrid);
        recyclerViewLinear = (RecyclerView) findViewById(R.id.relateHoney_recyclerViewLinear);
        gridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        gridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewGrid.setLayoutManager(gridLayoutManager);
        recyclerViewLinear.setLayoutManager(linearLayoutManager);
        recyclerViewGrid.setHasFixedSize(true);

        for (int i = 0; i < 11; i++) {
            relateHoneyItemArrayList.add(new HoneyAllItem("에그참치마요", "4900원", "에그 스크램블 + 핫소스+ 칠리 +후추 +토마토 + 베이컨 + 옥수수콘 + 슈레드치즈..", 4.0f, 4, 32, "dlsfkj"));
            relateHoneyItemArrayList.add(new HoneyAllItem("에그참치마요", "4900원", "에그 스크램+ 슈레드치즈..", 4.0f, 4, 32, "dlsfkj"));
            relateHoneyItemArrayList.add(new HoneyAllItem("에그참치마요", "4900원", "에그 스크램블 + 핫소스+ 칠리 +후추 +토마토 + 베이컨 + 옥수수콘 ", 4.0f, 4, 32, "dlsfkj"));
        }

        gridAdapter = new HoneyAllAdapter(relateHoneyItemArrayList, 1, this);
        linearAdapter = new HoneyAllAdapter(relateHoneyItemArrayList, 2, this);
        recyclerViewGrid.setAdapter(gridAdapter);
        recyclerViewLinear.setAdapter(linearAdapter);


        changeRecycleIcon = (ImageView) findViewById(R.id.relateHoney_recyclerChangeIcon);
        changeRecycleIcon.setOnClickListener(v -> {
            if (isGrid) {
                recyclerViewGrid.setVisibility(View.GONE);
                recyclerViewLinear.setVisibility(View.VISIBLE);
                isGrid = false;
                changeRecycleIcon.setImageResource(R.drawable.ic_grid_recycle);
            } else {
                recyclerViewGrid.setVisibility(View.VISIBLE);
                recyclerViewLinear.setVisibility(View.GONE);
                isGrid = true;
                changeRecycleIcon.setImageResource(R.drawable.ic_linear_recycle);
            }
        });
    }
}
