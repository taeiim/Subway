package com.example.parktaeim.subway.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.util.exception.KakaoException;

/**
 * Created by parktaeim on 2018. 5. 16..
 */

public class KakaoSignUpActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestMe();
    }

    private void requestMe() {
        UserManagement.requestMe(new MeResponseCallback() {
            @Override
            public void onFailure(ErrorResult errorResult) {
                int ErrorCode = errorResult.getErrorCode();
                int ClientErrorCode = -777;

                if (ErrorCode == ClientErrorCode) {
                    Log.d("errorCode==", "카카오톡 서버의 네트워크 불안정");
                } else {
                    Log.d("TAG", "오류로 카카오로그인 실패 ");
                }
            }

            @Override
            public void onSessionClosed(ErrorResult errorResult) {
                Log.d("TAG", "오류로 카카오로그인 실패 ");
            }

            @Override
            public void onNotSignedUp() {

            }

            @Override
            public void onSuccess(UserProfile result) {
                String profileUrl = result.getProfileImagePath();
                String userId = String.valueOf(result.getId());
                String userNickName = result.getNickname();

                Log.d("ProfileURL==" + profileUrl, "  UserID ==" + userId + "  UserNickName ==" + userNickName);
                Log.d("!!!Profile === ", result.toString());

                redirectMainActivity();
            }
        });
    }

    public void redirectMainActivity(){
        Intent intent = new Intent(KakaoSignUpActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
