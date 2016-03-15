package com.kikier.community.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.kikier.community.R;

import java.util.ArrayList;
import java.util.HashMap;

public class UsedMarketPublishActivity extends BaseActivity {
    GridView grid;
    TextView head ;
    final int PICK_PIC = 314;
    SimpleAdapter adapter;
    ArrayList<HashMap<String,Object>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_used_market_publish);
        head = (TextView) findViewById(R.id.head_back_title);
        head.setText("发布二手闲置");
        grid = (GridView) findViewById(R.id.used_edit_grid);
        data = new ArrayList<>();
        String[] from={"pic"};
        int[] to = {R.id.used_market_grid_item_pic};
        adapter = new SimpleAdapter(this,data,R.layout.used_market_publish_grid,from,to);
        grid.setAdapter(adapter);

    }
    public void addPic(View v){
        Intent it = new Intent();
        it.setAction(Intent.ACTION_PICK);
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String type = "image/*";
        it.setDataAndType(uri,type);
        startActivityForResult(it,PICK_PIC);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == PICK_PIC){
            if(resultCode==RESULT_OK){
                Uri uri = data.getData();
                HashMap<String,Object> row = new HashMap<>();
                row.put("pic",uri);
                this.data.add(row);
                adapter.notifyDataSetChanged();
            }
        }
    }

    public void publish(View v){

    }

    public void back(View v){
        finish();
    }
}
