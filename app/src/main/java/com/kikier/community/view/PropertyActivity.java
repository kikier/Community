package com.kikier.community.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.kikier.community.AdThread;
import com.kikier.community.DataDao;
import com.kikier.community.NewsAdapter;
import com.kikier.community.R;

import java.util.ArrayList;
import java.util.HashMap;

public class PropertyActivity extends AppCompatActivity {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        list = (ListView) findViewById(R.id.list);
        Thread thread = new Thread(new AdThread(this));
        thread.start();
        String[] params = {"title","time","id"};
        ArrayList<HashMap<String,Object>> data=DataDao.loadData(this, "nl", params);
        NewsAdapter adapter = new NewsAdapter(this,R.layout.news_row,data);
        list.setAdapter(adapter);
    }
    public void workGuide(View v){

    }

    public void lostAndFound(View v){

    }

    public void interact(View v){

    }


}
