package com.kikier.community.view;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kikier.community.DataDao;
import com.kikier.community.R;

import java.util.ArrayList;
import java.util.HashMap;


public class DetailActivity extends AppCompatActivity {
    TextView tv_author;
    TextView tv_time;
    TextView tv_content;
    TextView tv_title;
    TextView tv_phone;
//    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        init();
        getData();
    }

    //初始化数据
    public void init(){
        tv_title = (TextView) findViewById(R.id.news_title);
        tv_author = (TextView) findViewById(R.id.news_author);
        tv_time = (TextView) findViewById(R.id.news_time);
        tv_content = (TextView) findViewById(R.id.news_content);
        tv_phone = (TextView) findViewById(R.id.news_phone);

    }
    public void back(View v){
        finish();
    }

    //获取数据
    public void getData(){
        Intent it = getIntent();
        int id = it.getIntExtra("id", 0);
        String[] params = {"title","author","time","content","phone"};
        ArrayList<HashMap<String,Object>> data= DataDao.loadData(this, "nid=" + id,params);
//        cursor = DBDao.query(this,"news",new String[]{"title","author","time","content"},"_id = ?",new String[]{id+""},null,null,null);
//        cursor.moveToFirst();
        HashMap<String,Object> map = data.get(0);
        tv_title.setText(map.get("title").toString());
        tv_author.setText(map.get("author").toString());
        String time = map.get("time").toString();
//        time = time.substring(0,time.indexOf(" "));
        tv_time.setText(time);
        tv_content.setText(map.get("content").toString());
    }


}
