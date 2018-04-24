package com.example.parktaeim.subway.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.parktaeim.subway.R;

import java.util.ArrayList;

/**
 * Created by parktaeim on 2018. 4. 21..
 */

public class SpinnerAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> spinnerData;
    LayoutInflater inflater;


    public SpinnerAdapter(Context context, ArrayList<String> spinnerData){
        this.context = context;
        this.spinnerData = spinnerData;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        if(spinnerData !=null) return spinnerData.size();
        else return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            convertView = inflater.inflate(R.layout.spinner_normal, parent, false);
        }

        if(spinnerData !=null){
            //데이터세팅
            String text = spinnerData.get(position);
            ((TextView)convertView.findViewById(R.id.spinnerTv)).setText(text);
        }

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = inflater.inflate(R.layout.spinner_dropdown, parent, false);
        }

        //데이터세팅
        String text = spinnerData.get(position);
        ((TextView)convertView.findViewById(R.id.spinnerTv)).setText(text);

        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return spinnerData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


}
