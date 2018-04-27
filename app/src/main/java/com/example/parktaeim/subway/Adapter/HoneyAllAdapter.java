package com.example.parktaeim.subway.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.parktaeim.subway.Activity.HoneyDetailActivity;
import com.example.parktaeim.subway.Model.HoneyAllItem;
import com.example.parktaeim.subway.R;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 24..
 */

public class HoneyAllAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<HoneyAllItem> honeyAllItemArrayList = new ArrayList<>();
    private int recyclerViewType;
    private Context context;

    public HoneyAllAdapter(ArrayList<HoneyAllItem> honeyAllItemArrayList, int recyclerViewType , Context context) {
        this.honeyAllItemArrayList = honeyAllItemArrayList;
        this.recyclerViewType = recyclerViewType;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(recyclerViewType == 1){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu_all_grid,parent,false);
            return new ViewHolderGrid(view);

        }else {  //recyclerViewType == 2 (linear)
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu_all_linear,parent,false);
            return new ViewHolderLinear(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HoneyAllItem currentItem = honeyAllItemArrayList.get(position);
        if(holder instanceof ViewHolderGrid){
            ((ViewHolderGrid)holder).honeyNameTv.setText(currentItem.getHoneyName());
            ((ViewHolderGrid)holder).honeyPriceTv.setText(currentItem.getHoneyPrice());
            ((ViewHolderGrid)holder).honeyInfoTv.setText(currentItem.getHoneyInfo());
            ((ViewHolderGrid)holder).starTv.setText(String.valueOf(currentItem.getStarNum()));
            ((ViewHolderGrid)holder).starPeoCntTv.setText(String.valueOf(currentItem.getStarPeoCnt()));
            ((ViewHolderGrid)holder).heartCntTv.setText(String.valueOf(currentItem.getHeartCnt()));

        } else {
            ((ViewHolderLinear)holder).honeyNameTv.setText(currentItem.getHoneyName());
            ((ViewHolderLinear)holder).honeyPriceTv.setText(currentItem.getHoneyPrice());
            ((ViewHolderLinear)holder).honeyInfoTv.setText(currentItem.getHoneyInfo());
            ((ViewHolderLinear)holder).starTv.setText(String.valueOf(currentItem.getStarNum()));
            ((ViewHolderLinear)holder).starPeoCntTv.setText(String.valueOf(currentItem.getStarPeoCnt()));
            ((ViewHolderLinear)holder).heartCntTv.setText(String.valueOf(currentItem.getHeartCnt()));
            ((ViewHolderLinear)holder).starRatingBar.setRating(currentItem.getStarNum());
        }

        holder.itemView.setOnClickListener(v -> context.startActivity(new Intent(context, HoneyDetailActivity.class)));
    }

    @Override
    public int getItemCount() {
        return honeyAllItemArrayList.size();
    }

    public class ViewHolderGrid extends RecyclerView.ViewHolder {
        TextView honeyNameTv;
        TextView honeyPriceTv;
        TextView honeyInfoTv;
        TextView starTv;
        TextView starPeoCntTv;
        TextView heartCntTv;
        ToggleButton heartBtn;
        ImageView honeyImgView;

        public ViewHolderGrid(View itemView) {
            super(itemView);
            honeyNameTv = (TextView) itemView.findViewById(R.id.allmenuGrid_nameTv);
            honeyPriceTv = (TextView) itemView.findViewById(R.id.allmenuGrid_priceTv);
            honeyInfoTv = (TextView) itemView.findViewById(R.id.allmenuGrid_infoTv);
            starTv = (TextView) itemView.findViewById(R.id.allmenuGrid_starTv);
            starPeoCntTv = (TextView) itemView.findViewById(R.id.allmenuGrid_starPeoCntTv);
            heartCntTv = (TextView) itemView.findViewById(R.id.allmenuGrid_heartCnt);
            heartBtn = (ToggleButton) itemView.findViewById(R.id.allmenuGrid_heartBtn);
            honeyImgView = (ImageView) itemView.findViewById(R.id.allmenuGrid_imgView);
        }
    }

    public class ViewHolderLinear extends RecyclerView.ViewHolder {
        TextView honeyNameTv;
        TextView honeyPriceTv;
        TextView honeyInfoTv;
        TextView starTv;
        TextView starPeoCntTv;
        TextView heartCntTv;
        RatingBar starRatingBar;
        ToggleButton heartBtn;
        ImageView honeyImgView;

        public ViewHolderLinear(View itemView) {
            super(itemView);
            honeyNameTv = (TextView) itemView.findViewById(R.id.allmenuLinear_nameTv);
            honeyPriceTv = (TextView) itemView.findViewById(R.id.allmenuLinear_priceTv);
            honeyInfoTv = (TextView) itemView.findViewById(R.id.allmenuLinear_infoTv);
            starTv = (TextView) itemView.findViewById(R.id.allmenuLinear_starTv);
            starPeoCntTv = (TextView) itemView.findViewById(R.id.allmenuLinear_starPeoCntTv);
            heartCntTv = (TextView) itemView.findViewById(R.id.allmenuLinear_heartCnt);
            starRatingBar = (RatingBar) itemView.findViewById(R.id.allmenuLinear_ratingBar);
            heartBtn = (ToggleButton) itemView.findViewById(R.id.allmenuLinear_heartBtn);
            honeyImgView = (ImageView) itemView.findViewById(R.id.allmenuLinear_menuImgView);

        }
    }
}
