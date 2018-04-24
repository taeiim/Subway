package com.example.parktaeim.subway.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.parktaeim.subway.Adapter.StoreAdapter;
import com.example.parktaeim.subway.Adapter.SpinnerAdapter;
import com.example.parktaeim.subway.Model.StoreItem;
import com.example.parktaeim.subway.R;
import com.example.parktaeim.subway.RecyclerViewClickListener;
import com.example.parktaeim.subway.StoreDetailDialog;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 18..
 */

public class StoreAddressFragment extends Fragment {
    private View rootView;

    private RecyclerView recyclerView;
    private StoreAdapter adapter;
    private LinearLayoutManager layoutManager;
    private ArrayList<StoreItem> storeItemArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_store_address,container,false);
        setUpRecyclerView();

        TextView resultCntTv = (TextView) rootView.findViewById(R.id.storeAddress_resultCntTv);
        resultCntTv.setText(String.valueOf(storeItemArrayList.size()));

        ArrayList <String> spinnerData1 = new ArrayList<>();
        spinnerData1.add("도/시");
        spinnerData1.add("대전");
        spinnerData1.add("서울");
        spinnerData1.add("세종");
        spinnerData1.add("충청북도");

        ArrayList <String> spinnerData2 = new ArrayList<>();
        spinnerData2.add("시/군/구");
        spinnerData2.add("거제시");
        spinnerData2.add("김해시");
        spinnerData2.add("남해군");
        spinnerData2.add("사천시");
        spinnerData2.add("양산시");
        spinnerData2.add("창원시");

        ArrayList <String> spinnerData3 = new ArrayList<>();
        spinnerData3.add("동/면/읍");

        Spinner spinner1 = (Spinner) rootView.findViewById(R.id.store_spinner1);
        Spinner spinner2 = (Spinner) rootView.findViewById(R.id.store_spinner2);
        Spinner spinner3 = (Spinner) rootView.findViewById(R.id.store_spinner3);

        SpinnerAdapter spinnerAdapter1 = new SpinnerAdapter(getContext(),spinnerData1);
        SpinnerAdapter spinnerAdapter2 = new SpinnerAdapter(getContext(),spinnerData2);
        SpinnerAdapter spinnerAdapter3 = new SpinnerAdapter(getContext(),spinnerData3);

        spinner1.setAdapter(spinnerAdapter1);
        spinner2.setAdapter(spinnerAdapter2);
        spinner3.setAdapter(spinnerAdapter3);

        return rootView;
    }

    private void setUpRecyclerView() {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.storeAddress_recyclerVieew);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        storeItemArrayList.add(new StoreItem("천안 충무로점","충청남도 천안시 서북구 충무로 201","08:00~23:00","042-949-2234"));
        storeItemArrayList.add(new StoreItem("천안 충무로점","충청남도 천안시 서북구 충무로 201","08:00~23:00","042-949-2234"));
        storeItemArrayList.add(new StoreItem("천안 충무로점","충청남도 천안시 서북구 충무로 201","08:00~23:00","042-949-2234"));
        storeItemArrayList.add(new StoreItem("천안 충무로점","충청남도 천안시 서북구 충무로 201","08:00~23:00","042-949-2234"));
        storeItemArrayList.add(new StoreItem("천안 충무로점","충청남도 천안시 서북구 충무로 201","08:00~23:00","042-949-2234"));

        adapter = new StoreAdapter(storeItemArrayList);
        recyclerView.setAdapter(adapter);

        //dialog로 값 전달
        recyclerView.addOnItemTouchListener(new RecyclerViewClickListener(getContext(), recyclerView, new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                StoreDetailDialog storeDetailDialog = new StoreDetailDialog();

                Bundle args = new Bundle();
                args.putString("name",storeItemArrayList.get(position).getStoreName());
                args.putString("address",storeItemArrayList.get(position).getStoreAddress());
                args.putString("tellNum",storeItemArrayList.get(position).getStoreTellNum());
                args.putString("openingTime",storeItemArrayList.get(position).getStoreOpeningTime());

                storeDetailDialog.setArguments(args);
                storeDetailDialog.show(fragmentManager,"store_info");

            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }
}
