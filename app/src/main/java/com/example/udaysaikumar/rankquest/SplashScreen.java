package com.example.udaysaikumar.rankquest;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.view.Window;
import android.widget.ImageView;

public class SplashScreen extends Activity {
ImageView img;
Thread splash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /**if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setExitTransition(new Fade());
        }*/
        setContentView(R.layout.activity_splash_screen);
        img=findViewById(R.id.splash);

       /** if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
           final ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(this);
             splash=new Thread(){
                public void run(){
                    try{
                        sleep(1100);
                        Intent i=new Intent(SplashScreen.this,FirstRankQuest.class);
                        startActivity(i,options.toBundle());
                        finish();
                    }
                    catch (Exception exception){

                    }
                }
            };
        }
        else {*/
             splash = new Thread() {
                public void run() {
                    try {
                        sleep(1100);
                        Intent i = new Intent(SplashScreen.this, FirstRankQuest.class);
                        startActivity(i);
                        finish();
                    } catch (Exception exception) {

                    }
                }
            };

        splash.start();
    }
}
