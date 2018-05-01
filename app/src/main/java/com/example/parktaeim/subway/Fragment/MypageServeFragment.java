package com.example.parktaeim.subway.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parktaeim.subway.Adapter.FragmentViewPagerAdapter;
import com.example.parktaeim.subway.R;

/**
 * Created by parktaeim on 2018. 5. 1..
 */

public class MypageServeFragment extends Fragment {
    private View rootView;
    private ViewPager viewPager;
    private FragmentViewPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_mypage_serve,container,false);

        viewPager = (ViewPager) rootView.findViewById(R.id.mypageServe_viewPager);
        adapter = new FragmentViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new MypageServeRecyclerFragment(), "꿀조합");
        adapter.addFragment(new MypageServeRecyclerFragment(), "메뉴");
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.mypageServe_tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        return rootView;
    }
}
