package com.example.parktaeim.subway.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parktaeim.subway.R;

/**
 * Created by parktaeim on 2018. 4. 24..
 */

public class HoneyDetailReviewFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_honeydetail_review, container,false);
        return rootView;
    }
}
