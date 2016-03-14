package com.kikier.community.view;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.kikier.community.AdThread;
import com.kikier.community.MainAdapter;
import com.kikier.community.R;

public class MainActivity extends AppCompatActivity{
    static ViewPager  pager;
    GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager= (ViewPager) findViewById(R.id.ad_view);
        grid = (GridView) findViewById(R.id.gridView);
        //载入广告线程
        Thread adThread = new Thread(new AdThread(this));
        adThread.start();
//        主界面菜单
        mainMenu();
    }

    public void mainMenu(){
    //  int[] menuImg =getResources().getIntArray(R.array.menuImg);//无法获取图片id
        String[] menuNames =getResources().getStringArray(R.array.menuName);//获取按钮名字
        TypedArray tar = getResources().obtainTypedArray(R.array.menuImg);//获取按钮图片的类型数组
        int len = tar.length();
        //定义一个数组来存放图片的id
        int[] menuImg = new int[len];
        for(int i = 0 ; i<len;i++){
            menuImg[i]=tar.getResourceId(i,0);
        }
        tar.recycle();
        MainAdapter adapter = new MainAdapter(this,menuImg,menuNames);
        grid.setAdapter(adapter);
        //给每个按钮绑定监听事件
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = null;
                switch (position){
                    case 0:
                        it = new Intent(MainActivity.this,NewsCenterActivity.class);
                        break;
                    case 1:
                        it = new Intent(MainActivity.this,PropertyActivity.class);
                        break;
                    case 2:
                        it = new Intent(MainActivity.this,SaleHouseActivity.class);
                        break;
                    case 3:
                        it = new Intent(MainActivity.this,ContactActivity.class);
                        break;
                    case 4:
                        it = new Intent(MainActivity.this,ShopActivity.class);
                        break;
                    case 5:
                        it = new Intent(MainActivity.this,UsedMarketActivity.class);
                        break;
                    case 6:
                        it = new Intent(MainActivity.this,AntertainmentActivity.class);
                        break;
                    case 7:
                        it = new Intent(MainActivity.this,DiscountActivity.class);
                        break;
                    case 8:
                        it = new Intent(MainActivity.this,AboutUsActivity.class);
                        break;
                    case 9:
                        it = new Intent(MainActivity.this,WeatherActivity.class);
                }
                startActivity(it);
            }
        });
    }
}
