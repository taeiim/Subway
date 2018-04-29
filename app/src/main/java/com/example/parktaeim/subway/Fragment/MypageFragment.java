package com.example.parktaeim.subway.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.parktaeim.subway.Activity.SettingsActivity;
import com.example.parktaeim.subway.R;

/**
 * Created by parktaeim on 2018. 4. 15..
 */

public class MypageFragment extends Fragment {
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_mypage,container,false);

        ImageView settingsIcon = (ImageView) rootView.findViewById(R.id.mypage_settingsBtn);
        settingsIcon.setOnClickListener(v->startActivity(new Intent(getContext(), SettingsActivity.class)));

        return rootView;
    }

}
