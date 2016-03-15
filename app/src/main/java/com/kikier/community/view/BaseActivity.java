package com.kikier.community.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yz on 2016/3/3.
 */
public class BaseActivity extends AppCompatActivity {
    public static List<Activity> activities = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activities.add(this);
//        System.out.println("创建一个aty");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activities.remove(this);
//        System.out.println("销毁了一个aty");
    }

    public void exit(){
        for(Activity activity : activities){
//            System.out.println("结束了一个aty");
            activity.finish();
        }
    }
}
