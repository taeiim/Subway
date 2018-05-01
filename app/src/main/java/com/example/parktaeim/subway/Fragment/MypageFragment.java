package com.example.parktaeim.subway.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.parktaeim.subway.Activity.ReviewWriteActivity;
import com.example.parktaeim.subway.Activity.SettingsActivity;
import com.example.parktaeim.subway.R;

/**
 * Created by parktaeim on 2018. 4. 15..
 */

public class MypageFragment extends Fragment {
    private View rootView;
    private TextView goodNumTv;
    private TextView goodTitleTv;
    private TextView reviewTitleTv;
    private TextView reviewNumTv;
    private TextView honeyTitleTv;
    private TextView honeyNumTv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_mypage,container,false);

        ImageView settingsIcon = (ImageView) rootView.findViewById(R.id.mypage_settingsBtn);
        settingsIcon.setOnClickListener(v->startActivity(new Intent(getContext(), SettingsActivity.class)));

        LinearLayout goodLayout = (LinearLayout) rootView.findViewById(R.id.mypageGoodLayout);
        LinearLayout reviewLayout = (LinearLayout) rootView.findViewById(R.id.mypageReviewLayout);
        LinearLayout honeyLayout = (LinearLayout) rootView.findViewById(R.id.mypageHoneyLayout);

        LinearLayout goodLayout2 = (LinearLayout) rootView.findViewById(R.id.mypageGoodLayout2);
        LinearLayout reviewLayout2 = (LinearLayout) rootView.findViewById(R.id.mypageReviewLayout2);
        LinearLayout honeyLayout2 = (LinearLayout) rootView.findViewById(R.id.mypageHoneyLayout2);

        goodTitleTv = (TextView) rootView.findViewById(R.id.mypageGoodTitleTv);
        goodNumTv = (TextView) rootView.findViewById(R.id.mypageGoodNumTv);
        reviewTitleTv = (TextView) rootView.findViewById(R.id.mypageReviewTitleTv);
        reviewNumTv = (TextView) rootView.findViewById(R.id.mypageReviewNumTv);
        honeyTitleTv = (TextView) rootView.findViewById(R.id.mypageHoneyTitleTv);
        honeyNumTv = (TextView) rootView.findViewById(R.id.mypageHoneyNumTv);

        setUpFragment(0);

        goodLayout.setOnClickListener(v->setUpFragment(0));
        reviewLayout.setOnClickListener(v->setUpFragment(1));
        honeyLayout.setOnClickListener(v->setUpFragment(2));
        goodLayout2.setOnClickListener(v->setUpFragment(0));
        reviewLayout2.setOnClickListener(v->setUpFragment(1));
        honeyLayout2.setOnClickListener(v->setUpFragment(2));

        return rootView;
    }

    public void setUpFragment(int type) {
        switch (type){
            case 0:
                setLayoutTextColor(goodTitleTv, goodNumTv);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mypage_fragmentContainer, new MypageServeFragment()).commit();
                break;
            case 1:
                setLayoutTextColor(reviewTitleTv, reviewNumTv);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mypage_fragmentContainer, new MypageServeFragment()).commit();
                break;
            case 2:
                setLayoutTextColor(honeyTitleTv, honeyNumTv);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mypage_fragmentContainer, new MypageServeRecyclerFragment()).commit();
                break;
        }
    }

    public void setLayoutTextColor(TextView titleTv, TextView numTv){
        setLayoutTextBlack();
        titleTv.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        numTv.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
    }

    public void setLayoutTextBlack(){
        TextView[] textViews = {goodTitleTv, goodNumTv, reviewTitleTv, reviewNumTv, honeyTitleTv, honeyNumTv};
        for(int i=0; i<textViews.length; i++){
            textViews[i].setTextColor(Color.BLACK);
        }
    }
}
