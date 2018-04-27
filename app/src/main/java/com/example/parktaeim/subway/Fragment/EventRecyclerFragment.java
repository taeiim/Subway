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

        eventItemArrayList.add(new EventItem("slfkjdslfkjdslkf","2018-2423o4u-342","dslkfjsdk"));
        eventItemArrayList.add(new EventItem("slfkjdslfkjdslkf","2018-2423o4u-342","dslkfjsdk"));
        eventItemArrayList.add(new EventItem("slfkjdslfkjdslkf","2018-2423o4u-342","dslkfjsdk"));
        eventItemArrayList.add(new EventItem("slfkjdslfkjdslkf","2018-2423o4u-342","dslkfjsdk"));
        eventItemArrayList.add(new EventItem("slfkjdslfkjdslkf","2018-2423o4u-342","dslkfjsdk"));
        eventItemArrayList.add(new EventItem("slfkjdslfkjdslkf","2018-2423o4u-342","dslkfjsdk"));

        adapter = new EventAdapter(eventItemArrayList);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerViewClickListener(getContext(), recyclerView, new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(),EventDetailActivity.class);
                intent.putExtra("eventTitle",eventItemArrayList.get(position).getEventTitle());
                intent.putExtra("eventPeriod",eventItemArrayList.get(position).getEventPeriod());
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }
}
