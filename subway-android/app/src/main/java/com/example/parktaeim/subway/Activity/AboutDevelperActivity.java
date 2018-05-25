package com.example.parktaeim.subway.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.parktaeim.subway.R;

/**
 * Created by parktaeim on 2018. 4. 29..
 */

public class AboutDevelperActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutdeveloper);

        ImageView backIcon = (ImageView) findViewById(R.id.aboutDeveloper_backIcon);
        backIcon.setOnClickListener(v->finish());

    }
}
