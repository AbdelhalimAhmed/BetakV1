package com.example.halim.betak.Fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by HalimAhmed on 4/4/2016.
 */
public class TabsAdapterUser extends FragmentPagerAdapter {
    Fragment [] fragments;
    public TabsAdapterUser(FragmentManager fm, Fragment [] fragments){
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments[i];
    }

    @Override
    public int getCount() {
        return 3;
    }
}

