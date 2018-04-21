package com.example.parktaeim.subway.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.example.parktaeim.subway.Adapter.MenuAdapter;
import com.example.parktaeim.subway.Model.MenuItem;
import com.example.parktaeim.subway.R;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 15..
 */

public class MenuFragment extends Fragment {
    private View rootView;
    private RecyclerView recyclerView;
    private MenuAdapter adapter;
    private GridLayoutManager layoutManager;
    private ArrayList<MenuItem> menuItemArrayList = new ArrayList<>();
    private ScaleAnimation scaleAnimation;
    private BounceInterpolator bounceInterpolator;
    private ToggleButton heartBtn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_menu,container,false);

        setUpRecyclerView();

        return rootView;
    }

    private void setUpRecyclerView() {
        recyclerView = rootView.findViewById(R.id.menu_recyclerView);
        layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        menuItemArrayList.add(new MenuItem("dslkj","비엘티","4800원",4.0f));
        menuItemArrayList.add(new MenuItem("dslkj","비엘티","4800원",2.0f));
        menuItemArrayList.add(new MenuItem("dslkj","비엘티","4800원",3.0f));
        menuItemArrayList.add(new MenuItem("dslkj","비엘티","4800원",4.0f));
        menuItemArrayList.add(new MenuItem("dslkj","비엘티","4800원",4.0f));

        adapter = new MenuAdapter(menuItemArrayList);
        recyclerView.setAdapter(adapter);
    }
}
