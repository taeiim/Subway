package com.example.parktaeim.subway.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.parktaeim.subway.Adapter.FragmentViewPagerAdapter;
import com.example.parktaeim.subway.R;

/**
 * Created by parktaeim on 2018. 4. 15..
 */

public class StoreFragment extends Fragment {
    private ViewPager viewPager;
    private FragmentViewPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_store,container,false);

        viewPager = (ViewPager) rootView.findViewById(R.id.store_viewPager);
        adapter = new FragmentViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new StoreNearFragment(), "근처매장찾기");
        adapter.addFragment(new StoreNameFragment(), "매장명 검색");
        adapter.addFragment(new StoreAddressFragment(), "주소 검색");
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.store_tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        return rootView;
    }
}
