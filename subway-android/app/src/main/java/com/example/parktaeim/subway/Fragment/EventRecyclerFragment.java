package com.example.parktaeim.subway.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.parktaeim.subway.Activity.EventDetailActivity;
import com.example.parktaeim.subway.Adapter.EventAdapter;
import com.example.parktaeim.subway.Model.EventItem;
import com.example.parktaeim.subway.R;
import com.example.parktaeim.subway.RecyclerViewClickListener;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 28..
 */

public class EventRecyclerFragment extends Fragment {
    private View rootView;
    private ArrayList<EventItem> eventItemArrayList = new ArrayList<>();
    private EventAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_event_recycler,container,false);
        setUpRecyclerView();

        return rootView;
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.event_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        eventItemArrayList.add(new EventItem("아보씨 카도군과 피크닉 가실래요?","2018.05.31 - 2018.06.30",R.drawable.img_event_aborcado2,R.drawable.img_event_aborcado));
        eventItemArrayList.add(new EventItem("써브웨이 아보카도 시리즈 출시!","2018.05.04 - 2018.07.31",R.drawable.img_event_aborseseries2,R.drawable.img_event_aborseseries));
        eventItemArrayList.add(new EventItem("리얼 아메리칸 풀드포크 신제품 출시","2018.02.01 - 2018.12.31",R.drawable.img_event_puldfork2,R.drawable.img_event_puldfork));

        adapter = new EventAdapter(eventItemArrayList);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerViewClickListener(getContext(), recyclerView, new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(),EventDetailActivity.class);
                intent.putExtra("eventTitle",eventItemArrayList.get(position).getEventTitle());
                intent.putExtra("eventPeriod",eventItemArrayList.get(position).getEventPeriod());
                intent.putExtra("bigImg",eventItemArrayList.get(position).getBigImg());
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }
}
