package com.example.parktaeim.subway.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.parktaeim.subway.Model.StoreItem;
import com.example.parktaeim.subway.R;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 18..
 */

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {
    ArrayList<StoreItem> storeItemArrayList = new ArrayList<>();

    public StoreAdapter(ArrayList<StoreItem> storeItemArrayList) {
        this.storeItemArrayList = storeItemArrayList;
    }

    @Override
    public StoreAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_store,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StoreAdapter.ViewHolder holder, int position) {
        holder.nameTv.setText(storeItemArrayList.get(position).getStoreName());
        holder.addressTv.setText(storeItemArrayList.get(position).getStoreAddress());

        String distance = storeItemArrayList.get(position).getDistance();
        if(distance != null && distance.length() != 0){
            holder.distanceTv.setText(distance);
        } else holder.distanceTv.setText("");
    }

    @Override
    public int getItemCount() {
        return storeItemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv;
        TextView addressTv;
        TextView distanceTv;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTv = (TextView) itemView.findViewById(R.id.storeNameTv);
            addressTv = (TextView) itemView.findViewById(R.id.storeAddressTv);
            distanceTv = (TextView) itemView.findViewById(R.id.storeDistanceTv);
        }
    }
}
