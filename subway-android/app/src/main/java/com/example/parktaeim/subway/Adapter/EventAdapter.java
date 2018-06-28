package com.example.parktaeim.subway.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parktaeim.subway.Activity.MainActivity;
import com.example.parktaeim.subway.Model.EventItem;
import com.example.parktaeim.subway.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by parktaeim on 2018. 4. 18..
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private ArrayList<EventItem> eventItemArrayList = new ArrayList<>();

    public EventAdapter(ArrayList<EventItem> eventItemArrayList) {
        this.eventItemArrayList = eventItemArrayList;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EventAdapter.ViewHolder holder, int position) {
        holder.eventImgView.setImageResource(eventItemArrayList.get(position).getSmallImg());
        holder.eventTitleTv.setText(eventItemArrayList.get(position).getEventTitle());
        holder.eventPeriodTv.setText(eventItemArrayList.get(position).getEventPeriod());

    }

    @Override
    public int getItemCount() {
        return eventItemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView eventTitleTv;
        TextView eventPeriodTv;
        ImageView eventImgView;

        public ViewHolder(View itemView) {
            super(itemView);
            eventImgView = itemView.findViewById(R.id.event_imgView);
            eventTitleTv = itemView.findViewById(R.id.event_titleTv);
            eventPeriodTv = itemView.findViewById(R.id.event_periodTv);
        }
    }
}
