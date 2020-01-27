package com.android.comet.i;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.android.comet.I.library.BaseActivity;

import java.util.ArrayList;
import static com.android.comet.I.library.Utility.StartFragment;

public class MainActivity extends BaseActivity {

    ArrayList<ModelTest> arrayList;

    Button button_1, button_2;
    FrameLayout frameL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        frameL = findViewById(R.id.frame);
        button_2.setOnClickListener(this);
    }

    @Override
    protected Activity SetActivity() {
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_2:
                StartFragment(new FragmentTest(), R.id.frame);
                break;
        }
    }


}
