package com.example.udaysaikumar.rankquest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by udaysaikumar on 18/02/18.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    Bundle bundles;
int k;
int t;
    public PagerAdapter(FragmentManager fm, Bundle bundle) {
        super(fm);
        bundles=bundle;
    }
    @Override
    public Fragment getItem(int position) {
        ArrayList<String> branch=bundles.getStringArrayList("branch");
        t=0;
        for(t=0;t<branch.size();t++){
            System.out.println(branch.get(t)+"wow 31");
        }
        Bundle  bundle=new Bundle();
        System.out.println(position+"pageradapter 31");
        System.out.println(branch.get(position)+"pageradapter 32");
       // CutOffData.setFbranch(branch.get(position));
        bundle.putString("branches",branch.get(position));
        Fragment fragment=new F1();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        ArrayList<String> branch=bundles.getStringArrayList("branch");
        return branch.size();
    }
    @Override
    public CharSequence getPageTitle(int position){
        ArrayList<String> branch=bundles.getStringArrayList("branch");
        return branch.get(position);
    }
}
