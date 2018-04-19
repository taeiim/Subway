package com.example.parktaeim.subway.Fragment;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.example.parktaeim.subway.Activity.EventDetailActivity;
import com.example.parktaeim.subway.Adapter.StoreAdapter;
import com.example.parktaeim.subway.Model.StoreItem;
import com.example.parktaeim.subway.R;
import com.example.parktaeim.subway.RecyclerViewClickListener;
import com.example.parktaeim.subway.StoreDetailDialog;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 18..
 */

public class StoreNearFragment extends Fragment {
    private View rootView;

    private RecyclerView recyclerView;
    private StoreAdapter adapter;
    private LinearLayoutManager layoutManager;
    private ArrayList<StoreItem> storeItemArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_store_near,container,false);
        setUpRecyclerView();

        TextView resultCntTv = (TextView) rootView.findViewById(R.id.storeNear_resultCntTv);
        resultCntTv.setText(String.valueOf(storeItemArrayList.size()));

        recyclerView.addOnItemTouchListener(new RecyclerViewClickListener(getContext(), recyclerView, new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                StoreDetailDialog storeDetailDialog = new StoreDetailDialog(getContext());
                storeDetailDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                storeDetailDialog.show();

            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
        return rootView;
    }

    private void setUpRecyclerView() {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.storeNear_recyclerVieew);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        storeItemArrayList.add(new StoreItem("천안 충무로점","충청남도 천안시 서북구 충무로 201","600m"));
        storeItemArrayList.add(new StoreItem("천안 충무로점","서울특별시 광진구 능동로 290 삼일빌딩","600m"));
        storeItemArrayList.add(new StoreItem("천안 충무로점","충청남도 천안시 서북구 충무로 201","600m"));
        storeItemArrayList.add(new StoreItem("천안 충무로점","충청남도 천안시 서북구 충무로 201","600m"));
        storeItemArrayList.add(new StoreItem("천안 충무로점","충청남도 천안시 서북구 충무로 201","600m"));

        adapter = new StoreAdapter(storeItemArrayList);
        recyclerView.setAdapter(adapter);
    }
}
