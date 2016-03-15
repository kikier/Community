package com.kikier.community.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kikier.community.R;

public class AboutUsActivity extends BaseActivity {
    TextView head_title;
    Intent it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        head_title = (TextView) findViewById(R.id.head_back_title);
        head_title.setText("关于我们");
    }
    public void aboutMeDetail(View v){

    }

    public void register(View v){
        it = new Intent(this,RegisterActivity.class);
        startActivity(it);
    }

    public void update(View v){

    }

    public void exitApp(View v){
        this.exit();
    }


    public void back(View v){
        finish();
    }
}
