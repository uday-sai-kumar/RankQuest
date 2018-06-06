package com.example.udaysaikumar.rankquest;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

import static java.lang.Integer.valueOf;

public class CutOff extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    int selected;
    EditText rank;
    TextView spin;
    RadioGroup gg;//gender group
    RadioButton gender;
    Spinner cast,counselling;
    //Spinner preference;
    Button branches,states,show,colleges;
    ArrayList<Integer> selecteditems;
    String[] lists;
    String[] branchesall;
    //Button colleges;
    ArrayList<Integer> allcollegesarray;
    CutOffData cd=new CutOffData();
    ArrayList<String> allcollege;
    boolean[] checkedbranchesitem;
    String open;
String[] sequences;
AdView adView;
InterstitialAd interstitialAd;

   /* public String[] CutOff() {
        System.out.println("in clone cutoff");
        return branchesall.clone();
    }*/

   @Override
   public boolean onSupportNavigateUp(){
       finish();
       return true;
   }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cut_off);
       // adView=findViewById(R.id.adView);
       // MobileAds.initialize(this, "ca-app-pub-5759174814960049~7488177557");
       // AdRequest adRequest=new AdRequest.Builder().build();
       // adView.loadAd(adRequest);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        interstitialAd=new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-5759174814960049/5268121559");
        interstitialAd.loadAd(new AdRequest.Builder().build());
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed(){
                interstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });
        rank=findViewById(R.id.rank);
        gg=findViewById(R.id.gg);
        cast=findViewById(R.id.cast);
        branches=findViewById(R.id.branches);
        show=findViewById(R.id.show);
        selecteditems=new ArrayList<>();
        colleges=findViewById(R.id.colleges);
        allcollegesarray=new ArrayList<>();
        counselling=findViewById(R.id.counselling);
        CutOffData.setGot(0);

        //getActionBar().setTitle("CutOff");
        //getSupportActionBar().setTitle("CutOff");  // provide compatibility to all the versions

        // getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_back_arrow);
        //getActionBar().setHomeButtonEnabled(true);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        gg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                selected=gg.getCheckedRadioButtonId();
                gender=findViewById(selected);
            }
        });

        allcollege=cd.getAll();
       // System.out.println("hi how are you");
        //System.out.println("in Cutoff 12345"+allcollege);

        sequences=new String[allcollege.size()];
        ArrayAdapter adapter=ArrayAdapter.createFromResource(getApplicationContext(),R.array.cast,R.layout.activity_cut_off_spinner);
        adapter.setDropDownViewResource(R.layout.activity_cut_off_spinner);
        cast.setAdapter(adapter);
        cast.setOnItemSelectedListener(this);
        lists=getResources().getStringArray(R.array.branch);
        //lists=getResources().getStringArray(R.array.branches);
        ArrayAdapter adapter1=ArrayAdapter.createFromResource(getApplicationContext(),R.array.counselling,R.layout.activity_cut_off_spinner);
        adapter1.setDropDownViewResource(R.layout.activity_cut_off_spinner);
        counselling.setAdapter(adapter1);
        counselling.setOnItemSelectedListener(this);
        checkedbranchesitem=new boolean[lists.length];
        final String[] branchesall=new String[lists.length];
        //here for all branches
        branches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cd.setBranch(null);
                cd.setLength(0);
                cd.setRank(null);
                cd.setCast(null);
                cd.setBranches(null);
                System.out.println(cd.getBranches()+"234333233333333");
                for(int i=0;i<cd.getLength();i++){
                    branchesall[i]=null;
                }
                AlertDialog.Builder branchbuilder=new AlertDialog.Builder(CutOff.this);
                branchbuilder.setTitle("Select the Branches")
                        .setMultiChoiceItems(lists, checkedbranchesitem, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int position, boolean checked) {
                                if(checked) {
                                    selecteditems.add(position);
                                }else {
                                    selecteditems.remove(Integer.valueOf(position));
                                }
                                System.out.println(selecteditems.size()+"ajfkfknfdkkfskndfkfkfjlkrmkg dvakfvnajnafjhafjahgilua");
                            }
                        })
                        .setCancelable(false)

                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                System.out.println(cd.getBranch()+"at positive");
                                System.out.println(cd.getCast()+"at positive");
                                System.out.println(cd.getGender()+"at positive");
                                System.out.println(cd.getLength()+"at positive");
                                System.out.println(cd.getRank()+"at positive");

                                String hello=" ";
                                int length=selecteditems.size();
                                System.out.println(length);
                                for(int k=0;k<selecteditems.size();k++){
                                    System.out.println(lists[selecteditems.get(k)]+"\n"+"at positive");
                                    branchesall[k]=(lists[selecteditems.get(k)]).substring(0,3);
                                    System.out.println(branchesall[k]+"at positive button");

                                }
                                //selecteditems.clear();
                                cd.setBranches(branchesall);
                                //cd.setBranches(branchesall);
                                cd.setLength(length);


                            }
                        });
                        /*.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();

                            }
                        });*/
  /*.setNeutralButton("All", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialogInterface, int i) {

          for(int f=0;f<lists.length;f++) {
              checkedbranchesitem[f] = true;
          }
              int length=selecteditems.size();
              System.out.println(length);
              for(int k=0;k<selecteditems.size();k++){
                  System.out.println(lists[selecteditems.get(k)]+"\n"+"at positive");
                  branchesall[k]=lists[selecteditems.get(k)];
                  System.out.println(branchesall[k]+"at positive button");

              }
              //selecteditems.clear();
              cd.setBranches(branchesall);
              //cd.setBranches(branchesall);
              cd.setLength(length);

          }

  })
.setNeutralButton("Clear", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        for(int f=0;f<checkedbranchesitem.length;f++){
            checkedbranchesitem[f]=false;
            selecteditems.clear();
        }
    }
});*/
                AlertDialog dd=branchbuilder.create();
                dd.show();
            }
        });

       /* sequences=allcollege.toArray(sequences);
        //sequences=getResources().getStringArray(R.array.branches);
        int lengths=sequences.length;
        System.out.println(lengths+"here is the sequences"+sequences);
        final String[] collegesall=new String[sequences.length];
        //final CharSequence[] sequences=allcolleges.toArray(new CharSequence[allcolleges.size()]);
colleges.setOnClickListener(new View.OnClickListener() {

                                @Override
                                public void onClick(View view) {

                                    System.out.println(cd.getBranches1()+"234333233333333");

                                    AlertDialog.Builder alert = new AlertDialog.Builder(CutOff.this);
                                    alert.setTitle("AllColleges")
                                            .setMultiChoiceItems(sequences, null, new DialogInterface.OnMultiChoiceClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int position, boolean checked) {
                                                    if(checked) {
                                                        allcollegesarray.add(position);
                                                    }else {
                                                        allcollegesarray.remove(Integer.valueOf(position));
                                                    }
                                                    System.out.println(allcollegesarray.size()+"ajfkfknfdkkfskndfkfkfjlkrmkg dvakfvnajnafjhafjahgilua");
                                                }
                                            })
                                            .setCancelable(false)
                                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {

                                                    int length1=allcollegesarray.size();
                                                    for(int k=0;k<allcollegesarray.size();k++){
                                                        //System.out.println(lists[selecteditems.get(k)]+"\n"+"at positive");
                                                        collegesall[k]=sequences[allcollegesarray.get(k)];
                                                        System.out.println(collegesall[k]);

                                                    }
                                                    //allcollegesarray.clear();
                                                    cd.setBranches1(collegesall);
                                                   cd.setLength1(length1);


                                                }
                                            });

                                    AlertDialog dd=alert.create();
                                    dd.show();
                                }
});*/
                                          /*  .setMultiChoiceItems(sequences, null, new DialogInterface.OnMultiChoiceClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i, boolean checked) {
                                                    if (checked) {
                                                        allcollegesarray.add(i);
                                                    } else {
                                                        allcollegesarray.remove(Integer.valueOf(i));
                                                    }
                                                    System.out.println(allcollegesarray.size()+"ajfkfknfdkkfsknd");

                                                }

                                            })
                                            .setCancelable(false)
                                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {

                                                    System.out.println("in positive Button on dialog interface"+allcollegesarray.size());

                                                    for (int j = 0; i < allcollegesarray.size(); j++) {
                                                        collegesall[j] = sequences[allcollegesarray.get(j)];
                                                        System.out.println("fdfdfdfdfdfdfdfdfddfdfdfdfffdfdfd"+collegesall[j]);
                                                    }
                                                    System.out.println(collegesall);
                                                    allcollegesarray.clear();
                                                    cd.setBranches(collegesall);*/
                                                    /*setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialogInterface, int i) {
                                                            System.out.println(cd.getBranch()+"at positive");
                                                            System.out.println(cd.getCast()+"at positive");
                                                            System.out.println(cd.getGender()+"at positive");
                                                            System.out.println(cd.getLength()+"at positive");
                                                            System.out.println(cd.getRank()+"at positive");

                                                            String hello=" ";
                                                            int length=selecteditems.size();
                                                            System.out.println(length);
                                                            for(int k=0;k<selecteditems.size();k++){
                                                                System.out.println(lists[selecteditems.get(k)]+"\n"+"at positive");
                                                                branchesall[k]=lists[selecteditems.get(k)];
                                                                System.out.println(branchesall[k]);

                                                            }
                                                            selecteditems.clear();
                                                            cd.setBranches(branchesall);
                                                            cd.setLength(length);


                                                        }*/

                                            /*    }
                                            })
                                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    dialogInterface.dismiss();
                                                }
                                            });
                                    AlertDialog alertDialog=alert.create();
                                    alertDialog.show();

                                }
                            });*/
        colleges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CutOff.this,CutOffAllColleges.class);
                startActivity(intent);
            }
        });


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(interstitialAd.isLoaded()){
                    interstitialAd.show();
                }

                String ranktext = rank.getText().toString();
               // System.out.println("ahdajkdjidfjivjijfifvfivvfivfivfifii"+cd.getLength());
                if (ranktext.isEmpty()) {
                    Toast.makeText(CutOff.this, "Please provide Rank", Toast.LENGTH_SHORT).show();
                }
                else if(cd.getLength()==0){
                    Toast.makeText(CutOff.this, "Please provide Branches", Toast.LENGTH_SHORT).show();

                }
                else if(Integer.parseInt(ranktext)==0){
                    Toast.makeText(CutOff.this, "Please provide valid rank", Toast.LENGTH_SHORT).show();

                }
                else {
                   // System.out.println(ranktext + "this is rank babes");
                    cd.setRank(ranktext);
                    int selectd = gg.getCheckedRadioButtonId();
                    gender = findViewById(selectd);
                    String genderget = gender.getText().toString();
                    cd.setGender(genderget);
                    System.out.println(genderget + "gender");
                    String spinnercast = cast.getSelectedItem().toString();
                    String counsel=counselling.getSelectedItem().toString();
                    switch (spinnercast) {
                        case "OC":
                            if(genderget.equals("Male")) {
                                spinnercast = "OC_Close_Male";
                                open = "OC_Open_Male";
                            }
                            else {
                                spinnercast = "OC_Close_Female";
                                open = "OC_Open_Female";
                            }
                            break;
                        case "BC-A":
                            if(genderget.equals("Male")){
                                spinnercast = "BC_A_Close_Male";
                                open = "BC_A_Open_Male";
                            }
                            else{
                                spinnercast = "BC_A_Close_Female";
                                open = "BC_A_Open_Female";
                            }


                            break;
                        case "BC-B":
                            if(genderget.equals("Male")){
                                spinnercast = "BC_B_Close_Male";
                                open = "BC_B_Open_Male";
                            }
                            else{
                                spinnercast = "BC_B_Close_Female";
                                open = "BC_B_Open_Female";
                            }


                            break;
                        case "BC-C":
                            if(genderget.equals("Male")){
                                spinnercast = "BC_C_Close_Male";
                                open = "BC_C_Open_Male";
                            }
                            else{
                                spinnercast = "BC_C_Close_Female";
                                open = "BC_C_Open_Female";
                            }


                            break;
                        case "BC-D":
                            if(genderget.equals("Male")){
                                spinnercast = "BC_A_Close_Male";
                                open = "BC_D_Open_Male";
                            }
                            else{
                                spinnercast = "BC_A_Close_Female";
                                open = "BC_D_Open_Female";
                            }

                            break;
                        case "BC-E":
                            if(genderget.equals("Male")){
                                spinnercast = "BC_E_Close_Male";
                                open = "BC_E_Open_Male";
                            }
                            else{
                                spinnercast = "BC_E_Close_Female";
                                open = "BC_E_Open_Female";
                            }


                            break;
                        case "SC":
                            if(genderget.equals("Male")) {
                                spinnercast = "SC_Close_Male";
                                open = "SC_Open_Male";
                            }
                            else {
                                spinnercast = "SC_Close_Female";
                                open = "SC_Open_Female";
                            }


                            break;
                        case "ST":
                            if(genderget.equals("Male")) {
                                spinnercast = "ST_Close_Male";
                                open = "SC_Open_Male";
                            }
                            else {
                                spinnercast = "ST_Close_Female";
                                open = "SC_Open_Female";
                            }
                            break;

                    }
                    cd.setCast(spinnercast);
                    cd.setOpen(open);
                    cd.setCounselling(counsel);

                    //System.out.println(spinnercast + "spinner cast");

                    // Intent sumitti = new Intent(getApplicationContext(), Clg_Cutoff_list.class);
                    Intent search = new Intent(getApplicationContext(), Clg_Cutoff_list.class);

                    startActivity(search);
                }
            }
        });


    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
