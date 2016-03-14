package com.kikier.community;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kikier.community.view.ShopDetailActivity;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Yz on 2016/3/11.
 */
public class ShopListAdapter extends CommuAdapter{
    public ShopListAdapter(Context context, List<?> data) {
        super(context, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.shop_list_row,null);
            holder.pic = (ImageView) convertView.findViewById(R.id.shop_list_pic);
            holder.name = (TextView) convertView.findViewById(R.id.shop_list_name);
            holder.info = (TextView) convertView.findViewById(R.id.shop_list_info);
            holder.count = (TextView) convertView.findViewById(R.id.shop_list_call_count);
            holder.call = (ImageView) convertView.findViewById(R.id.shop_list_call);
            holder.call.setOnClickListener(holder);
            convertView.setOnClickListener(holder);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        HashMap<String,Object> row = (HashMap<String, Object>) data.get(position);
        Blob blob = (Blob) row.get("pic");
        //获取图片
        try {
            InputStream is =blob.getBinaryStream();
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            holder.pic.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.setPosition(position);
        holder.name.setText(row.get("name").toString());
        holder.info.setText(row.get("info").toString());
        holder.count.setText(row.get("count").toString());
        return convertView;
    }

    class ViewHolder implements View.OnClickListener{
        TextView name;
        ImageView pic;
        TextView info;
        TextView count;
        ImageView call;
        int position;

        public void setPosition(int position){
            this.position = position;
        }
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.shop_list_call){
                Intent it = new Intent();
                HashMap<String,Object> row = (HashMap<String, Object>) data.get(position);
                it.setAction(Intent.ACTION_DIAL);
                Uri uri = Uri.parse("tel:"+row.get("phone"));
                it.setData(uri);
                context.startActivity(it);
            }else{
                Intent it = new Intent(context, ShopDetailActivity.class);
//                it.putExtra("data",data);
                context.startActivity(it);
            }
        }
    }
}
