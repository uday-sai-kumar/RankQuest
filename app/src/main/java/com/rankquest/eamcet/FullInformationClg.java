package com.rankquest.eamcet;

import android.app.LoaderManager;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.udaysaikumar.rankquest.AllColleges;
import com.example.udaysaikumar.rankquest.CutOff;
import com.example.udaysaikumar.rankquest.CutOffAdapter;
import com.example.udaysaikumar.rankquest.CutOffData;
import com.example.udaysaikumar.rankquest.DatabaseHelper;
import com.example.udaysaikumar.rankquest.DatabaseHelpers;
import com.example.udaysaikumar.rankquest.F1;
import com.example.udaysaikumar.rankquest.PagerAdapter;
import com.example.udaysaikumar.rankquest.R;

import java.io.IOException;
import java.util.ArrayList;

public class FullInformationClg extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapters;
    FullInformationClgAdapter adapter;
    F1 fragmale;
    String clg;
    Cursor data;
    DatabaseHelper db;
    DatabaseHelpers dbs;
    ViewPager viewPager;
    TabLayout tabLayout;
    Bundle bundle;
    TextView hi1,code11,place1,distname1,regions1,collegetype1,affiliate1,coeducation1,fee11,counselling;
    public ArrayList<String> ocopen=new ArrayList<>();
    public ArrayList<String> occlose=new ArrayList<>();
    public ArrayList<String> bcaopen=new ArrayList<>();
    public ArrayList<String> bcaclose=new ArrayList<>();
    public ArrayList<String> bcbopen=new ArrayList<>();
    public ArrayList<String> bcbclose=new ArrayList<>();
    public ArrayList<String> bccopen=new ArrayList<>();
    public ArrayList<String> bccclose=new ArrayList<>();
    public ArrayList<String> bcdopen=new ArrayList<>();
    public ArrayList<String> bcdclose=new ArrayList<>();
    public ArrayList<String> bceopen=new ArrayList<>();
    public ArrayList<String> bceclose=new ArrayList<>();
    public ArrayList<String> scopen=new ArrayList<>();
    public ArrayList<String> scclose=new ArrayList<>();
    public ArrayList<String> stopen=new ArrayList<>();
    public ArrayList<String> stclose=new ArrayList<>();
    public ArrayList<String> ocopenf=new ArrayList<>();
    public ArrayList<String> occlosef=new ArrayList<>();
    public ArrayList<String> bcaopenf=new ArrayList<>();
    public ArrayList<String> bcaclosef=new ArrayList<>();
    public ArrayList<String> bcbopenf=new ArrayList<>();
    public ArrayList<String> bcbclosef=new ArrayList<>();
    public ArrayList<String> bccopenf=new ArrayList<>();
    public ArrayList<String> bccclosef=new ArrayList<>();
    public ArrayList<String> bcdopenf=new ArrayList<>();
    public ArrayList<String> bcdclosef=new ArrayList<>();
    public ArrayList<String> bceopenf=new ArrayList<>();
    public ArrayList<String> bceclosef=new ArrayList<>();
    public ArrayList<String> scopenf=new ArrayList<>();
    public ArrayList<String> scclosef=new ArrayList<>();
    public ArrayList<String> stopenf=new ArrayList<>();
    public ArrayList<String> stclosef=new ArrayList<>();
    public ArrayList<String> branches=new ArrayList<>();
    public   ArrayList<String> hi=new ArrayList<>();
    public   ArrayList<String> place = new ArrayList<String>();
    public   ArrayList<String> affiliate = new ArrayList<String>();
    public   ArrayList<String> distname= new ArrayList<String>();
    public   ArrayList<String> regions = new ArrayList<String>();
    public   ArrayList<String> code1= new ArrayList<String>();
    public   ArrayList<String>  fee1= new ArrayList<String>();
    public   ArrayList<String>  collegetype= new ArrayList<String>();
    public   ArrayList<String>  coeducation= new ArrayList<String>();
    public   ArrayList<String>  genders= new ArrayList<String>();
    Context context;




@Override
public boolean onSupportNavigateUp(){
    finish();
    return true;
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_information_clg);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     //   Bundle b=getIntent().getExtras();
        /*if(b!=null) {
            String hiii = (String) b.get("cut");
            System.out.println("vonakkam" + hiii);
        }*/
        clg=CutOffData.getClgname();
        hi1=findViewById(R.id.collegename);
        counselling=findViewById(R.id.counsellings);
        code11=findViewById(R.id.code);
       place1=findViewById(R.id.place);
        distname1=findViewById(R.id.distname);
        regions1=findViewById(R.id.regions);
        collegetype1=findViewById(R.id.collegetype);
        affiliate1=findViewById(R.id.affiliate);
        coeducation1=findViewById(R.id.coeduction);
        fee11=findViewById(R.id.fee1);
        //CutOffData.setClgname(null);
        String got=CutOffData.getCounselling();
      //  System.out.println(CutOffData.getGot()+"this is important");
//CutOffData.getGot();
        System.out.println(CutOffData.getGot()+"124");
        switch (CutOffData.getGot()) {
            case 1:
                counselling.setText("counselling-3");

            db = new DatabaseHelper(FullInformationClg.this);
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


            ArrayList<String> theList = new ArrayList<>();
            try {

                data = db.queryclg();
                System.out.println("hey how are you raaa below query");

                if (data.getCount() == 0) {
                    System.out.println("hey how are you raa a if");

                    Toast.makeText(this, "no data found", Toast.LENGTH_LONG).show();


                } else {

                    if (data.moveToFirst()) {
                        do {
                           // System.out.println("reached here");
                            String clgname = data.getString(data.getColumnIndex("CollegeName"));
                          //  System.out.println("reached here");

                            String places = data.getString(data.getColumnIndex("Place"));
                           // System.out.println("reached here 1");

                            String districtname = data.getString(data.getColumnIndex("Dist_Name"));
                           // System.out.println("reached here 2");

                            String region = data.getString(data.getColumnIndex("Region"));
                           // System.out.println("reached here 3");

                            String collegetyp = data.getString(data.getColumnIndex("CollegeType"));
                           // System.out.println("reached here 4");

                            String coedu = data.getString(data.getColumnIndex("Co_Educ"));
                           // System.out.println("reached here 5");

                            String clgcode = data.getString(data.getColumnIndex("Code"));
                           // System.out.println("reached here 6");

                            String affilto = data.getString(data.getColumnIndex("Affil_to"));

                            String branch = data.getString(data.getColumnIndex("Branch"));
                            System.out.println(branch+"wow 226");
                            //String codes=data.getString(data.getColumnIndex("Affil_to"));
                            String fee = data.getString(data.getColumnIndex("fee"));
                            //  String gender=data.getString(data.getColumnIndex("Gender"));
                            //String gender=data.getColumnName(2);
                            //gender.su
                            //System.out.println(gender);
//System.out.println("you are right here");

                            hi.add(clgname);
                          //  System.out.println(hi);
                            code1.add(": "+clgcode);
                            place.add(": "+places);
                            distname.add(": "+districtname);
                            regions.add(": "+region);
                            collegetype.add(": "+collegetyp);
                            affiliate.add(": "+affilto);
                            coeducation.add(": "+coedu);
                            fee1.add(": "+fee);

                            branches.add(branch);



                        } while (data.moveToNext());
                    }

                }
            } catch (Exception e) {

            }
            bundle=new Bundle();
            bundle.putStringArrayList("branch",branches);
            break;
            case 0:
                dbs = new DatabaseHelpers(FullInformationClg.this);
                try {
                    dbs.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                try {
                    dbs.openDataBase();
                } catch (SQLException sqle) {
                    throw sqle;
                }


                try {

                    data = dbs.querycollege();
                    System.out.println("hey how are you raaa below query");

                    if (data.getCount() == 0) {
                        System.out.println("hey how are you raa a if");

                        Toast.makeText(this, "no data found", Toast.LENGTH_LONG).show();


                    } else {

                        if (data.moveToFirst()) {
                            do {

                                String clgname = data.getString(data.getColumnIndex("CollegeName"));//collegename
                                System.out.println(clgname+"247");
                                String places = data.getString(data.getColumnIndex("Place"));
                                String districtname = data.getString(data.getColumnIndex("Dist_Name"));
                                String region = data.getString(data.getColumnIndex("Region"));
                                String collegetyp = data.getString(data.getColumnIndex("CollegeType"));
                                String coedu = data.getString(data.getColumnIndex("Co_Educ"));
                                String clgcode = data.getString(data.getColumnIndex("Code"));
                                String affilto = data.getString(data.getColumnIndex("Affil_to"));
                                String branch = data.getString(data.getColumnIndex("Branch"));
                                //String codes=data.getString(data.getColumnIndex("Affil_to"));
                                String fee = data.getString(data.getColumnIndex("fee"));
                                //  String gender=data.getString(data.getColumnIndex("Gender"));
                                //String gender=data.getColumnName(2);
                                //gender.su
                                //System.out.println(gender);


                                hi.add(clgname);
                                //System.out.println(hi);
                                code1.add(": "+clgcode);
                                place.add(": "+places);
                                distname.add(": "+districtname);
                                regions.add(": "+region);
                                collegetype.add(": "+collegetyp);
                                affiliate.add(": "+affilto);
                                coeducation.add(": "+coedu);
                                fee1.add(": "+fee);

                                branches.add(branch);


                            } while (data.moveToNext());
                        }

                    }
                } catch (Exception e) {

                }
                System.out.println("fullinformationclg 370");
                bundle=new Bundle();
                bundle.putStringArrayList("branch",branches);
                switch (CutOffData.getCounselling()){
                    case "counciling1":
                        counselling.setText("counselling-1");
                        break;
                    case "counciling2":
                        counselling.setText("counselling-2");
                        break;
                    case "counciling3":
                        counselling.setText("counselling-3");
                        break;
                }

break;
        }
System.out.println("300 fullinformation");
System.out.println(hi);
            System.out.println(hi.get(0));
            int position = 0;
            System.out.println("in position 0"+hi.get(0));
            hi1.setText(hi.get(0));
            code11.setText(code1.get(position));
            place1.setText(place.get(position));
            distname1.setText(distname.get(position));
            regions1.setText(regions.get(position));
            collegetype1.setText(collegetype.get(position));
            affiliate1.setText(affiliate.get(position));
            coeducation1.setText(coeducation.get(position));
            fee11.setText(fee1.get(position));
            viewPager=findViewById(R.id.pager);
            PagerAdapter adapters=new PagerAdapter(getSupportFragmentManager(),bundle);
            viewPager.setAdapter(adapters);
            tabLayout=findViewById(R.id.tabs);
           // Bundle bundle =new Bundle();
           // tabLayout=findViewById(R.id.)
      //  adapter = new FullInformationClgAdapter(branches, ocopen, occlose, bcaopen, bcaclose, bcbopen, bcbclose, bccopen, bccclose, bcdopen, bcdclose, bceopen, bceclose, scopen, scclose, stopen, stclose);
       // bundle.putParcelableArrayList("branches",branches);
        tabLayout.setupWithViewPager(viewPager);
         //   recyclerView = findViewById(R.id.recycleallclg);
          //  layoutManager = new LinearLayoutManager(this);
           // recyclerView.setHasFixedSize(true);
           // recyclerView.setLayoutManager(layoutManager);
           // adapter = new FullInformationClgAdapter(branches, ocopen, occlose, bcaopen, bcaclose, bcbopen, bcbclose, bccopen, bccclose, bcdopen, bcdclose, bceopen, bceclose, scopen, scclose, stopen, stclose, ocopen, occlose, bcaopen, bcaclose, bcbopen, bcbclose, bccopen, bccclose, bcdopen, bcdclose, bceopen, bceclose, scopen, scclose, stopen, stclose);
          //  recyclerView.setAdapter(adapter);
            System.out.println(clg + "this is college");


    }


}
