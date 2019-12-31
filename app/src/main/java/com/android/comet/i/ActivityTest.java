package com.android.comet.i;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.android.comet.I.library.BaseActivity;

import static com.android.comet.I.library.Utility.GetIntent;
import static com.android.comet.I.library.Utility.Toast;

public class ActivityTest extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toast(GetIntent("int") + "");
    }

    @Override
    protected Activity SetActivity() {
        return this;
    }

    @Override
    public void onClick(View v) {

    }

}
