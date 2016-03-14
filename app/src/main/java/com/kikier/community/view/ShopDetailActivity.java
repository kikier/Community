package com.kikier.community.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kikier.community.R;

public class ShopDetailActivity extends AppCompatActivity {
    ImageView pic;
    TextView name;
    TextView time;
    TextView address;
    TextView info;
    ImageView showPic;
    TextView phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);
        pic = (ImageView) findViewById(R.id.shop_detail_pic);
        name = (TextView) findViewById(R.id.shop_detail_name);
        time = (TextView) findViewById(R.id.shop_detail_time);
        address = (TextView) findViewById(R.id.shop_detail_info);
        info = (TextView) findViewById(R.id.shop_detail_info);
        showPic = (ImageView) findViewById(R.id.shop_detail_showPic);
        phone = (TextView) findViewById(R.id.shop_detail_phone);
        Intent it = getIntent();
//        it.getExtra
//        pic.setImageBitmap();
//        name.setText();
//        time.setText("营业时间：");
//        address.setText();
//        info.setText();
//        showPic.setImageBitmap();
//        phone.setText();
    }
    public void call(View view){
        Intent it = new Intent();
        it.setAction(Intent.ACTION_DIAL);
        it.setData(Uri.parse("tel:"+phone.getText()));
        startActivity(it);
    }

    public void back(View v){
        finish();
    }

}
