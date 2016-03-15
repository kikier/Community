package com.kikier.community.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.kikier.community.ContactDetailAdapter;
import com.kikier.community.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactDetailActivity extends BaseActivity {
    TextView title;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);
        title = (TextView) findViewById(R.id.head_back_title);
        title.setText("详情");
        list= (ListView) findViewById(R.id.contact_detail_list);

        Intent it = getIntent();
        String str = it.getStringExtra("id");

        ArrayList<HashMap<String,Object>> data = new ArrayList<>();
        for(int i =0;i<10;i++){
            HashMap<String,Object> row = new HashMap<>();
            row.put("name","螺蛳粉"+i);
            row.put("address","柳州"+i);
            row.put("phone",453434+i);
            data.add(row);
        }
        ContactDetailAdapter adapter = new ContactDetailAdapter(this,data);
        list.setAdapter(adapter);
    }

    public void back(View v){
        finish();
    }
}
