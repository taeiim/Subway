package com.example.parktaeim.subway.Activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.parktaeim.subway.Adapter.BannerPagerAdapter;
import com.example.parktaeim.subway.Adapter.FragmentViewPagerAdapter;
import com.example.parktaeim.subway.Fragment.HoneyDetailInfoFragment;
import com.example.parktaeim.subway.Fragment.HoneyDetailReviewFragment;
import com.example.parktaeim.subway.Fragment.StoreAddressFragment;
import com.example.parktaeim.subway.Fragment.StoreNameFragment;
import com.example.parktaeim.subway.Fragment.StoreNearFragment;
import com.example.parktaeim.subway.R;
import com.example.parktaeim.subway.SubwayAnimation;
import com.example.parktaeim.subway.WrapContentHeightViewPager;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 24..
 */

public class HoneyDetailActivity extends AppCompatActivity {
    private boolean isSayingShow = false;

    private ViewPager viewPager;
    private FragmentViewPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_honey_detail);

        setUpTabLayout();
        setUpWriterSayingShow();
        setUpImageViewPager();

        ToggleButton heartBtn = (ToggleButton) findViewById(R.id.honeyDetail_heartBtn);
        SubwayAnimation subwayAnimation = new SubwayAnimation();
        heartBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                compoundButton.startAnimation(subwayAnimation.setHearBtnAnimation());
            }
        });

        FloatingActionButton reviewFab = (FloatingActionButton) findViewById(R.id.honeyDetail_reviewFab);
        reviewFab.setOnClickListener(v->{
            Intent intent = new Intent(this,ReviewWriteActivity.class);
            intent.putExtra("reviewType",1);
            startActivity(intent);
        });

    }

    private void setUpImageViewPager() {
        ArrayList<Drawable> bannerImgArrayList = new ArrayList<>();
        bannerImgArrayList.add(ContextCompat.getDrawable(this,R.drawable.img_subway_full));
        bannerImgArrayList.add(ContextCompat.getDrawable(this,R.drawable.img_subway_full));
        bannerImgArrayList.add(ContextCompat.getDrawable(this,R.drawable.img_subway));
        bannerImgArrayList.add(ContextCompat.getDrawable(this,R.drawable.img_banner1));

        BannerPagerAdapter adapter = new BannerPagerAdapter(this,bannerImgArrayList);
        ViewPager viewPager = (ViewPager) findViewById(R.id.honeyDetail_banner_viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.honeyDetail_banner_tabLayout);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager,true);
    }

    private void setUpWriterSayingShow() {
        RelativeLayout showingIconLayout = (RelativeLayout) findViewById(R.id.honeyDetail_writerShowLayout);
        TextView writerSayingTv = (TextView) findViewById(R.id.honeyDetail_writerSayingTv);
        ImageView showingIcon = (ImageView) findViewById(R.id.honeyDetail_writerShowIcon);

        showingIconLayout.setOnClickListener(v->{
            if(isSayingShow){
                writerSayingTv.setVisibility(View.GONE);
                showingIcon.setImageResource(R.drawable.ic_down_arrow);
                isSayingShow = false;

            } else{  // isSayingShow == false
                writerSayingTv.setVisibility(View.VISIBLE);
                showingIcon.setImageResource(R.drawable.ic_down_arrow);
                isSayingShow = true;
            }
        });
    }

    private void setUpTabLayout() {
        viewPager = (ViewPager) findViewById(R.id.honeyDetail_viewPager);
        adapter = new FragmentViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HoneyDetailInfoFragment(), "구성");
        adapter.addFragment(new HoneyDetailReviewFragment(), "리뷰");
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.honeyDetail_tabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }
}
