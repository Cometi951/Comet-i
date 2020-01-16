package com.android.comet.I.library;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import static com.android.comet.I.library.Constant.constant;
import static com.android.comet.I.library.Constant.handler;
import static com.android.comet.I.library.Constant.sharedPreferences;
import static com.android.comet.I.library.Constant.sharedPreferencesEditor;
import static com.android.comet.I.library.Constant.utility;
import static com.android.comet.I.library.Utility.SetCurrentActivity;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    public RecyclerView recyclerView;
    public Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        init();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        init();
    }

    protected abstract Activity SetActivity();

    private synchronized void init() {
        activity = SetActivity();
        SetCurrentActivity(activity);
        if (constant == null) constant = new Constant();
        if (utility == null) utility = new Utility();
        if (handler == null) handler = new Handler(Looper.getMainLooper());
        if (sharedPreferences == null)
            sharedPreferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        if (sharedPreferencesEditor == null) {
            sharedPreferencesEditor = sharedPreferences.edit();
            sharedPreferencesEditor.apply();
        }
    }

}