package com.example.parktaeim.subway;

import android.app.Activity;
import android.app.Application;

import com.example.parktaeim.subway.Adapter.KakaoSDKAdapter;
import com.kakao.auth.KakaoSDK;

/**
 * Created by parktaeim on 2018. 5. 15..
 */

public class GlobalApplication extends Application {

    private static volatile GlobalApplication obj = null;
    private static volatile Activity currentActivity = null;

    @Override
    public void onCreate() {
        super.onCreate();
        obj = this;
        KakaoSDK.init(new KakaoSDKAdapter());
    }

    public static GlobalApplication getGlobalApplicationContext() {
        return obj;
    }

    public static Activity getCurrentActivity() {
        return currentActivity;
    }

    public static void setCurrentActivity(Activity currentActivity) {
        GlobalApplication.currentActivity = currentActivity;
    }
}
