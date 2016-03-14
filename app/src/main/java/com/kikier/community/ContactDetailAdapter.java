package com.kikier.community;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Yz on 2016/3/11.
 */
public class ContactDetailAdapter extends CommuAdapter{

    public ContactDetailAdapter(Context context, List<?> data) {
        super(context, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder ;
        if(convertView==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.contact_detail_row,null);
            holder.name = (TextView) convertView.findViewById(R.id.contact_detail_name);
            holder.address = (TextView) convertView.findViewById(R.id.content_detail_address);
            holder.phone = (TextView) convertView.findViewById(R.id.contact_detail_phone);
            holder.call = (ImageView) convertView.findViewById(R.id.contact_call);
            holder.call.setOnClickListener(holder);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        HashMap<String,Object> row = (HashMap<String, Object>) data.get(position);
        System.out.println(row);
        holder.name.setText(row.get("name").toString());
        holder.address.setText("地址："+row.get("address"));
        holder.phone.setText("电话："+row.get("phone"));
        holder.setPosition(position);
        return convertView;
    }

    class ViewHolder implements View.OnClickListener{
        TextView name;
        TextView address;
        TextView phone;
        ImageView call;
        int position;

        public void setPosition(int position){
            this.position = position;
        }
        @Override
        public void onClick(View v) {
            HashMap<String,Object> row = (HashMap<String, Object>) data.get(position);
            String phone = row.get("phone").toString();
            Intent it = new Intent();
            it.setAction(Intent.ACTION_DIAL);
            Uri uri = Uri.parse("tel:"+phone);
            it.setData(uri);
            context.startActivity(it);

        }
    }
}
