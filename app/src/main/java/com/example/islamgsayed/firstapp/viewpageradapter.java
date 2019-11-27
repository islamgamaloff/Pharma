package com.example.islamgsayed.firstapp;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Islam.G sayed on 6/13/2018.
 */

public class viewpageradapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentlisttitle=new ArrayList<>();

    public viewpageradapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentlisttitle.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentlisttitle.get(position);
    }

    public void addfragment(Fragment fragment , String title){

        fragmentList.add(fragment);
        fragmentlisttitle.add(title);
    }

}
