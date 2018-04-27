package com.example.parktaeim.subway.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.parktaeim.subway.Adapter.MenuAdapter;
import com.example.parktaeim.subway.Adapter.MenuCategoryAdapter;
import com.example.parktaeim.subway.Model.MenuCategoryItem;
import com.example.parktaeim.subway.Model.MenuItem;
import com.example.parktaeim.subway.R;
import com.example.parktaeim.subway.RecyclerViewClickListener;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 15..
 */

public class MenuFragment extends Fragment {
    private View rootView;
    private RecyclerView menuRecyclerView;
    private RecyclerView categoryRecyclerView;
    private MenuAdapter adapter;
    private MenuCategoryAdapter categoryAdapter;
    private GridLayoutManager layoutManager;
    private RecyclerView.LayoutManager categoryLayoutManager;
    private ArrayList<MenuItem> menuItemArrayList = new ArrayList<>();
    private ArrayList<MenuCategoryItem> menuCategoryItemArrayList = new ArrayList<>();

    private TabLayout.Tab tab1;
    private TabLayout.Tab tab2;
    private TabLayout.Tab tab3;
    private TabLayout.Tab tab4;
    private TabLayout.Tab tab5;
    private TabLayout.Tab tab6;
    private TabLayout.Tab tab7;
    TabLayout categoryTablayout;

    private int currentCategory=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        setUpMenuRecyclerView();
        setUpMenuCategory();

        return rootView;
    }

    private void setUpMenuCategory() {
        // setting RecyclerView
        categoryRecyclerView = (RecyclerView) rootView.findViewById(R.id.menu_category_recyclerView);
        categoryLayoutManager = new LinearLayoutManager(getContext(), LinearLayout.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(categoryLayoutManager);

        String[] titleArr = {"샌드위치", "찹샐러드", "추가토핑", "사이드,음료", "단체메뉴", "재료소개"};
        int[] imgArr = {R.drawable.ic_menu_sandwich, R.drawable.ic_menu_salad, R.drawable.ic_menu_topping, R.drawable.ic_menu_drink, R.drawable.ic_menu_group, R.drawable.ic_menu_foodstuff};
        for (int i = 0; i < titleArr.length; i++) {
            menuCategoryItemArrayList.add(new MenuCategoryItem(imgArr[i], titleArr[i]));
        }

        categoryAdapter = new MenuCategoryAdapter(menuCategoryItemArrayList);
        categoryRecyclerView.setAdapter(categoryAdapter);

        //Setting TabLayout
        categoryTablayout = (TabLayout) rootView.findViewById(R.id.menu_category_tabLayout);

        tab1 = categoryTablayout.newTab();
        tab2 = categoryTablayout.newTab();
        tab3 = categoryTablayout.newTab();
        tab4 = categoryTablayout.newTab();
        tab5 = categoryTablayout.newTab();
        tab6 = categoryTablayout.newTab();
        tab7 = categoryTablayout.newTab();

        TabLayout.Tab[] tabs= {tab1, tab2, tab3, tab4, tab5, tab6, tab7};
        for (int i = 0; i < tabs.length; i++) {
            categoryTablayout.addTab(tabs[i]);
        }

        setUpTabText(0,tabs);
        // 1 Category RecyclerView Click Color Setting
        categoryRecyclerView.addOnItemTouchListener(new RecyclerViewClickListener(getContext(), categoryRecyclerView, new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                setTabLayoutEdge(position);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }

    public void setTabLayoutEdge(int currentCategory){
        TabLayout.Tab[] tabs= {tab1, tab2, tab3, tab4, tab5, tab6, tab7};

        for(int i=0; i<=5; i++){
            categoryRecyclerView.getChildAt(i).findViewById(R.id.menuCategory_titleEdge).setVisibility(View.GONE);
            TextView titleTv = categoryRecyclerView.getChildAt(i).findViewById(R.id.menuCategory_titleTv);
            titleTv.setTextColor(Color.rgb(170,170,170));
        }
        categoryRecyclerView.getChildAt(currentCategory).findViewById(R.id.menuCategory_titleEdge).setVisibility(View.VISIBLE);
        TextView titleTv = categoryRecyclerView.getChildAt(currentCategory).findViewById(R.id.menuCategory_titleTv);
        titleTv.setTextColor(Color.rgb(2,149,69));
        setUpTabText(currentCategory,tabs);
    }

    private void setUpTabText( int currentCategory, TabLayout.Tab[] tabs) {
        String[] sandwichTabs = {"전체", "신제품","프로모션","클래식","프레쉬&라이트","프리미엄","아침메뉴"};
        String[] saladTabs = {"전체", "신제품","클래식","프레쉬&라이트","프리미엄"};
        String[] drinkTabs = {"전체","사이드메뉴","음료"};
        String[] groupTabs = {"전체","샌드위치","쿠키"};
        String[] stuffTabs = {"전체","빵","채소","치즈","소스"};
        categoryTablayout.setVisibility(View.VISIBLE);

        String[] tabTexts = sandwichTabs;
        switch (currentCategory){
            case 0:
                tabTexts = sandwichTabs;
                break;
            case 1:
                tabTexts = saladTabs;
                break;
            case 2:
                categoryTablayout.setVisibility(View.GONE);
                break;
            case 3:
                tabTexts = drinkTabs;
                break;
            case 4:
                tabTexts = groupTabs;
                break;
            case 5:
                tabTexts = stuffTabs;
                break;
        }

        int maxTabSize = 7;
        int tabCnt = tabTexts.length;
        int emptyTabCnt = maxTabSize - tabCnt;

        for (int i = 0; i < tabCnt; i++) {
            tabs[i].setText(tabTexts[i]);
            setUpTabWidthAndClick(i,true);
        }
        if(emptyTabCnt>0){
            for(int i=tabCnt; i<maxTabSize; i++){
                tabs[i].setText("");
                setUpTabWidthAndClick(i,false);
            }
        }

    }

    private void setUpTabWidthAndClick(int childNum, boolean isClick){
        LinearLayout layout = ((LinearLayout) ((LinearLayout)categoryTablayout.getChildAt(0)).getChildAt(childNum));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layout.getLayoutParams();
        layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT;
        layout.setClickable(isClick);
    }

    private void setUpMenuRecyclerView() {
        menuRecyclerView = rootView.findViewById(R.id.menu_recyclerView);
        layoutManager = new GridLayoutManager(getContext(), 2);
        menuRecyclerView.setLayoutManager(layoutManager);

        menuItemArrayList.add(new MenuItem("dslkj", "비엘티", "4800원", 4.0f));
        menuItemArrayList.add(new MenuItem("dslkj", "비엘티", "4800원", 2.0f));
        menuItemArrayList.add(new MenuItem("dslkj", "비엘티", "4800원", 3.0f));
        menuItemArrayList.add(new MenuItem("dslkj", "비엘티", "4800원", 4.0f));
        menuItemArrayList.add(new MenuItem("dslkj", "비엘티", "4800원", 4.0f));

        adapter = new MenuAdapter(menuItemArrayList);
        menuRecyclerView.setAdapter(adapter);

    }
}
