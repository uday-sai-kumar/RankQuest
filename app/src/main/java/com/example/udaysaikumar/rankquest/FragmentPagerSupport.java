package com.example.udaysaikumar.rankquest;

import android.app.ActionBar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
public class FragmentPagerSupport extends FragmentActivity {
    static final int NUM_ITEMS = 10;

    PagerAdapter adapter;

    ViewPager pager;
    PagerTitleStrip titleStrip;
TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pager);
       // adapter=new PagerAdapter(getSupportFragmentManager());
     //   pager=findViewById(R.id.pager);
       // pager.setAdapter(adapter);
       // tabLayout=findViewById(R.id.sliding);

       // pager.setAdapter(adapter);
       // tabLayout.addTab(tabLayout.newTab().setTag("Tab 1"));
      //  tabLayout.addTab(tabLayout.newTab().setTag("Tab 2"));
       // tabLayout.addTab(tabLayout.newTab().setTag("Tab 3"));

       // tabLayout.setupWithViewPager(pager);

    }
}