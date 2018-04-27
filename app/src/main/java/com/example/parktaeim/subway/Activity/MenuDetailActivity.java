package com.example.parktaeim.subway.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import com.example.parktaeim.subway.Adapter.MenuDetailStuffAdapter;
import com.example.parktaeim.subway.Model.MenuStuffItem;
import com.example.parktaeim.subway.R;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 22..
 */

public class MenuDetailActivity extends AppCompatActivity {
    private ArrayList<MenuStuffItem> menuStuffItemArrayList = new ArrayList<>();
    private ToggleButton heartBtn;
    private ImageView backIcon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);
        setUpHeartAnimation();

        backIcon = (ImageView) findViewById(R.id.menuDetail_backIcon);
        backIcon.setOnClickListener(v->finish());

        Intent getIntent = getIntent();
        String menuName = getIntent.getExtras().getString("menuName");
        String menuPrice = getIntent.getExtras().getString("menuPrice");

        Log.d("MenuName=="+menuName,"  / MenuPrice=="+menuPrice);

        setUpStuffRecyclerView();

    }

    private void setUpStuffRecyclerView() {
        RecyclerView stuffRecyclerView = (RecyclerView) findViewById(R.id.menuDetail_stuffRecyclerView);
        RecyclerView.LayoutManager stuffLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        stuffRecyclerView.setLayoutManager(stuffLayoutManager);

        menuStuffItemArrayList.add(new MenuStuffItem("dlkdslfk","햄 4장"));
        menuStuffItemArrayList.add(new MenuStuffItem("dlkdslfk","햄 4장"));
        menuStuffItemArrayList.add(new MenuStuffItem("dlkdslfk","햄 4장"));
        menuStuffItemArrayList.add(new MenuStuffItem("dlkdslfk","햄 4장"));
        menuStuffItemArrayList.add(new MenuStuffItem("dlkdslfk","햄 4장"));
        menuStuffItemArrayList.add(new MenuStuffItem("dlkdslfk","햄 4장"));

        MenuDetailStuffAdapter stuffAdapter = new MenuDetailStuffAdapter(menuStuffItemArrayList);
        stuffRecyclerView.setAdapter(stuffAdapter);
    }

    private void setUpHeartAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.7f, 1.0f, 0.7f, 1.0f, Animation.RELATIVE_TO_SELF, 0.7f, Animation.RELATIVE_TO_SELF, 0.7f);
        scaleAnimation.setDuration(500);
        BounceInterpolator bounceInterpolator = new BounceInterpolator();
        scaleAnimation.setInterpolator(bounceInterpolator);

        heartBtn = (ToggleButton) findViewById(R.id.menuDetail_heartBtn);
        heartBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                //animation
                compoundButton.startAnimation(scaleAnimation);
            }

        });
    }
}
