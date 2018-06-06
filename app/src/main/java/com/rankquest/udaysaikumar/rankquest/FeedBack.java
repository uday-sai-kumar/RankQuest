package com.rankquest.udaysaikumar.rankquest;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.udaysaikumar.rankquest.MongoHQ.SaveAsyncTask;
import com.example.udaysaikumar.rankquest.MyContact;
import com.example.udaysaikumar.rankquest.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;

public class FeedBack extends AppCompatActivity {
    EditText bug,improve,phno;
    RatingBar ratingBar;
    Button button;
    Toast toast;
    boolean b;
    Context context;
    AdView adView;
    InterstitialAd interstitialAd;
    ProgressDialog dialog;
    ConnectivityManager manager;
    NetworkInfo networkInfo;
    boolean fun=false;
    @Override
    public boolean onSupportNavigateUp(){
        if(interstitialAd.isLoaded()) {
            interstitialAd.show();
        }
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed(){
                interstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });
        finish();

        return false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bug=findViewById(R.id.bughere);
        phno=findViewById(R.id.phno);
        improve=findViewById(R.id.improvehere);
        ratingBar=findViewById(R.id.ratingBar);
        button=findViewById(R.id.buttonbar);
        adView=findViewById(R.id.adView);
        interstitialAd=new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-5759174814960049/5268121559");
        interstitialAd.loadAd(new AdRequest.Builder().build());


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                networkInfo = manager.getActiveNetworkInfo();
                System.out.println(bug.getText().toString()+"feed");
                System.out.println(improve.getText().toString()+"feed");
                System.out.println(phno.getText().toString()+"feed");
                if (networkInfo != null && networkInfo.isConnected() && networkInfo.isAvailable()) {
                    if (bug.getText().toString().trim().isEmpty() || improve.getText().toString().trim().isEmpty() ||ratingBar.getRating()<1 || phno.getText().toString().trim().length()<10) {
                        if(phno.getText().toString().length()<10){
                            Toast.makeText(FeedBack.this, "enter valid mobile number", Toast.LENGTH_SHORT).show();

                        }
                        else {
                            Toast.makeText(FeedBack.this, "please provide whole information", Toast.LENGTH_SHORT).show();
                        }
                       // fun =true;

                    }
                    else {
                        MyContact contact = new MyContact();
                        contact.phno=phno.getText().toString();
                        contact.bug = bug.getText().toString();
                        contact.improve = improve.getText().toString();
                        contact.rating = String.valueOf(ratingBar.getRating());
                        SaveAsyncTask tsk = new SaveAsyncTask(FeedBack.this);
                        tsk.execute(contact);
                    }
                }
                    // }
                 else {
                    Toast.makeText(getApplicationContext(), "please connect to network", Toast.LENGTH_SHORT).show();
                }
                }
            });
    }
    }
     /* if (ratingBar.getRating()<1) {
                        if(fun) {
                            Toast.makeText(FeedBack.this, "please write anything", Toast.LENGTH_SHORT).show();

                        }
                        else if(ratingBar.getRating()<1){
                            Toast.makeText(FeedBack.this, "please provide rating", Toast.LENGTH_SHORT).show();
                        }

                    }*/


             /*   if (String.valueOf(ratingBar.getRating()).isEmpty()) {
                    Toast.makeText(FeedBack.this, "please provide rating", Toast.LENGTH_SHORT).show();

                }*/
    /*public void saveContact(View v) throws UnknownHostException {

        MyContact contact = new MyContact();
contact.bug=bug.getText().toString();
contact.improve=improve.getText().toString();
contact.rating= String.valueOf(ratingBar.getRating());
        contact.first_name = editText_fname.getText().toString();
        contact.last_name = editText_last_name.getText().toString();
        contact.email = editText_email.getText().toString();
        contact.phone = editText_phone.getText().toString();

        SaveAsyncTask tsk = new SaveAsyncTask();
        tsk.execute(contact);

    }*/

