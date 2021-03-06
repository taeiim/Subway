package com.example.parktaeim.subway.Dialog;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.parktaeim.subway.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by parktaeim on 2018. 4. 19..
 */

public class StoreDetailDialog extends android.support.v4.app.DialogFragment implements OnMapReadyCallback{
    private View rootView;
    private TextView nameTv;
    private TextView addressTv;
    private TextView openTimeTv;
    private TextView tellNumTv;
    private TextView open24Icon;
    private TextView findRoadBtn;
    private ImageView callIcon;
    private RelativeLayout cancelBtn;
    private GoogleMap googleMap;

    private String storeName;

    public StoreDetailDialog() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.dialog_store_detail, container,false);

//        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.storeDialog_googleMap);
//        mapFragment.getMapAsync(this);

        nameTv = (TextView) rootView.findViewById(R.id.storeDialog_storeNameTv);
        addressTv = (TextView) rootView.findViewById(R.id.storeDialog_addressTv);
        openTimeTv = (TextView) rootView.findViewById(R.id.storeDialog_timeTv);
        tellNumTv = (TextView) rootView.findViewById(R.id.storeDialog_tellNumTv);
        open24Icon = (TextView) rootView.findViewById(R.id.storeDialog_24Icon);
        findRoadBtn = (TextView) rootView.findViewById(R.id.storeDialog_findRoadBtn);
        callIcon = (ImageView) rootView.findViewById(R.id.storeDialog_callIcon);
        cancelBtn = (RelativeLayout) rootView.findViewById(R.id.cancel_button);

        setDialog();

        return rootView;
    }

    private void setDialog() {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Bundle getArgs = getArguments();
        String tellNum = getArgs.getString("tellNum");
        String openingTime = getArgs.getString("openingTime");
        storeName = getArgs.getString("name");

        nameTv.setText(storeName);
        addressTv.setText(getArgs.getString("address"));
        tellNumTv.setText(tellNum);
        openTimeTv.setText(openingTime);

        if (openingTime.equals("00:00 ~ 24:00")) open24Icon.setVisibility(View.VISIBLE);
        callIcon.setOnClickListener(v -> startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + tellNum))));
        cancelBtn.setOnClickListener(v -> dismiss());

    }

    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;
        LatLng seoul = new LatLng(37.540705,126.956764);
        googleMap.addMarker(new MarkerOptions().position(seoul).title(storeName));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(seoul));
    }
}
