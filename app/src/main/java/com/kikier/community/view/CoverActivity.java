package com.kikier.community.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kikier.community.R;

public class CoverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);
    }
    public void back(View v){
        finish();
    }
}
