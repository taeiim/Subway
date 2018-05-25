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
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;

/**
 * Created by parktaeim on 2018. 4. 29..
 */

public class SettingsActivity extends AppCompatActivity {

    private RelativeLayout logoutBtn;
    private RelativeLayout aboutDeveloperBtn;
    private RelativeLayout bugReportBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ImageView backIcon = (ImageView) findViewById(R.id.settings_backIcon);
        logoutBtn = (RelativeLayout) findViewById(R.id.settings_logout);
        aboutDeveloperBtn = (RelativeLayout) findViewById(R.id.settings_aboutDevelper);
        bugReportBtn = (RelativeLayout) findViewById(R.id.settings_bugReport);

        backIcon.setOnClickListener(v->finish());
        aboutDeveloperBtn.setOnClickListener(v->startActivity(new Intent(this,AboutDevelperActivity.class)));



        setUpLogOut();
        setUpBugReport();

    }

    private void setUpBugReport() {
        bugReportBtn.setOnClickListener(v->{
            BugReportDialog logoutDialog = new BugReportDialog();

        });
    }

    private void setUpLogOut() {
        logoutBtn.setOnClickListener(v-> {
            //Dialog Show


            UserManagement.requestLogout(new LogoutResponseCallback() {
                @Override
                public void onCompleteLogout() {
                    finish();
                    startActivity(new Intent(SettingsActivity.this, LoginActivity.class));
                }
            });
        });
    }
}
