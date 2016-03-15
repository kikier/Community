package com.kikier.community.view;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

import com.kikier.community.R;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class WeatherActivity extends BaseActivity {
    TextView city;
    TextView minTemp;
    TextView maxTemp;
    TextView weather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .build());
        setContentView(R.layout.activity_weather);
        city = (TextView) findViewById(R.id.city);
        minTemp = (TextView) findViewById(R.id.temp1);
        maxTemp = (TextView) findViewById(R.id.temp2);
        weather = (TextView) findViewById(R.id.weather);
        try {
            URL url = new URL("http://www.weather.com.cn/data/cityinfo/101250101.html");
            InputStream is = url.openStream();
            StringBuilder sb = readData(is);
            JSONObject json = new JSONObject(sb.toString());
            json = json.getJSONObject("weatherinfo");
            city.setText(json.getString("city"));
            minTemp.setText(json.getString("temp1"));
            maxTemp.setText(json.getString("temp2"));
            weather.setText(json.getString("weather"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public StringBuilder readData(InputStream is) {
        StringBuilder sb = new StringBuilder();
        try {
            byte[] bytes = new byte[1024];
            int length = -1;
            while ((length = is.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, length));
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }
}
