package com.example.parktaeim.subway.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.parktaeim.subway.Fragment.ArrayEnrollRecipeFragment;

/**
 * Created by parktaeim on 2018. 5. 3..
 */

public class VerticalViewpagerAdapter extends FragmentPagerAdapter {
    private final int FRAGMENT_COUNT = 6;

    public VerticalViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ArrayEnrollRecipeFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }
}
