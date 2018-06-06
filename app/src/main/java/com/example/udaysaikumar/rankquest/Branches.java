package com.example.udaysaikumar.rankquest;

import android.database.Cursor;
import android.database.SQLException;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.io.IOException;
import java.util.ArrayList;

public class Branches extends AppCompatActivity {
    RecyclerView rv;
    Cursor data;
    String[] branch,sf,sa,percent;
    LinearLayoutManager llm;
    AdView adView;
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branches);
        adView=findViewById(R.id.adView);
        MobileAds.initialize(this, "ca-app-pub-5759174814960049~7488177557");
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        branch=getResources().getStringArray(R.array.branch);
        sf=getResources().getStringArray(R.array.seatsfilled);
        sa=getResources().getStringArray(R.array.seatsavailable);
        percent=getResources().getStringArray(R.array.percentage);
        rv= findViewById(R.id.branchesrecycle);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        BranchesAdapter br=new BranchesAdapter(branch,sf,sa,percent);
        rv.setAdapter(br);
    }
}
