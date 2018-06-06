package com.rankquest.udaysaikumar.rankquest;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.udaysaikumar.rankquest.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Arrays;

public class ReportingCenters extends AppCompatActivity {

RecyclerView recyclerView,recyclerView1;
String[] strings,strings1;
AdView adView;
@Override
public boolean onSupportNavigateUp(){
    finish();
    return true;
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporting_centers);
        adView=findViewById(R.id.adView);
        MobileAds.initialize(this, "ca-app-pub-5759174814960049~7488177557");
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView=findViewById(R.id.recycle);
        strings=getResources().getStringArray(R.array.centers);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(ReportingCenters.this));
        ReportingCentersAdapter adapter= new ReportingCentersAdapter(strings);
        recyclerView.setAdapter(adapter);



       // Toast.makeText(ReportingCenters.this,"we will update soon",Toast.LENGTH_SHORT).show();
        /*AlertDialog.Builder builder=new AlertDialog.Builder(ReportingCenters.this);
        builder.setMessage("we will update when the data comes ");
        builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();*/

    }
   /* @Override
    public void onBackPressed(){
        finish();
    }*/
}
