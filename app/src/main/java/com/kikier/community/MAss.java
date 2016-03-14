package com.kikier.community;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Yz on 2016/3/7.
 */
public class MAss extends BaseAdapter {
    private ArrayList<HashMap<String,Object>> datas;
    private Context context;
    public MAss(Context context,ArrayList<HashMap<String,Object>> datas){
        this.datas =datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HashMap<String,Object> row  = datas.get(position);
        ViewHolder holder ;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.news_row,null);
            holder.pic = (ImageView) convertView.findViewById(R.id.pic);
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_title);
            holder.tv_age = (TextView) convertView.findViewById(R.id.tv_time);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        try {
            holder.tv_name.setText(row.get("name").toString());
            holder.tv_age.setText(row.get("age").toString());
            String pic_path = "http://192.168.2.108:8080/newer/"+row.get("pic");
            InputStream is = new URL(pic_path).openStream();
            Bitmap bitmap = BitmapFactory.decodeStream(is) ;//内存
            holder.pic.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convertView;
    }
    class ViewHolder{
        ImageView pic;
        TextView tv_name;
        TextView tv_age;
    }

}
