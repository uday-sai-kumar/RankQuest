package com.example.udaysaikumar.rankquest;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.rankquest.udaysaikumar.rankquest.CheckList;
import com.rankquest.udaysaikumar.rankquest.FeedBack;
import com.rankquest.udaysaikumar.rankquest.ReportingCenters;
import com.rankquest.udaysaikumar.rankquest.WebSite;

import java.io.IOException;
import java.util.ArrayList;

public class FirstRankQuest extends AppCompatActivity {
    Cursor data=null;
    CutOffData cd=new CutOffData();
    AdView adView;
    public   ArrayList<String> hi = new ArrayList<String>();
ImageButton cutoff,allcolleges,branches,feedback,developers,share,website,reporting,checklist;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_rank_quest);
        cutoff=findViewById(R.id.cutoff);
        //Glide.with(this).load(R.drawable.cutoff).into(cutoff);
      //  college=findViewById(R.id.college);
        allcolleges=findViewById(R.id.allcolleges);
        branches=findViewById(R.id.branches);
        reporting=findViewById(R.id.reporting);
        checklist=findViewById(R.id.checklist);
        website=findViewById(R.id.website);
        share=findViewById(R.id.share);
        developers=findViewById(R.id.developers);
        feedback=findViewById(R.id.feedback);
        // button=findViewById(R.id.check);
       // CutOffData cd=new CutOffData();
        adView=findViewById(R.id.adView);
        MobileAds.initialize(this, "ca-app-pub-5759174814960049~7488177557");
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);
                DatabaseHelper db = new DatabaseHelper(FirstRankQuest.this);
                System.out.println("hi hello");
        try {
            db.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            db.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }
        //l = findViewById(R.id.list);

        ArrayList<String> theList = new ArrayList<>();
        try {

            data = db.query();
            System.out.println("hey how are you raaa below query");

            if (data.getCount() == 0) {
                System.out.println("hey how are you raa a if");

                Toast.makeText(this, "no data found", Toast.LENGTH_LONG).show();


            }
            else{

                if(data.moveToFirst()){
                    do{
                        String code=data.getString(data.getColumnIndex("CollegeName"));

                      //  System.out.println("code is code"+code);

                        hi.add(code);


                    }while(data.moveToNext());
                    CutOffData data=new CutOffData();
                    data.setAll(hi);
                }

            }
        }

        catch (Exception e){

        }
        cutoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CutOffData.setBranches(null);
                cd.setLength(0);

                Intent cutoffc=new Intent(getApplicationContext(),CutOff.class);
                startActivity(cutoffc);
            }
        });
        allcolleges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent college=new Intent(getApplicationContext(),AllColleges.class);
                startActivity(college);

            }
        });
        branches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent branches=new Intent(getApplicationContext(),Branches.class);
                startActivity(branches);
            }
        });
        developers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent developers=new Intent(getApplicationContext(),DevelopersActivity.class);
startActivity(developers);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"http://play.google.com/store/apps/details?id=com.rankquest.eamcet");
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent,"Share Link"));
            }
        });
        reporting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               /* AlertDialog.Builder builder=new AlertDialog.Builder(FirstRankQuest.this);
                builder.setMessage("we will update when the reporting centers are officially released");
                builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();*/

                //Toast.makeText(FirstRankQuest.this,"we will update soon",Toast.LENGTH_SHORT).show();
                Intent reporings=new Intent(FirstRankQuest.this, ReportingCenters.class);
                startActivity(reporings);
               // Toast.makeText(FirstRankQuest.this,"we will add the functionality soon",Toast.LENGTH_SHORT).show();
            }
        });
        website.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent web=new Intent(FirstRankQuest.this, WebSite.class);
                startActivity(web);
                //Toast.makeText(FirstRankQuest.this,"we will add the functionality soon",Toast.LENGTH_SHORT).show();
            }
        });
        feedback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent feedback=new Intent(FirstRankQuest.this,FeedBack.class);
                startActivity(feedback);
               // Toast.makeText(FirstRankQuest.this,"we will add the functionality soon",Toast.LENGTH_SHORT).show();
            }
        });
      checklist.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent feedback=new Intent(FirstRankQuest.this,CheckList.class);

                // Intent feedback=new Intent(FirstRankQuest.this,CheckList.class);
                startActivity(feedback);
                // Toast.makeText(FirstRankQuest.this,"we will add the functionality soon",Toast.LENGTH_SHORT).show();
            }
        });
 /*button.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         android.app.FragmentManager manager=getFragmentManager();
         DialogFrag dialogFrag=new DialogFrag();
         dialogFrag.show(manager,"Dialog");

     }
 });*/



    }
}
