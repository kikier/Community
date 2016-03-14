package com.kikier.community.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.kikier.community.DataDao;
import com.kikier.community.NewsAdapter;
import com.kikier.community.R;

import java.util.ArrayList;
import java.util.HashMap;

public class UsedMarketActivity extends AppCompatActivity {
    TextView head_title;
    ListView list;
    ArrayList<HashMap<String,Object>> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_used_market);
        head_title = (TextView) findViewById(R.id.head_back_title);
        head_title.setText("二手市场");
        list = (ListView) findViewById(R.id.used_list);
        new Thread(new Runnable() {
            @Override
            public void run() {
                data = DataDao.loadData(UsedMarketActivity.this,"nl",new String[]{"title","time","id"});
                if(data!=null){
                    NewsAdapter adapter = new NewsAdapter(UsedMarketActivity.this,R.layout.news_row,data);
                    list.setAdapter(adapter);
                }
            }
        }).start();

    }


    public void back(View v){
        finish();
    }
}
