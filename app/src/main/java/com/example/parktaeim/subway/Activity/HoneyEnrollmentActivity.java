package com.example.parktaeim.subway.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.example.parktaeim.subway.Adapter.VerticalViewpagerAdapter;
import com.example.parktaeim.subway.R;
import com.example.parktaeim.subway.VerticalViewPager;

/**
 * Created by parktaeim on 2018. 5. 2..
 */

public class HoneyEnrollmentActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_honey_enrollment);


        RelativeLayout cancelIcon = (RelativeLayout) findViewById(R.id.honeyEnroll_cancelBtn);
        cancelIcon.setOnClickListener(v -> finish());

        setUpVerticalViewPager();
    }

    private void setUpVerticalViewPager() {
        VerticalViewPager verticalViewPager = (VerticalViewPager) findViewById(R.id.honeyEnroll_verticalViewPager);
        verticalViewPager.setAdapter(new VerticalViewpagerAdapter(getSupportFragmentManager()));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.honeyEnroll_tabLayout);
        tabLayout.setupWithViewPager(verticalViewPager,true);
//        tabLayout.setRotation(tabLayout.getRotation()+90);

        tabLayout.setAnimation(AnimationUtils.loadAnimation(this,R.anim.rotate_tablayout));
//        tabLayout.setEnabled(false);
//        tabLayout.setClickable(false);
    }
}
