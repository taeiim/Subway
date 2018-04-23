package com.example.parktaeim.subway.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
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

import com.example.parktaeim.subway.Activity.MenuDetailActivity;
import com.example.parktaeim.subway.Model.MenuItem;
import com.example.parktaeim.subway.R;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 21..
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    private ArrayList<MenuItem> menuItemArrayList = new ArrayList<>();
    private ScaleAnimation scaleAnimation;
    private Context context;

    public MenuAdapter(ArrayList<MenuItem> menuItemArrayList) {
        this.menuItemArrayList = menuItemArrayList;
    }

    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MenuAdapter.ViewHolder holder, int position) {
        context = holder.itemView.getContext();

        holder.nameTv.setText(menuItemArrayList.get(position).getName());
        holder.priceTv.setText(menuItemArrayList.get(position).getPrice());
        float starValue = menuItemArrayList.get(position).getStar();
        holder.starTv.setText(String.valueOf(starValue));
        holder.ratingBar.setRating(starValue);

        // Setting HeartBtn Animation
        setUpHeartAnimation();
        holder.heartBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                compoundButton.startAnimation(scaleAnimation);
            }
        });

        // Intent MenuDetailActivity
        holder.menuCardView.setOnClickListener(v -> {
            Intent intent = new Intent(context, MenuDetailActivity.class);
            intent.putExtra("menuName", menuItemArrayList.get(position).getName());
            intent.putExtra("menuPrice", menuItemArrayList.get(position).getPrice());
            context.startActivity(intent);
        });

    }

    private void setUpHeartAnimation() {
        scaleAnimation = new ScaleAnimation(0.7f, 1.0f, 0.7f, 1.0f, Animation.RELATIVE_TO_SELF, 0.7f, Animation.RELATIVE_TO_SELF, 0.7f);
        scaleAnimation.setDuration(500);
        BounceInterpolator bounceInterpolator = new BounceInterpolator();
        scaleAnimation.setInterpolator(bounceInterpolator);
    }

    @Override
    public int getItemCount() {
        return menuItemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv;
        TextView priceTv;
        TextView starTv;
        RatingBar ratingBar;
        ImageView menuImgView;
        ToggleButton heartBtn;
        CardView menuCardView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.menu_nameTv);
            priceTv = itemView.findViewById(R.id.menu_priceTv);
            starTv = itemView.findViewById(R.id.menu_starTv);
            ratingBar = itemView.findViewById(R.id.menu_ratingBar);
            menuImgView = itemView.findViewById(R.id.menu_imgView);
            heartBtn = itemView.findViewById(R.id.menu_heartBtn);
            menuCardView = itemView.findViewById(R.id.menu_cardView);
        }
    }
}
