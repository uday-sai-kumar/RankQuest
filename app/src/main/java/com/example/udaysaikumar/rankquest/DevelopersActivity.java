package com.example.udaysaikumar.rankquest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.rankquest.udaysaikumar.rankquest.WebSiteAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class DevelopersActivity extends AppCompatActivity {
    RecyclerView website;
    RecyclerView.Adapter adapter;
    TextView textView,textView1;
    String[] array;
    ArrayList<String> list;
    AdView adView;
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);
        adView=findViewById(R.id.adView);
        MobileAds.initialize(this, "ca-app-pub-5759174814960049~7488177557");
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*array=getResources().getStringArray(R.array.heading);
       // link=getResources().getStringArray(R.array.links);
        website=findViewById(R.id.branchesrecycle);
        list=new ArrayList<>(Arrays.asList(array));
       // links=new ArrayList<>(Arrays.asList(link));
        website.setHasFixedSize(true);
        website.setLayoutManager(new LinearLayoutManager(this));
        adapter=new DevelopersActivityAdapter(list);
        website.setAdapter(adapter);*/
    }
}
