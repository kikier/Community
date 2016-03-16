package com.kikier.community.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.kikier.community.NewsAdapter;
import com.kikier.community.R;

import java.util.ArrayList;
import java.util.HashMap;

public class RecreationActivity extends BaseActivity {
    TextView head_title;
    ListView list;
    NewsAdapter adapter;
    ArrayList<HashMap<String,Object>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recreation);
        head_title = (TextView) findViewById(R.id.head_back_title);
        head_title.setText("休闲生活");
        data = new ArrayList<>();
        list = (ListView) findViewById(R.id.recreation_list);
        adapter = new NewsAdapter(this,R.layout.news_row,data);


    }
    public void back(View v){
        finish();
    }

    public void edit(View v){

    }
}
