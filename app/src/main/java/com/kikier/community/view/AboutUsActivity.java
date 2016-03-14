package com.kikier.community.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kikier.community.R;

public class AboutUsActivity extends AppCompatActivity {
    TextView head_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        head_title = (TextView) findViewById(R.id.head_back);
        head_title.setText("关于我们");
    }
    public void back(View v){
        finish();
    }
}
