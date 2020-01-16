package com.android.comet.I.library;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Set;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.android.comet.I.library.Constant.handler;
import static com.android.comet.I.library.Constant.sharedPreferences;
import static com.android.comet.I.library.Constant.sharedPreferencesEditor;


// Created by Milan Vadgama :)


public class Utility {


    public static Activity activity;
    private static boolean NeedToClearActivity = false, NeedToResultActivity = false;
    private static int RequestCodes;

    // by default will Execute while switching Activity
    public static void SetCurrentActivity(Activity SetActivity) {
        activity = SetActivity;
    }



    // StatusBar functions
    public static void StatusBarHide() {
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        activity.getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
    }

    public static void StatusTransparent() {
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }



    // Toast functions
    public static void Toast(final String Message) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, Message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void Toast(final String Message, final int duration) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, Message, duration).show();
            }
        });
    }



    // StartActivity functions
    public static void StartActivity(Class c) {
        activity.startActivity(new Intent(activity, c));
    }

    public static void StartActivity(String URL) {
        activity.startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(URL)));
    }

    public static void StartActivity(Class c, int RequestCode) {
        activity.startActivityForResult(new Intent(activity, c), RequestCode);
    }

    public static void StartActivity(Class c, String[] Keys, Object[] Values) {
        Intent intent = !NeedToClearActivity ? new Intent(activity, c) : new Intent(activity, c).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        NeedToClearActivity = false;
        for (int i = 0; i < Keys.length; i++) {
            if (Values[i] instanceof String)
                intent.putExtra(Keys[i], (String) Values[i]);
            else if (Values[i] instanceof Integer)
                intent.putExtra(Keys[i], (Integer) Values[i]);
            else if (Values[i] instanceof Float)
                intent.putExtra(Keys[i], (Float) Values[i]);
            else if (Values[i] instanceof Double)
                intent.putExtra(Keys[i], (Double) Values[i]);
            else if (Values[i] instanceof Short)
                intent.putExtra(Keys[i], (Short) Values[i]);
            else if (Values[i] instanceof Long)
                intent.putExtra(Keys[i], (Long) Values[i]);
            else if (Values[i] instanceof Boolean)
                intent.putExtra(Keys[i], (Boolean) Values[i]);
            else if (Values[i] instanceof Serializable)
                intent.putExtra(Keys[i], (Serializable) Values[i]);
            else if (Values[i] instanceof String[])
                intent.putExtra(Keys[i], (String[]) Values[i]);
            else if (Values[i] instanceof Integer[])
                intent.putExtra(Keys[i], (Integer[]) Values[i]);
            else if (Values[i] instanceof Float[])
                intent.putExtra(Keys[i], (Float[]) Values[i]);
            else if (Values[i] instanceof Double[])
                intent.putExtra(Keys[i], (Double[]) Values[i]);
            else if (Values[i] instanceof Short[])
                intent.putExtra(Keys[i], (Short[]) Values[i]);
            else if (Values[i] instanceof Long[])
                intent.putExtra(Keys[i], (Long[]) Values[i]);
            else if (Values[i] instanceof Boolean[])
                intent.putExtra(Keys[i], (Boolean[]) Values[i]);
            else if (Values[i] instanceof Serializable[])
                intent.putExtra(Keys[i], (Serializable[]) Values[i]);
            else if (Values[i] instanceof Bundle)
                intent.putExtras((Bundle) Values[i]);
            else if (Values[i] instanceof Parcelable)
                intent.putExtra(Keys[i], (Parcelable) Values[i]);
            else if (Values[i] instanceof Parcelable[])
                intent.putExtra(Keys[i], (Parcelable[]) Values[i]);
        }
        if (NeedToResultActivity) {
            activity.startActivityForResult(new Intent(activity, c), RequestCodes);
        } else {
            activity.startActivity(intent);
        }
        NeedToResultActivity = false;
    }

    public static void StartActivity(Class c, int RequestCode, String[] Keys, Object[] Values) {
        RequestCodes = RequestCode;
        NeedToResultActivity = true;
        StartActivity(c, Keys, Values);
    }

    public static void StartActivityWithClearAll(Class c) {
        activity.startActivity(new Intent(activity, c).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
    }

    public static void StartActivityWithClearAll(Class c, String[] Keys, Object[] Values) {
        NeedToClearActivity = true;
        StartActivity(c, Keys, Values);
    }



    // StartFragment functions
    public static void StartFragment(Fragment fragment, int container) {
        FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();
        transaction.replace(container, fragment, fragment.getClass().getSimpleName());
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }

    public static void StartFragment(Fragment fragment, int container, Bundle bundle) {
        FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();
        fragment.setArguments(bundle);
        transaction.replace(container, fragment, fragment.getClass().getSimpleName());
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }

    public static void StartFragment(Fragment fragment, int container, String TAG) {
        FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();
        transaction.replace(container, fragment, TAG);
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }

    public static void StartFragment(Fragment fragment, int container, String TAG, Bundle bundle) {
        FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();
        fragment.setArguments(bundle);
        transaction.replace(container, fragment, TAG);
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }



    // GetIntent functions
    public static Object GetIntent(String Key) {
        if (activity.getIntent() != null) {
            if (activity.getIntent().getStringExtra(Key) != null) {
                return activity.getIntent().getStringExtra(Key);
            } else if (activity.getIntent().getStringArrayExtra(Key) != null) {
                return activity.getIntent().getStringArrayExtra(Key);
            } else if (activity.getIntent().getSerializableExtra(Key) != null) {
                return activity.getIntent().getSerializableExtra(Key);
            } else if (activity.getIntent().getIntArrayExtra(Key) != null) {
                return activity.getIntent().getIntArrayExtra(Key);
            } else if (activity.getIntent().getDoubleArrayExtra(Key) != null) {
                return activity.getIntent().getDoubleArrayExtra(Key);
            } else if (activity.getIntent().getFloatArrayExtra(Key) != null) {
                return activity.getIntent().getFloatArrayExtra(Key);
            } else if (activity.getIntent().getBundleExtra(Key) != null) {
                return activity.getIntent().getBundleExtra(Key);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public static boolean GetIntent(String Key, boolean defaultValue) {
        return activity.getIntent().getBooleanExtra(Key, defaultValue);
    }

    public static int GetIntent(String Key, int defaultValue) {
        return activity.getIntent().getIntExtra(Key, defaultValue);
    }

    public static float GetIntent(String Key, float defaultValue) {
        return activity.getIntent().getFloatExtra(Key, defaultValue);
    }

    public static double GetIntent(String Key, double defaultValue) {
        return activity.getIntent().getDoubleExtra(Key, defaultValue);
    }



    // RecyclerView functions
    public static RecyclerView RecyclerViewVertical(RecyclerView RecycleVertical, int RecyclerId) {
        RecycleVertical = (RecyclerView) activity.findViewById(RecyclerId);
        RecycleVertical.setLayoutManager(new LinearLayoutManager(activity));
        RecycleVertical.setHasFixedSize(true);
        return RecycleVertical;
    }

    public static RecyclerView RecyclerViewHorizontal(RecyclerView RecycleHorizontal, int RecyclerId) {
        RecycleHorizontal = (RecyclerView) activity.findViewById(RecyclerId);
        RecycleHorizontal.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
        RecycleHorizontal.setHasFixedSize(true);
        return RecycleHorizontal;
    }

    public static RecyclerView RecyclerViewVertical(RecyclerView RecycleVertical, int RecyclerId, boolean reverseLayout) {
        RecycleVertical = (RecyclerView) activity.findViewById(RecyclerId);
        RecycleVertical.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, reverseLayout));
        RecycleVertical.setHasFixedSize(true);
        return RecycleVertical;
    }

    public static RecyclerView RecyclerViewHorizontal(RecyclerView RecycleHorizontal, int RecyclerId, boolean reverseLayout) {
        RecycleHorizontal = (RecyclerView) activity.findViewById(RecyclerId);
        RecycleHorizontal.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, reverseLayout));
        RecycleHorizontal.setHasFixedSize(true);
        return RecycleHorizontal;
    }

    public static RecyclerView RecyclerViewGrid(RecyclerView RecycleGrid, int RecyclerId, int ColumnCount) {
        RecycleGrid = (RecyclerView) activity.findViewById(RecyclerId);
        RecycleGrid.setLayoutManager(new GridLayoutManager(activity, ColumnCount));
        RecycleGrid.setHasFixedSize(true);
        return RecycleGrid;
    }



    // SharedPreferences functions
    public static void SavePreference(String Key, String Value) {
        sharedPreferencesEditor.putString(Key, Value).apply();
    }

    public static void SavePreference(String Key, int Value) {
        sharedPreferencesEditor.putInt(Key, Value).apply();
    }

    public static void SavePreference(String Key, float Value) {
        sharedPreferencesEditor.putFloat(Key, Value).apply();
    }

    public static void SavePreference(String Key, boolean Value) {
        sharedPreferencesEditor.putBoolean(Key, Value).apply();
    }

    public static void SavePreference(String Key, Set<String> Value) {
        sharedPreferencesEditor.putStringSet(Key, Value).apply();
    }

    public static String GetPreferenceS(String Key) {
        return sharedPreferences.getString(Key, "");
    }

    public static int GetPreferenceI(String Key) {
        return sharedPreferences.getInt(Key, 0);
    }

    public static float GetPreferenceF(String Key) {
        return sharedPreferences.getFloat(Key, 0.0f);
    }

    public static boolean GetPreferenceB(String Key) {
        return sharedPreferences.getBoolean(Key, false);
    }

    public void ClearPreference() {
        sharedPreferencesEditor.clear().apply();
    }

    public void ClearPreference(String Key) {
        sharedPreferencesEditor.clear().remove(Key).apply();
    }



    // Check Network
    public static boolean InternetAvailable() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;
        ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }


}