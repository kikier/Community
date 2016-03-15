package com.kikier.community.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.kikier.community.R;
import com.kikier.community.ShopListAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ShopActivity extends BaseActivity implements AdapterView.OnItemClickListener{
    TextView head_title;
    GridView grid;
    ListView list;
    ArrayList<HashMap<String,Object>> gridData;
    ArrayList<HashMap<String,Object>> listData;
    HashMap<String,Object> row ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        init();

        gridData = new ArrayList<>();
        for(int i = 0; i<6;i++){
            row = new HashMap<>();
            row.put("id",i);
            row.put("name",i+"号店");
            gridData.add(row);
        }

        String[] from = {"name"};
        int[] to = {R.id.name};
        SimpleAdapter gridAdapter = new SimpleAdapter(this,gridData,R.layout.contact_row_detail,from,to);
        grid.setAdapter(gridAdapter);
        grid.setOnItemClickListener(this);

        listData = new ArrayList<>();
        for(int i = 0;i<10;i++){
            row = new HashMap<>();
            row.put("name","好好吃"+i);
            row.put("info","很好吃"+i);
            row.put("phone",34353+i);
            row.put("count",i);
            listData.add(row);
        }
        ShopListAdapter adapter = new ShopListAdapter(this,listData);
        list.setAdapter(adapter);
        list.setDividerHeight(10);
        list.setMinimumHeight(90);
    }

    public void init(){
        head_title = (TextView) findViewById(R.id.head_back_title);
        grid = (GridView) findViewById(R.id.shop_grid);
        list = (ListView) findViewById(R.id.shop_list);
        head_title.setText("社区商店");
    }


    public void back(View v){
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        HashMap<String,Object> row = gridData.get(position);
        int rid = (int) row.get("id");
        Intent it = new Intent(this,ContactDetailActivity.class);
        it.putExtra("id",rid);
        startActivity(it);
//        Toast.makeText(ShopActivity.this, position, Toast.LENGTH_SHORT).show();
    }
}
