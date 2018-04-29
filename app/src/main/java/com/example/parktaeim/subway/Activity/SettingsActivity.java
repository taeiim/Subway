package com.example.parktaeim.subway.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.parktaeim.subway.Dialog.BugReportDialog;
import com.example.parktaeim.subway.Dialog.LogoutDialog;
import com.example.parktaeim.subway.R;

/**
 * Created by parktaeim on 2018. 4. 29..
 */

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ImageView backIcon = (ImageView) findViewById(R.id.settings_backIcon);
        RelativeLayout logoutBtn = (RelativeLayout) findViewById(R.id.settings_logout);
        RelativeLayout aboutDeveloperBtn = (RelativeLayout) findViewById(R.id.settings_aboutDevelper);
        RelativeLayout bugReportBtn = (RelativeLayout) findViewById(R.id.settings_bugReport);

        backIcon.setOnClickListener(v->finish());
        logoutBtn.setOnClickListener(v->{
            LogoutDialog logoutDialog = new LogoutDialog();

        });
        aboutDeveloperBtn.setOnClickListener(v->startActivity(new Intent(this,AboutDevelperActivity.class)));
        bugReportBtn.setOnClickListener(v->{
            BugReportDialog logoutDialog = new BugReportDialog();

        });

    }
}
