package com.rankquest.udaysaikumar.rankquest;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.udaysaikumar.rankquest.Clg_Cutoff_list;
import com.example.udaysaikumar.rankquest.R;

public class Schedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(Schedule.this);
        builder.setMessage("we will update when the data comes");
        builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //dialogInterface.dismiss();
               //
                dialogInterface.dismiss();
                //finish();
                // finishActivity(Clg_Cutoff_list);
                // finishActivity(); 
                //Intent hello=new Intent(Clg_Cutoff_list.this,CutOff.class);
                //startActivity(hello);
            }
        });
        android.app.AlertDialog dialog=builder.create();
        dialog.show();

        // Toast.makeText(this, "no data found", Toast.LENGTH_LONG).show();


    }

       /* AlertDialog.Builder builder=new AlertDialog.Builder(Schedule.this);
        builder.setMessage("we will update when the data comes");
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

