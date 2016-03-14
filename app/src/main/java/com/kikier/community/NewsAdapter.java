package com.kikier.community;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.kikier.community.view.DetailActivity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Yz on 2016/3/4.
 */
public class NewsAdapter extends BaseAdapter{
    Context context;
    int resource;
    ArrayList<HashMap<String,Object>> data;
    public NewsAdapter(Context context,int resource,ArrayList<HashMap<String,Object>> data){
        this.context=context;
        this.data = data;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            NewsOnClickListener listener = new NewsOnClickListener();
            convertView = LayoutInflater.from(context).inflate(resource,parent,false);
            holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            holder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
            holder.listener = listener;
            convertView.setOnClickListener(listener);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        HashMap<String,Object> row = data.get(position);
        holder.listener.setData(Integer.parseInt(row.get("id").toString()));
        holder.tv_title.setText(row.get("title").toString());
        String time = row.get("time").toString();
        time = time.replace(" ","\n");
        holder.tv_time.setText(time);
        return convertView;
    }

    class NewsOnClickListener implements View.OnClickListener{
        int id;
        public void setData(int id){
            this.id = id;
        }

        @Override
        public void onClick(View v) {
            Intent it = new Intent(context, DetailActivity.class);
            it.putExtra("id", id);
            context.startActivity(it);
        }
    }
    class ViewHolder{
        TextView tv_title;
        TextView tv_time;
        NewsOnClickListener listener;
    }
}
