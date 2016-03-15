package com.kikier.community.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.kikier.community.R;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity extends BaseActivity {
    EditText edt_userName;
    EditText edt_pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edt_userName = (EditText) findViewById(R.id.edt_user_name);
        edt_pwd = (EditText) findViewById(R.id.edt_user_pwd);
        String uname = edt_userName.getText().toString();
        String pwd = edt_pwd.getText().toString();
        try {
            URL url = new URL("");
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setRequestMethod("POST");
            huc.setDoInput(true);
            huc.setDoOutput(true);
            DataOutputStream dos = new DataOutputStream(huc.getOutputStream());
            String data = "uname="+uname+"&pwd="+pwd;
            dos.write(data.getBytes());
            dos.flush();
            dos.close();
            huc.connect();
            if(huc.getResponseCode()==HttpURLConnection.HTTP_OK){
//               InputStream is = huc.getInputStream();
//               is.read
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void back(View v){
        finish();
    }

    public void edit(View v){
        Intent it = new Intent(this,RegisterActivity.class);
        startActivity(it);
        finish();
    }
}
