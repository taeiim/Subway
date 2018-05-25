package com.example.parktaeim.subway.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parktaeim.subway.Fragment.MenuFragment;
import com.example.parktaeim.subway.Model.MenuCategoryItem;
import com.example.parktaeim.subway.R;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 26..
 */

public class MenuCategoryAdapter extends RecyclerView.Adapter<MenuCategoryAdapter.ViewHolder> {

    private boolean isCategoryChecked = false;
    private ArrayList<MenuCategoryItem> menuCategoryItemArrayList = new ArrayList<>();

    public MenuCategoryAdapter(ArrayList<MenuCategoryItem> menuCategoryItemArrayList) {
        this.menuCategoryItemArrayList = menuCategoryItemArrayList;
    }

    @Override
    public MenuCategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu_category,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MenuCategoryAdapter.ViewHolder holder, int position) {
        holder.categoryTitleTv.setText(menuCategoryItemArrayList.get(position).getCategoryTitle());
        holder.categoryImgView.setImageResource(menuCategoryItemArrayList.get(position).getCategoryImgView());
        if(position==0) holder.categoryEdge.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return menuCategoryItemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryTitleTv;
        ImageView categoryImgView;
        ImageView categoryEdge;

        public ViewHolder(View itemView) {
            super(itemView);
            categoryTitleTv = (TextView) itemView.findViewById(R.id.menuCategory_titleTv);
            categoryImgView = (ImageView) itemView.findViewById(R.id.menuCategory_categoryImgView);
            categoryEdge = (ImageView) itemView.findViewById(R.id.menuCategory_titleEdge);

        }
    }

    public void categoryGone(MenuCategoryAdapter.ViewHolder holder){
        holder.categoryEdge.setVisibility(View.GONE);

    }

}
