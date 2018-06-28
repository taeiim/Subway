package com.example.parktaeim.subway.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parktaeim.subway.R;

/**
 * Created by parktaeim on 2018. 4. 17..
 */

public class EventDetailActivity extends AppCompatActivity {
    private TextView titleTv;
    private TextView periodTv;
    private ImageView eventImgView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        titleTv = (TextView) findViewById(R.id.eventDetail_titleTv);
        periodTv = (TextView) findViewById(R.id.eventDetail_periodTv);
        eventImgView = (ImageView) findViewById(R.id.eventDetail_imgView);

        Intent intent=new Intent(this.getIntent());
        titleTv.setText(intent.getStringExtra("eventTitle"));
        periodTv.setText(intent.getStringExtra("eventPeriod"));
        eventImgView.setImageResource(intent.getIntExtra("bigImg",R.drawable.img_event_aborseseries));

        ImageView backIcon = (ImageView) findViewById(R.id.eventDetail_backIcon);
        backIcon.setOnClickListener(v->finish());
    }
}
