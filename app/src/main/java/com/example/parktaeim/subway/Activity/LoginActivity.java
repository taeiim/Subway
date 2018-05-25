package com.example.parktaeim.subway.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.parktaeim.subway.R;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.usermgmt.LoginButton;
import com.kakao.util.exception.KakaoException;

/**
 * Created by parktaeim on 2018. 4. 29..
 */

public class LoginActivity extends AppCompatActivity {

    SessionCallback sessionCallback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setUpKakaoLogin();

        ImageView cancelBtn = (ImageView) findViewById(R.id.login_cancelBtn);
        cancelBtn.setOnClickListener(v -> finish());

    }

    private void setUpKakaoLogin() {
        LoginButton kakaoLoginBtnOriginal = (LoginButton) findViewById(R.id.kakaoLoginBtnOriginal);
        RelativeLayout kakaoLoginBtn = (RelativeLayout) findViewById(R.id.kakaoLoginBtn);
        kakaoLoginBtn.setOnClickListener(v -> kakaoLoginBtnOriginal.performClick());

        sessionCallback = new SessionCallback();
        Session.getCurrentSession().addCallback(sessionCallback);
        Session.getCurrentSession().checkAndImplicitOpen();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Session.getCurrentSession().removeCallback(sessionCallback);
    }

   private class SessionCallback implements ISessionCallback{

       @Override
       public void onSessionOpened() {
           Intent intent = new Intent(LoginActivity.this,KakaoSignUpActivity.class);
           startActivity(intent);
       }

       @Override
       public void onSessionOpenFailed(KakaoException exception) {
           if(exception != null) {
               Log.d("onSessionOpenFailed== ",exception.getMessage());
           }
       }
   }
}
