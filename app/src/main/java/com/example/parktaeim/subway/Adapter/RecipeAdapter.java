package com.example.parktaeim.subway.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.parktaeim.subway.Model.RecipeRecyclerItem;
import com.example.parktaeim.subway.R;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 5. 5..
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    private ArrayList<RecipeRecyclerItem> recipeItemArrayList = new ArrayList<>();
    private int selectPos;

    public RecipeAdapter(ArrayList<RecipeRecyclerItem> recipeItemArrayList) {
        this.recipeItemArrayList = recipeItemArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe1_menu,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nameTv.setText(recipeItemArrayList.get(position).getTitle());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(selectPos == position){
//                    holder.cardLayout.setBackgroundResource(0);
//                    selectPos = recipeItemArrayList.size() + 1;
//                }else {
//                    holder.cardLayout.setBackgroundResource(0);  //selectPos
//                    holder.cardLayout.setBackgroundResource(R.drawable.solid_yellow_recipecard);  //currentPos
//                    selectPos = position;
//                }
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return recipeItemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTv;
        LinearLayout cardLayout;

        public ViewHolder(View itemView) {
            super(itemView);
//            this.setIsRecyclable(false);
            imageView = (ImageView) itemView.findViewById(R.id.enrollRecycler_imgView);
            nameTv = (TextView) itemView.findViewById(R.id.enrollRecycler_nameTv);
            cardLayout = (LinearLayout) itemView.findViewById(R.id.enrollRecycler_layout);
        }
    }
}
