package com.kikier.community;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Yz on 2016/3/3.
 */
public class MainAdapter extends BaseAdapter{
    int[] menuImg;
    String[] menuName;
    Context context;
    public MainAdapter(Context context, int[] menuImg,String[] menuName){
        this.menuImg =menuImg;
        this.menuName = menuName;
        this.context = context;
    }

    @Override
    public int getCount() {
        return menuImg.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.main_grid_item,parent,false);
        ImageView img = (ImageView) convertView.findViewById(R.id.grid_img);
        TextView tv = (TextView) convertView.findViewById(R.id.grid_tv);
        img.setImageResource(menuImg[position]);
        tv.setText(menuName[position]);
        return convertView;
    }
}
