package com.rankquest.udaysaikumar.rankquest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.TextView;

import com.example.udaysaikumar.rankquest.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Arrays;

public class WebSite extends AppCompatActivity {
RecyclerView website;
RecyclerView.Adapter adapter;
TextView textView;
String[] array,link;
ArrayList<String> list,links;
AdView adView;
@Override
public boolean onSupportNavigateUp(){
    finish();
    return false;
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_site);
        adView=findViewById(R.id.adView);
        MobileAds.initialize(this, "ca-app-pub-5759174814960049~7488177557");
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        array=getResources().getStringArray(R.array.weblinks);
        link=getResources().getStringArray(R.array.links);
        website=findViewById(R.id.websiterecycle);
        list=new ArrayList<>(Arrays.asList(array));
        links=new ArrayList<>(Arrays.asList(link));
        website.setHasFixedSize(true);
        website.setLayoutManager(new LinearLayoutManager(this));
adapter=new WebSiteAdapter(list,links);
website.setAdapter(adapter);
    }
}
