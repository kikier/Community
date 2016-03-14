package com.kikier.community.view;

import android.graphics.Color;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.kikier.community.AdThread;
import com.kikier.community.DataDao;
import com.kikier.community.MAss;
import com.kikier.community.NewsAdapter;
import com.kikier.community.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class NewsCenterActivity extends AppCompatActivity {
    ListView list;
    TextView tv_notice;
    TextView tv_local_news;
    TextView tv_food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_center);
//        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//                .detectDiskReads()
//                .detectDiskWrites()
//                .detectNetwork()
//                .penaltyLog()
//                .build());
        list = (ListView) findViewById(R.id.news_list);
        tv_notice = (TextView) findViewById(R.id.tv_notice);
        tv_local_news = (TextView) findViewById(R.id.tv_local_news);
        tv_food = (TextView) findViewById(R.id.tv_food);
        //载入广告线程
        Thread thread = new Thread(new AdThread(this));
        thread.start();

        //
        String[] params = {"title","time","id"};
        ArrayList<HashMap<String, Object>> data = DataDao.loadData(this,"type=nl",params );
        System.out.println(data);
        if (data != null) {
            NewsAdapter adapter = new NewsAdapter(this,R.layout.news_row ,data);
            list.setAdapter(adapter);
        }
    }

    public void back(View v) {
        finish();
    }

    //点击标题切换
    public void cut(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.tv_notice:
                tv_notice.setBackgroundColor(Color.BLUE);
                tv_local_news.setBackgroundColor(Color.parseColor("#ffe96d"));
                tv_food.setBackgroundColor(Color.parseColor("#ffe96d"));
                break;
            case R.id.tv_local_news:
                tv_notice.setBackgroundColor(Color.parseColor("#ffe96d"));
                tv_local_news.setBackgroundColor(Color.BLUE);
                tv_food.setBackgroundColor(Color.parseColor("#ffe96d"));
                break;
            case R.id.tv_food:
                tv_notice.setBackgroundColor(Color.parseColor("#ffe96d"));
                tv_local_news.setBackgroundColor(Color.parseColor("#ffe96d"));
                tv_food.setBackgroundColor(Color.BLUE);
                break;
        }
    }

//    public ArrayList<HashMap<String, Object>> loadData() {
//        try {
//            URL url = new URL(getResources().getString(R.string.noticeList));
//            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
//            huc.setDoInput(true);
//            huc.setDoOutput(true);
//            huc.setInstanceFollowRedirects(true);
//            huc.setRequestMethod("GET");
//            huc.connect();
//            if (huc.getResponseCode() == HttpURLConnection.HTTP_OK) {
//                ArrayList<HashMap<String, Object>> data = new ArrayList<>();
//                InputStream is = huc.getInputStream();
//                StringBuilder sb = readIS(is);
//                JSONArray array = new JSONArray(sb.toString());
//                JSONObject object;
//                for (int i = 0; i < array.length(); i++) {
//                    object = array.getJSONObject(i);
//                    HashMap<String, Object> map = new HashMap<>();
//                    map.put("title", object.getString("title"));
//                    map.put("time", object.getString("time"));
//                    map.put("id", object.getInt("id"));
//                    data.add(map);
//                }
//                return data;
//            } else {
//                return null;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

//    public StringBuilder readIS(InputStream is) {
//        StringBuilder sb = new StringBuilder();
//        try {
//            byte[] bytes = new byte[1024];
//            int length = -1;
//            while ((length = is.read(bytes)) != -1) {
//                sb.append(new String(bytes, 0, length));
//            }
//            is.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return sb;
//    }


}
