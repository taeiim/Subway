package com.example.parktaeim.subway.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.parktaeim.subway.Model.ReviewItem;
import com.example.parktaeim.subway.R;
import com.example.parktaeim.subway.SubwayAnimation;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by parktaeim on 2018. 4. 30..
 */

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {
    private ArrayList<ReviewItem> reviewItemArrayList = new ArrayList<>();

    public ReviewAdapter(ArrayList<ReviewItem> reviewItemArrayList) {
        this.reviewItemArrayList = reviewItemArrayList;
    }

    @Override
    public ReviewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ReviewAdapter.ViewHolder holder, int position) {
        holder.writerNameTv.setText(reviewItemArrayList.get(position).getWriterName());
        holder.writeDateTv.setText(reviewItemArrayList.get(position).getWriteDate());
        holder.heartCntTv.setText(String.valueOf(reviewItemArrayList.get(position).getHeartCnt()));
        holder.ratingBar.setRating(reviewItemArrayList.get(position).getReviewRatingNum());

        SubwayAnimation subwayAnimation = new SubwayAnimation();
        holder.heartBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                buttonView.startAnimation(subwayAnimation.setHearBtnAnimation());
            }
        });
        holder.heartBtnLayout.setOnClickListener(v-> holder.heartBtn.toggle());

    }

    @Override
    public int getItemCount() {
        return reviewItemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView writerNameTv;
        TextView writeDateTv;
        TextView heartCntTv;
        CircleImageView profileImg;
        RatingBar ratingBar;
        ToggleButton heartBtn;
        LinearLayout heartBtnLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            writerNameTv = (TextView) itemView.findViewById(R.id.review_writerNameTv);
            writeDateTv = (TextView) itemView.findViewById(R.id.review_writeDateTv);
            heartCntTv = (TextView) itemView.findViewById(R.id.review_heartCntTv);
            profileImg = (CircleImageView) itemView.findViewById(R.id.review_writerProfile);
            ratingBar = (RatingBar) itemView.findViewById(R.id.review_ratingBar);
            heartBtn = (ToggleButton) itemView.findViewById(R.id.review_heartBtn);
            heartBtnLayout = (LinearLayout) itemView.findViewById(R.id.review_heartBtnLayout);
        }
    }
}
