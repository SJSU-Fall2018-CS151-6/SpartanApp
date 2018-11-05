package com.wolfsoft.one.bronzeapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by wolfsoft on 10/11/2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {



    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);

    }


    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Fragment1 tab1 = new Fragment1();
                return tab1;
            case 1:
                Fragment2 tab2 = new Fragment2();
                return tab2;

            case 2:
                Fragment3 tab3 = new Fragment3();
                return tab3;




            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}