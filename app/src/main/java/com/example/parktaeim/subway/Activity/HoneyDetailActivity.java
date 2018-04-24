package com.example.parktaeim.subway.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.example.parktaeim.subway.Adapter.FragmentViewPagerAdapter;
import com.example.parktaeim.subway.Fragment.HoneyDetailInfoFragment;
import com.example.parktaeim.subway.Fragment.HoneyDetailReviewFragment;
import com.example.parktaeim.subway.Fragment.StoreAddressFragment;
import com.example.parktaeim.subway.Fragment.StoreNameFragment;
import com.example.parktaeim.subway.Fragment.StoreNearFragment;
import com.example.parktaeim.subway.R;

/**
 * Created by parktaeim on 2018. 4. 24..
 */

public class HoneyDetailActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private FragmentViewPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_honey_detail);

        setUpTabLayout();
    }

    private void setUpTabLayout() {
        viewPager = (ViewPager) findViewById(R.id.honeyDetail_viewPager);
        //ScrollView 안에 ViewPager
//        viewPager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                v.getParent().requestDisallowInterceptTouchEvent(true);
//                return false;
//            }
//        });
//
//        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                viewPager.getParent().requestDisallowInterceptTouchEvent(true);
//            }
//        });

        adapter = new FragmentViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HoneyDetailInfoFragment(), "구성");
        adapter.addFragment(new HoneyDetailReviewFragment(), "리뷰");
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.honeyDetail_tabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }
}
