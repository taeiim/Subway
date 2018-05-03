package com.example.parktaeim.subway.Fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.parktaeim.subway.Activity.HoneyAllActivity;
import com.example.parktaeim.subway.Activity.HoneyEnrollmentActivity;
import com.example.parktaeim.subway.Activity.HoneyRankActivity;
import com.example.parktaeim.subway.Activity.SearchActivity;
import com.example.parktaeim.subway.Adapter.BannerPagerAdapter;
import com.example.parktaeim.subway.R;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 15..
 */

public class HoneyFragment extends android.support.v4.app.Fragment {

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_honey,container,false);

        setUpBanner();

        LinearLayout honeyAllIntentLayout = (LinearLayout) rootView.findViewById(R.id.allHoneyIntentLayout);
        honeyAllIntentLayout.setOnClickListener(v-> startActivity(new Intent(getContext(), HoneyAllActivity.class)));

        LinearLayout honeyRankIntentLayout = (LinearLayout) rootView.findViewById(R.id.rankHoneyIntentLayout);
        honeyRankIntentLayout.setOnClickListener(v-> startActivity(new Intent(getContext(), HoneyRankActivity.class)));

        ImageView searchIcon = (ImageView) rootView.findViewById(R.id.honey_searchIcon);
        searchIcon.setOnClickListener(v-> startActivity(new Intent(getContext(), SearchActivity.class)));

        RelativeLayout intentEnrollBtn = (RelativeLayout) rootView.findViewById(R.id.intentHoneyEnrollBtn);
        intentEnrollBtn.setOnClickListener(v->startActivity(new Intent(getContext(),HoneyEnrollmentActivity.class)));

        return rootView;
    }

    private void setUpBanner() {
        ArrayList<Drawable> bannerImgArrayList = new ArrayList<>();
        bannerImgArrayList.add(ContextCompat.getDrawable(getContext(),R.drawable.img_banner1));
        bannerImgArrayList.add(ContextCompat.getDrawable(getContext(),R.drawable.img_banner1));
        bannerImgArrayList.add(ContextCompat.getDrawable(getContext(),R.drawable.img_store_dialog_top));
        bannerImgArrayList.add(ContextCompat.getDrawable(getContext(),R.drawable.img_store_dialog_top));

        BannerPagerAdapter adapter = new BannerPagerAdapter(getContext(),bannerImgArrayList);
        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.honey_banner_viewPager);
        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.honey_banner_tabLayout);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager,true);

    }
}
