package com.example.parktaeim.subway.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 18..
 */

public class FragmentViewPagerAdapter extends FragmentPagerAdapter{
    private final ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    private final ArrayList<String> fragmentTitleArrayList = new ArrayList<>();


    public FragmentViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    public void addFragment(android.support.v4.app.Fragment fragment, String title) {
        fragmentArrayList.add(fragment);
        fragmentTitleArrayList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleArrayList.get(position);
    }

}
