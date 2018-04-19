package com.example.parktaeim.subway.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.parktaeim.subway.R;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 19..
 */

public class BannerPagerAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<Drawable> bannerImgArrayList;

    public BannerPagerAdapter(Context context, ArrayList<Drawable> bannerImgArrayList) {
        this.context = context;
        this.bannerImgArrayList = bannerImgArrayList;
    }

    @Override
    public int getCount() {
        Log.d("banner img list size===",String.valueOf(bannerImgArrayList.size()));
        return bannerImgArrayList.size();
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_honey_banner,container,false);
        ImageView imageView = (ImageView) view.findViewById(R.id.honey_banner_imgView);
        imageView.setImageDrawable(bannerImgArrayList.get(position));
        ((ViewPager)container).addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
