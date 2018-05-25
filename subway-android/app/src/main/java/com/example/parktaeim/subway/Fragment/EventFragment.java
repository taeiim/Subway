package com.example.parktaeim.subway.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parktaeim.subway.Adapter.EventAdapter;
import com.example.parktaeim.subway.Adapter.FragmentViewPagerAdapter;
import com.example.parktaeim.subway.Model.EventItem;
import com.example.parktaeim.subway.R;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 15..
 */

public class EventFragment extends Fragment {
    private View rootView;
    private RecyclerView recyclerView;
    private EventAdapter adapter;
    private LinearLayoutManager layoutManager;
    private ArrayList<EventItem> eventItemArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_event, container, false);
        setUpViewPager();

        return rootView;

    }

    private void setUpViewPager() {
        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.eventViewPager);
        FragmentViewPagerAdapter adapter = new FragmentViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new EventRecyclerFragment(), "진행중 이벤트");
        adapter.addFragment(new EventRecyclerFragment(), "종료된 이벤트");
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.event_tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

}
