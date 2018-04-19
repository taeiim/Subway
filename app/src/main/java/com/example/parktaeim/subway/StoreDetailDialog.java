package com.example.parktaeim.subway;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.widget.RelativeLayout;

/**
 * Created by parktaeim on 2018. 4. 19..
 */

public class StoreDetailDialog extends Dialog {
    public StoreDetailDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_store_detail);

        RelativeLayout cancelBtn = (RelativeLayout) findViewById(R.id.cancel_button);
        cancelBtn.setOnClickListener(v->cancel());
    }
}
