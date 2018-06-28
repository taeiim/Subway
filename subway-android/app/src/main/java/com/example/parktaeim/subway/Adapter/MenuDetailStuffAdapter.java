package com.example.parktaeim.subway.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parktaeim.subway.Model.MenuStuffItem;
import com.example.parktaeim.subway.R;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 23..
 */

public class MenuDetailStuffAdapter extends RecyclerView.Adapter<MenuDetailStuffAdapter.ViewHolder> {
    private ArrayList<MenuStuffItem> menuStuffItemArrayList = new ArrayList<>();

    public MenuDetailStuffAdapter(ArrayList<MenuStuffItem> menuStuffItemArrayList) {
        this.menuStuffItemArrayList = menuStuffItemArrayList;
    }

    @Override
    public MenuDetailStuffAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menudetail_stuff,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MenuDetailStuffAdapter.ViewHolder holder, int position) {
        holder.stuffImgView.setImageResource(menuStuffItemArrayList.get(position).getStuffImg());
        holder.stuffTv.setText(menuStuffItemArrayList.get(position).getStuffText());
    }

    @Override
    public int getItemCount() {
        return menuStuffItemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView stuffImgView;
        TextView stuffTv;

        public ViewHolder(View itemView) {
            super(itemView);
            stuffImgView = (ImageView) itemView.findViewById(R.id.stuff_imgView);
            stuffTv = (TextView) itemView.findViewById(R.id.stuff_nameTv);
        }
    }
}
