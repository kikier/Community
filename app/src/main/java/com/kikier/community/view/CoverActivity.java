package com.kikier.community.view;

import android.os.Bundle;
import android.view.View;

import com.kikier.community.R;

public class CoverActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);
    }
    public void back(View v){
        finish();
    }
}
