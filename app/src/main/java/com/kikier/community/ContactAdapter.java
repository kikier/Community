package com.kikier.community;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.kikier.community.view.ContactDetailActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Created by Yz on 2016/3/10.
 */
public class ContactAdapter extends BaseAdapter {
    Context context;
    ArrayList<HashMap<String,Object>> data;

    public ContactAdapter(Context context,ArrayList<HashMap<String,Object>> data){
        this.context = context;
        this.data = data;
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
        ViewHolder holder ;
        final HashMap<String,Object> row = data.get(position);
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.contact_row,null);
            holder = new ViewHolder();
            holder.type = (TextView) convertView.findViewById(R.id.contact_row_type);
            holder.grid = (GridView) convertView.findViewById(R.id.contact_grid);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        if(holder.grid!=null){
            String[] from ={"name"};
            int[] to = {R.id.name};
            final ArrayList<HashMap<String,Object>> gridData = (ArrayList<HashMap<String, Object>>) row.get("content");
            holder.adapter = new SimpleAdapter(context,gridData,R.layout.contact_row_detail,from,to);
            holder.grid.setAdapter(holder.adapter);
            holder.grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    Toast.makeText(context, position+"", Toast.LENGTH_SHORT).show();
                    HashMap<String, Object> gridRow = gridData.get(position);
                    System.out.println(gridRow.get("id"));
                    Intent it = new Intent(context, ContactDetailActivity.class);
                    it.putExtra("id",gridRow.get("id").toString());
                    context.startActivity(it);
                }
            });
        }
        holder.type.setText(row.get("type").toString());
        return convertView;
    }

    class ViewHolder{
        TextView type;
        GridView grid;
        SimpleAdapter adapter;
    }
}
