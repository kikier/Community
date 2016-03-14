package com.kikier.community.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.kikier.community.ContactAdapter;
import com.kikier.community.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactActivity extends AppCompatActivity {
    TextView head_title;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        head_title = (TextView) findViewById(R.id.head_back_title);
        head_title.setText("便民通讯录");
        listView = (ListView) findViewById(R.id.contact_list);
        ArrayList<HashMap<String,Object>> data = null;
        ArrayList<HashMap<String,Object>> contentData = null;
        data = new ArrayList<>();

        contentData = new ArrayList<>();
        for(int i = 0 ;i<5;i++){
            HashMap<String,Object> row2 = new HashMap<>();
            row2.put("name","ds"+i);
            row2.put("id","ss"+i);
            contentData.add(row2);
        }

        for(int i = 0;i<5;i++){
            HashMap<String,Object> row = new HashMap<>();
            row.put("type","最热搜索"+i);
            row.put("content",contentData);
            data.add(row);
        }
        ContactAdapter adapter = new ContactAdapter(this,data);
//        int[] to = {R.id.contact_row_type,R.id.contact_grid};
//        SimpleAdapter adapter = new SimpleAdapter(this,data,R.layout.contact_row,from,to);
        listView.setAdapter(adapter);
    }
    public void back(View v){
        finish();
    }
}
