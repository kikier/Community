package com.kikier.community.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kikier.community.DataDao;
import com.kikier.community.NewsAdapter;
import com.kikier.community.R;

import java.util.ArrayList;
import java.util.HashMap;

public class SaleHouseActivity extends BaseActivity {
    TextView head_title;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale_house);
        head_title = (TextView) findViewById(R.id.head_back_title);
        list = (ListView) findViewById(R.id.listView);
        head_title.setText("房屋租售");
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<HashMap<String,Object>> data = DataDao.loadData(SaleHouseActivity.this, "nl", new String[]{"title", "time", "id"});
                if(data!=null){
                    NewsAdapter adapter = new NewsAdapter(SaleHouseActivity.this,R.layout.house_row,data);
                    list.setAdapter(adapter);
                }else{
                    Toast.makeText(SaleHouseActivity.this, "请检查网络设置", Toast.LENGTH_SHORT).show();
                }
            }
        }).start();

    }

    public void back(View v){
        finish();
    }
}
