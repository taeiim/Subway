package com.example.parktaeim.subway.Adapter;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.parktaeim.subway.Model.HoneyRankItem;
import com.example.parktaeim.subway.R;
import com.example.parktaeim.subway.SubwayAnimation;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 17..
 */

public class HoneyRankAdapter extends RecyclerView.Adapter<HoneyRankAdapter.ViewHolder> {

    private ArrayList<HoneyRankItem> honeyRankItemArrayList = new ArrayList<>();

    public HoneyRankAdapter(ArrayList<HoneyRankItem> honeyRankItemArrayList) {
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
        holder.honeyNameTv.setText(honeyRankItemArrayList.get(position).getName());
        holder.honeyDescTv.setText(honeyRankItemArrayList.get(position).getDesc());
        holder.starRatingBar.setRating(honeyRankItemArrayList.get(position).getStar());
        holder.starTv.setText(String.valueOf(honeyRankItemArrayList.get(position).getStar()));
        holder.starPeoCntTv.setText(String.valueOf(honeyRankItemArrayList.get(position).getStarPeoCnt()));
        holder.heartTv.setText(String.valueOf(honeyRankItemArrayList.get(position).getHeartCnt()));

        SubwayAnimation subwayAnimation = new SubwayAnimation();
        holder.heartBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                //animation
                compoundButton.startAnimation(subwayAnimation.setHearBtnAnimation());
            }

        });
    }

    @Override
    public int getItemCount() {
        return honeyRankItemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView honeyNameTv;
        TextView honeyDescTv;
        TextView heartTv;
        TextView starTv;
        TextView starPeoCntTv;
        ImageView honeyImgView;
        RatingBar starRatingBar;
        ToggleButton heartBtn;

        public ViewHolder(View itemView) {
            super(itemView);
            honeyNameTv = (TextView) itemView.findViewById(R.id.honeyRank_title);
            honeyDescTv = (TextView) itemView.findViewById(R.id.honeyRank_desc);
            heartTv = (TextView) itemView.findViewById(R.id.honeyRank_heartCnt);
            starTv = (TextView) itemView.findViewById(R.id.honeyRank_starTv);
            starPeoCntTv = (TextView) itemView.findViewById(R.id.honeyRank_starPeoCntTv);
            honeyImgView = (ImageView) itemView.findViewById(R.id.honeyRank_imgView);
            starRatingBar = (RatingBar) itemView.findViewById(R.id.honeyRank_ratingBar);
            heartBtn = (ToggleButton) itemView.findViewById(R.id.honeyRank_heartBtn);
        }
    }
}
