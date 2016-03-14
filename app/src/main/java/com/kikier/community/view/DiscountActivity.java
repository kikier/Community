package com.kikier.community.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kikier.community.R;

public class DiscountActivity extends AppCompatActivity {
    TextView head_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount);
        head_title = (TextView) findViewById(R.id.head_back_title);
        head_title.setText("优惠折扣");
    }
    public void back(View v){
        finish();
    }
}
