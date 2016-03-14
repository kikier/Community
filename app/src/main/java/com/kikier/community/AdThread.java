package com.kikier.community;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Yz on 2016/3/3.
 */
public class AdThread implements Runnable{
    AppCompatActivity aty;
    ViewPager pager;

    //轮播触摸停止问题未解决！！！！！！！

    public AdThread(AppCompatActivity aty){
        this.aty = aty;
    }
    Handler handler = new Handler();

    @Override
    public void run() {
        pager = AdDao.loadAd(aty);
        Runnable task = new Thread() {
            public void run() {
                //这儿是耗时操作，完成之后更新UI；
                aty.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        handler.postDelayed(this, 3 * 1000);
                        //更新UI
                        int position = pager.getCurrentItem() + 1;
                        if (position == 3) {
                            position = 0;
                        }
                        pager.setCurrentItem(position);
                    }
                });
            }
        };
        handler.postDelayed(task,3000);
    }
}
