package com.kikier.community.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kikier.community.R;

public class RegisterActivity extends BaseActivity {
    TextView title;
    TextView edt;
    EditText edt_uname;
    EditText edt_pwd;
    EditText edt_phone;
    EditText edt_authCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    public void getAuthCode(View v){
        //获取验证码
    }

    public void register(View v){
        //注册
    }
    public void init(){
        title = (TextView) findViewById(R.id.head_back_title);
        edt = (TextView) findViewById(R.id.head_back_edit);
        edt_uname = (EditText) findViewById(R.id.register_uname);
        edt_pwd = (EditText) findViewById(R.id.register_pwd);
        edt_phone = (EditText) findViewById(R.id.register_phone);
        edt_authCode = (EditText) findViewById(R.id.register_auth_code);
        title.setText("新用户注册");
        edt.setText("登录");
    }

    public void back(View v){
        finish();
    }

    public void edit(View v){
        Intent it = new Intent(this,LoginActivity.class);
        startActivity(it);
        finish();
    }

}
