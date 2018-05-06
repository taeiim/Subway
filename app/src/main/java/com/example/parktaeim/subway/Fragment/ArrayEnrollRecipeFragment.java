package com.example.parktaeim.subway.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.parktaeim.subway.Adapter.RecipeAdapter;
import com.example.parktaeim.subway.Model.RecipeRecyclerItem;
import com.example.parktaeim.subway.R;
import com.example.parktaeim.subway.RecyclerViewClickListener;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 5. 3..
 */

public class ArrayEnrollRecipeFragment extends Fragment {
    int position;
    int selectPos;

    public static ArrayEnrollRecipeFragment newInstance(int position) {
        ArrayEnrollRecipeFragment fragment = new ArrayEnrollRecipeFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments() != null ? getArguments().getInt("position") : 0;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe1 + position, container, false);

        switch (position) {
            case 0:
                RecyclerView menuRecyclerView = (RecyclerView) view.findViewById(R.id.recipe1_menuRecyclerView);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.HORIZONTAL, false);
                menuRecyclerView.setLayoutManager(gridLayoutManager);
                menuRecyclerView.setHasFixedSize(true);

                ArrayList<RecipeRecyclerItem> recipeRecyclerItems = new ArrayList<>();
                for (int i = 0; i < 24; i++) {
                    recipeRecyclerItems.add(new RecipeRecyclerItem("에그마요", "sldkfj"));
                }
                RecipeAdapter recipeAdapter = new RecipeAdapter(recipeRecyclerItems);
                menuRecyclerView.setAdapter(recipeAdapter);

                menuRecyclerView.addOnItemTouchListener(new RecyclerViewClickListener(getContext(), menuRecyclerView, new RecyclerViewClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Log.d("selectPos == ", String.valueOf(selectPos));
                        Log.d("clickPos == ", String.valueOf(position));
//                        menuRecyclerView.getChildAt(position).findViewById(R.id.enrollRecycler_layout).setBackgroundResource(R.drawable.solid_yellow_recipecard);  //currentPos

                        if(selectPos == position){
                            menuRecyclerView.findViewHolderForAdapterPosition(position).itemView.findViewById(R.id.enrollRecycler_layout).setBackgroundResource(0);
                            selectPos = 0;
                        }else {
                            menuRecyclerView.findViewHolderForAdapterPosition(selectPos).itemView.findViewById(R.id.enrollRecycler_layout).setBackgroundResource(0);  //selectPos
                            menuRecyclerView.findViewHolderForAdapterPosition(position).itemView.findViewById(R.id.enrollRecycler_layout).setBackgroundResource(R.drawable.solid_yellow_recipecard);  //currentPos
                            selectPos = position;
                        }
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                }));
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }

        return view;
    }
}
