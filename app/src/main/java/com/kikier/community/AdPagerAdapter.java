package com.kikier.community;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Yz on 2016/3/1.
 */
public class AdPagerAdapter extends FragmentPagerAdapter {
    private FragmentManager fm;
    private ArrayList<Fragment> fragments;
    public AdPagerAdapter(FragmentManager fm,ArrayList<Fragment> fragments){
        super(fm);
        this.fm = fm;
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
