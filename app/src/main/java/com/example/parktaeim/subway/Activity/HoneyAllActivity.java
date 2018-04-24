package com.example.parktaeim.subway.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.parktaeim.subway.Adapter.HoneyAllAdapter;
import com.example.parktaeim.subway.Adapter.SpinnerAdapter;
import com.example.parktaeim.subway.Model.HoneyAllItem;
import com.example.parktaeim.subway.R;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 23..
 */

public class HoneyAllActivity extends AppCompatActivity {
    private ArrayList<HoneyAllItem> honeyAllItemArrayList = new ArrayList<>();
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
        setContentView(R.layout.activity_honey_all);

        ImageView backIcon = (ImageView) findViewById(R.id.honeyAll_backIcon);
        backIcon.setOnClickListener(v->finish());

        setUpRecyclerView();
        setUpSpinner();
    }

    private void setUpSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.honeyAll_spinner);
        ArrayList<String> spinnerData = new ArrayList<>();
        spinnerData.add("최신순"); spinnerData.add("인기순"); spinnerData.add("별점순"); spinnerData.add("후기많은순");

        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(getApplicationContext(),spinnerData);
        spinner.setAdapter(spinnerAdapter);
    }

    private void setUpRecyclerView() {
        recyclerViewGrid = (RecyclerView) findViewById(R.id.menuAll_recyclerViewGrid);
        recyclerViewLinear = (RecyclerView) findViewById(R.id.menuAll_recyclerViewLinear);
        gridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        gridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewGrid.setLayoutManager(gridLayoutManager);
        recyclerViewLinear.setLayoutManager(linearLayoutManager);
        recyclerViewGrid.setHasFixedSize(true);

        for(int i=0;i<11;i++){
            honeyAllItemArrayList.add(new HoneyAllItem("에그참치마요","4900원","에그 스크램블 + 핫소스+ 칠리 +후추 +토마토 + 베이컨 + 옥수수콘 + 슈레드치즈..",4.0f,4,32,"dlsfkj"));
            honeyAllItemArrayList.add(new HoneyAllItem("에그참치마요","4900원","에그 스크램+ 슈레드치즈..",4.0f,4,32,"dlsfkj"));
            honeyAllItemArrayList.add(new HoneyAllItem("에그참치마요","4900원","에그 스크램블 + 핫소스+ 칠리 +후추 +토마토 + 베이컨 + 옥수수콘 ",4.0f,4,32,"dlsfkj"));
        }

        gridAdapter = new HoneyAllAdapter(honeyAllItemArrayList,1);
        linearAdapter = new HoneyAllAdapter(honeyAllItemArrayList,2);
        recyclerViewGrid.setAdapter(gridAdapter);
        recyclerViewLinear.setAdapter(linearAdapter);


        changeRecycleIcon = (ImageView) findViewById(R.id.honeyAll_recyclerChangeIcon);
        changeRecycleIcon.setOnClickListener(v->{
            if(isGrid){
                recyclerViewGrid.setVisibility(View.GONE);
                recyclerViewLinear.setVisibility(View.VISIBLE);
                isGrid = false;
                changeRecycleIcon.setImageResource(R.drawable.ic_grid_recycle);
            } else{
                recyclerViewGrid.setVisibility(View.VISIBLE);
                recyclerViewLinear.setVisibility(View.GONE);
                isGrid = true;
                changeRecycleIcon.setImageResource(R.drawable.ic_linear_recycle);
            }
        });

    }
}
