package com.example.parktaeim.subway.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parktaeim.subway.Model.HoneyAllItem;
import com.example.parktaeim.subway.R;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 17..
 */

public class HoneyRankAdapter extends RecyclerView.Adapter<HoneyRankAdapter.ViewHolder> {

    private ArrayList<HoneyAllItem> honeyRankItemArrayList = new ArrayList<>();

    public HoneyRankAdapter(ArrayList<HoneyAllItem> honeyRankItemArrayList) {
        this.honeyRankItemArrayList = honeyRankItemArrayList;
    }

    @Override
    public HoneyRankAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_honey_rank,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HoneyRankAdapter.ViewHolder holder, int position) {
        holder.honeyNameTv.setText(honeyRankItemArrayList.get(position).getHoneyName());
        holder.honeyDescTv.setText(honeyRankItemArrayList.get(position).getHoneyInfo());
        holder.honeyRankTv.setText(String.valueOf(position+1));
    }

    @Override
    public int getItemCount() {
        return honeyRankItemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView honeyNameTv;
        TextView honeyDescTv;
        TextView honeyRankTv;
        ImageView honeyImgView;

        public ViewHolder(View itemView) {
            super(itemView);
            honeyNameTv = (TextView) itemView.findViewById(R.id.honeyRank_titleTv);
            honeyDescTv = (TextView) itemView.findViewById(R.id.honeyRank_descTv);
            honeyRankTv = (TextView) itemView.findViewById(R.id.honeyRank_rankNumTv);
            honeyImgView = (ImageView) itemView.findViewById(R.id.honeyRank_imgView);
        }
    }
}
