package com.kikier.community;

import android.content.Context;
import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Yz on 2016/3/9.
 */
public class DataDao{
    public static ArrayList<HashMap<String, Object>> loadData(Context context, String param, String[] params) {
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()
                    .penaltyLog()
                    .build());
            URL url = new URL(context.getResources().getString(R.string.noticeList));
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setDoInput(true);
            huc.setDoOutput(true);
            huc.setInstanceFollowRedirects(true);
            huc.setRequestMethod("POST");
            DataOutputStream dos = new DataOutputStream(huc.getOutputStream());
            dos.write(param.getBytes());
            huc.connect();
            if (huc.getResponseCode() == HttpURLConnection.HTTP_OK) {
                ArrayList<HashMap<String, Object>> data = new ArrayList<>();
                InputStream is = huc.getInputStream();
                StringBuilder sb = readIS(is);
                if (sb.indexOf("[") != -1) {//判断是否为数组
                    JSONArray array = new JSONArray(sb.toString());
                    JSONObject object;
                    for (int i = 0; i < array.length(); i++) {
                        object = array.getJSONObject(i);
                        HashMap<String, Object> map = new HashMap<>();
//                    map.put("title", object.getString("title"));
//                    map.put("time", object.getString("time"));
//                    map.put("id", object.getInt("id"));
                        for (int j = 0; j < params.length; j++) {
                            map.put(params[j], object.getString(params[j]));
                        }
                        data.add(map);
                    }
                } else {
                    JSONObject object = new JSONObject(sb.toString());
                    HashMap<String, Object> map = new HashMap<>();
                    for (int j = 0; j < params.length; j++) {
                        map.put(params[j], object.getString(params[j]));
                    }
                    data.add(map);
                }
                return data;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static StringBuilder readIS(InputStream is) {
        StringBuilder sb = new StringBuilder();
        try {
            byte[] bytes = new byte[1024];
            int length = -1;
            while ((length = is.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, length));
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb;
    }

}
