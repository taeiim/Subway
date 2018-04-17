package com.example.parktaeim.subway.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parktaeim.subway.R;

/**
 * Created by parktaeim on 2018. 4. 15..
 */

public class HoneyFragment extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_honey,container,false);
        return view;
    }
//
//    public static HoneyFragment newInstance(){
//        Bundle args = new Bundle();
//
//        HoneyFragment honeyFragment = new HoneyFragment();
//        honeyFragment.setArguments(args);
//
//        return honeyFragment;
//    }
}
