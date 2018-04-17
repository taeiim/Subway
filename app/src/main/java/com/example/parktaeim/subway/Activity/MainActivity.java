package com.example.parktaeim.subway.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.parktaeim.subway.Fragment.EventFragment;
import com.example.parktaeim.subway.Fragment.HoneyFragment;
import com.example.parktaeim.subway.Fragment.MenuFragment;
import com.example.parktaeim.subway.Fragment.MypageFragment;
import com.example.parktaeim.subway.Fragment.StoreFragment;
import com.example.parktaeim.subway.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.main_tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("꿀조합").setIcon(R.drawable.icon_menu));
        tabLayout.addTab(tabLayout.newTab().setText("메뉴"));
        tabLayout.addTab(tabLayout.newTab().setText("매장찾기"));
        tabLayout.addTab(tabLayout.newTab().setText("이벤트"));
        tabLayout.addTab(tabLayout.newTab().setText("마이페이지"));

//        for (int i = 0; i < tabLayout.getTabWidget().getChildCount(); i++)
//        {
//            tabLayout.getTabWidget().getChildAt(i).setPadding(10,10,10,10);
//        }

        setUpFragment(new HoneyFragment());
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0){
                    setUpFragment(new HoneyFragment());
                } else if(tab.getPosition() == 1){
                    setUpFragment(new MenuFragment());
                } else if(tab.getPosition() == 2){
                    setUpFragment(new StoreFragment());
                } else if(tab.getPosition() == 3){
                    setUpFragment(new EventFragment());
                } else if(tab.getPosition() == 4){
                    setUpFragment(new MypageFragment());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction =fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container,fragment);

        transaction.commit();
    }
}
