package com.rankquest.udaysaikumar.rankquest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.udaysaikumar.rankquest.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class CheckList extends AppCompatActivity {
    AdView adView;
@Override
public boolean onSupportNavigateUp(){
    finish();
    return true;
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_list);
        adView=findViewById(R.id.adView);
        MobileAds.initialize(this, "ca-app-pub-5759174814960049~7488177557");
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
