package com.android.comet.I.library;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
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
    protected void onResume() {
        super.onResume();
        init();
    }

    protected abstract Activity SetActivity();

    private synchronized void init() {
        activity = SetActivity();
        SetCurrentActivity(activity);
        if (constant == null) constant = new Constant();
        if (utility == null) utility = new Utility();
        if (handler == null) handler = new Handler();
        if (sharedPreferences == null)
            sharedPreferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        if (sharedPreferencesEditor == null) {
            sharedPreferencesEditor = sharedPreferences.edit();
            sharedPreferencesEditor.apply();
        }
    }

    /*

    protected void startActivity(Class aClass, int flags) {
        startActivity(aClass, flags, -1, -1);
    }



    public void showProgressDialog() {
        try {
            pDialog = new ProgressDialog(activity);
            pDialog.setMessage("Loading");
            pDialog.setCancelable(false);
            pDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showProgressDialog(Context context, boolean isCancelable, String message) {
        try {
            pDialog = new ProgressDialog(context);
            pDialog.setMessage(message);
            pDialog.setCancelable(isCancelable);
            pDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isLoading() {
        if (pDialog != null)
            if (pDialog.isShowing())
                return true;
            else
                return false;
        return false;
    }

    public void dismissProgressDialog() {
        pDialog.dismiss();
        pDialog.cancel();
    }*/


}
