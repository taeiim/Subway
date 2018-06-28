package com.example.parktaeim.subway.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
    private FloatingActionButton reviewFab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);

        setUpHeartAnimation();
        setUpStuffRecyclerView();

        Intent getIntent = getIntent();
        String menuName = getIntent.getExtras().getString("menuName");
        String menuPrice = getIntent.getExtras().getString("menuPrice");
        Log.d("MenuName=="+menuName,"  / MenuPrice=="+menuPrice);

        RelativeLayout reviewLayout = (RelativeLayout) findViewById(R.id.menuDetail_reviewLayout);
        reviewLayout.setOnClickListener(v->startActivity(new Intent(this,ReviewActivity.class)));

        RelativeLayout relateLayout = (RelativeLayout) findViewById(R.id.menuDetail_relateHoneyLayout);
        relateLayout.setOnClickListener(v->startActivity(new Intent(this, RelateHoneyActivity.class)));

        backIcon = (ImageView) findViewById(R.id.menuDetail_backIcon);
        backIcon.setOnClickListener(v->finish());

        reviewFab = (FloatingActionButton) findViewById(R.id.menuDetail_reviewFab);
        reviewFab.setOnClickListener(v->{
            Intent intent = new Intent(this,ReviewWriteActivity.class);
            intent.putExtra("reviewType",0);
            startActivity(intent);
        });

    }

    private void setUpStuffRecyclerView() {
        RecyclerView stuffRecyclerView = (RecyclerView) findViewById(R.id.menuDetail_stuffRecyclerView);
        RecyclerView.LayoutManager stuffLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        stuffRecyclerView.setLayoutManager(stuffLayoutManager);

        int[] stuffImgArr = {R.drawable.img_stuff_pepperoni,R.drawable.img_stuff_sallami, R.drawable.img_stuff_cheeze, R.drawable.img_stuff_ham, R.drawable.img_stuff_mayoneze, R.drawable.img_stuff_mustard};
        String[] stuffNameArr = {"페퍼로니 3장","살라미 3장","치즈 2장", "햄 2장","마요네즈","머스타드"};

        for(int i=0;i<stuffImgArr.length;i++){
            menuStuffItemArrayList.add(new MenuStuffItem(stuffImgArr[i],stuffNameArr[i]));
        }

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
