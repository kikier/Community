package com.kikier.community;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.kikier.community.view.AdFragment;

import java.util.ArrayList;

/**
 * Created by Yz on 2016/3/4.
 */
public class AdDao {
    public static ViewPager loadAd(AppCompatActivity aty){
        AdFragment afa ;
        AdFragment afb ;
        AdFragment afc ;
        ViewPager pager;
        pager = (ViewPager) aty.findViewById(R.id.ad_view);
        ArrayList<Fragment> fragments;
        afa = new AdFragment();
        afa.setPicId(R.drawable.pic1);
        afb = new AdFragment();
        afb.setPicId(R.drawable.pic2);
        afc = new AdFragment();
        afc.setPicId(R.drawable.pic3);
        fragments = new ArrayList<>();
        fragments.add(afa);
        fragments.add(afb);
        fragments.add(afc);
        FragmentManager fm = aty.getSupportFragmentManager();
        AdPagerAdapter pagerAdapter = new AdPagerAdapter(fm,fragments);
        pager.setAdapter(pagerAdapter);
        return pager;
    }
}
