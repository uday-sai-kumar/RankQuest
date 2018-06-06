package com.example.udaysaikumar.rankquest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rankquest.eamcet.FullInformationClg;
import com.rankquest.eamcet.FullInformationClgAdapter;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by udaysaikumar on 18/02/18.
 */

public class F1 extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapters;
    FullInformationClgAdapter adapter;
    F1 fragmale;
    String clg;
    Cursor data;
    Bundle bundbrach;
    DatabaseHelper db;
    DatabaseHelpers dbs;
    ViewPager viewPager;
    TabLayout tabLayout;
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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup,Bundle b){
        View v =inflater.inflate(R.layout.fragment_pager_list,viewGroup,false);
        clg=CutOffData.getClgname();
        System.out.println("good morning fragment");
        String got=CutOffData.getCounselling();
        System.out.println(CutOffData.getGot()+"this is important");
      //  CutOffData.getGot()
        System.out.println("80");
        bundbrach=new Bundle();
        bundbrach=getArguments();
        switch (CutOffData.getGot()) {
            case 1:

CutOffData.setFbranch(bundbrach.getString("branches"));
                //  CutOffData.setFbranch(bundbrach.getString("branches"));
                System.out.println(bundbrach.getString("branches")+"f1java76");

                db = new DatabaseHelper(getContext());
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

                    data = db.querybranch();


                    if (data.getCount() == 0) {

                        //Toast.makeText(this, "no data found", Toast.LENGTH_LONG).show();


                    } else {

                        if (data.moveToFirst()) {
                            do {
                                String oopen = data.getString(data.getColumnIndex("OC_Open_Male"));
                                String oclose = data.getString(data.getColumnIndex("OC_Close_Male"));
                                String baopen = data.getString(data.getColumnIndex("BC_A_Open_Male"));
                                String baclose = data.getString(data.getColumnIndex("BC_A_Close_Male"));

                                String bbopen = data.getString(data.getColumnIndex("BC_B_Open_Male"));
                                String bbclose = data.getString(data.getColumnIndex("BC_B_Close_Male"));
                                String bcopen = data.getString(data.getColumnIndex("BC_C_Open_Male"));
                                String bcclose = data.getString(data.getColumnIndex("BC_C_Close_Male"));

                                String bdopen = data.getString(data.getColumnIndex("BC_D_Open_Male"));
                                String bdclose = data.getString(data.getColumnIndex("BC_D_Close_Male"));
                                String beopen = data.getString(data.getColumnIndex("BC_E_Open_Male"));
                                String beclose = data.getString(data.getColumnIndex("BC_E_Close_Male"));
                                String sco = data.getString(data.getColumnIndex("SC_Open_Male"));

                                String scc = data.getString(data.getColumnIndex("SC_Close_Male"));
                                String sto = data.getString(data.getColumnIndex("ST_Open_Male"));
                                String stc = data.getString(data.getColumnIndex("ST_Close_Male"));

                                String oopenf = data.getString(data.getColumnIndex("OC_Open_Female"));
                                String oclosef = data.getString(data.getColumnIndex("OC_Close_Female"));
                                String baopenf = data.getString(data.getColumnIndex("BC_A_Open_Female"));
                                String baclosef = data.getString(data.getColumnIndex("BC_A_Close_Female"));
                                String bbopenf = data.getString(data.getColumnIndex("BC_B_Open_Female"));
                                String bbclosef = data.getString(data.getColumnIndex("BC_B_Close_Female"));
                                String bcopenf = data.getString(data.getColumnIndex("BC_C_Open_Female"));
                                String bcclosef = data.getString(data.getColumnIndex("BC_C_Close_Female"));
                                String bdopenf = data.getString(data.getColumnIndex("BC_D_Open_Female"));
                                String bdclosef = data.getString(data.getColumnIndex("BC_D_Close_Female"));
                                String beopenf = data.getString(data.getColumnIndex("BC_E_Open_Female"));
                                String beclosef = data.getString(data.getColumnIndex("BC_E_Close_Female"));
                                String scof = data.getString(data.getColumnIndex("SC_Open_Female"));
                                String sccf = data.getString(data.getColumnIndex("SC_Close_Female"));
                                String stof = data.getString(data.getColumnIndex("ST_Open_Female"));
                                String stcf = data.getString(data.getColumnIndex("ST_Close_Female"));
                                String branch = data.getString(data.getColumnIndex("Branch"));
                                System.out.println(branch+"branch 120 here");
                                System.out.println(oopen+"121");
                                String[] array=getResources().getStringArray(R.array.branch);
                                for(int f=0;f<array.length;f++){
                                    if(array[f].substring(0,3).contains(branch)){
                                        branches.add(array[f].substring(4));
                                        break;
                                    }
                                }
                               // branches.add(branch + " --");
                                ocopen.add(oopen);
                                occlose.add(oclose);
                                bcaopen.add(baopen);
                                bcaclose.add(baclose);
                                bcbopen.add(bbopen);
                                bcbclose.add(bbclose);
                                bccopen.add(bcopen);
                                bccclose.add(bcclose);
                                bcdopen.add(bdopen);
                                bcdclose.add(bdclose);
                                bceopen.add(beopen);
                                bceclose.add(beclose);
                                scopen.add(sco);
                                scclose.add(scc);
                                stopen.add(sto);
                                stclose.add(stc);
                                ocopenf.add(oopenf);
                                occlosef.add(oclosef);
                                bcaopenf.add(baopenf);
                                bcaclosef.add(baclosef);
                                bcbopenf.add(bbopenf);
                                bcbclosef.add(bbclosef);
                                bccopenf.add(bcopenf);
                                bccclosef.add(bcclosef);
                                bcdopenf.add(bdopenf);
                                bcdclosef.add(bdclosef);
                                bceopenf.add(beopenf);
                                bceclosef.add(beclosef);
                                scopenf.add(scof);
                                scclosef.add(sccf);
                                stopenf.add(stof);
                                stclosef.add(stcf);

                            } while (data.moveToNext());
                        }

                    }
                } catch (Exception e) {

                }
                break;
            case 0:
                System.out.println(bundbrach.getString("branches")+"207 f1");
                CutOffData.setFbranch(bundbrach.getString("branches"));
                dbs = new DatabaseHelpers(getContext());
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

                    data = dbs.queryclgs();
                    System.out.println("hey how are you raaa below query");

                    if (data.getCount() == 0) {
                        System.out.println("hey how are you raa a if");

//                        Toast.makeText(this, "no data found", Toast.LENGTH_LONG).show();


                    } else {

                        if (data.moveToFirst()) {
                            do {


                                String oopen = data.getString(data.getColumnIndex("OC_Open_Male"));
                                String oclose = data.getString(data.getColumnIndex("OC_Close_Male"));
                                String baopen = data.getString(data.getColumnIndex("BC_A_Open_Male"));
                                String baclose = data.getString(data.getColumnIndex("BC_A_Close_Male"));

                                String bbopen = data.getString(data.getColumnIndex("BC_B_Open_Male"));
                                String bbclose = data.getString(data.getColumnIndex("BC_B_Close_Male"));
                                String bcopen = data.getString(data.getColumnIndex("BC_C_Open_Male"));
                                String bcclose = data.getString(data.getColumnIndex("BC_C_Close_Male"));

                                String bdopen = data.getString(data.getColumnIndex("BC_D_Open_Male"));
                                String bdclose = data.getString(data.getColumnIndex("BC_D_Close_Male"));
                                String beopen = data.getString(data.getColumnIndex("BC_E_Open_Male"));
                                String beclose = data.getString(data.getColumnIndex("BC_E_Close_Male"));
                                String sco = data.getString(data.getColumnIndex("SC_Open_Male"));

                                String scc = data.getString(data.getColumnIndex("SC_Close_Male"));
                                String sto = data.getString(data.getColumnIndex("ST_Open_Male"));
                                String stc = data.getString(data.getColumnIndex("ST_Close_Male"));
                                String oopenf = data.getString(data.getColumnIndex("OC_Open_Female"));
                                String oclosef = data.getString(data.getColumnIndex("OC_Close_Female"));
                                String baopenf = data.getString(data.getColumnIndex("BC_A_Open_Female"));
                                String baclosef = data.getString(data.getColumnIndex("BC_A_Close_Female"));
                                String bbopenf = data.getString(data.getColumnIndex("BC_B_Open_Female"));
                                String bbclosef = data.getString(data.getColumnIndex("BC_B_Close_Female"));
                                String bcopenf = data.getString(data.getColumnIndex("BC_C_Open_Female"));
                                String bcclosef = data.getString(data.getColumnIndex("BC_C_Close_Female"));
                                String bdopenf = data.getString(data.getColumnIndex("BC_D_Open_Female"));
                                String bdclosef = data.getString(data.getColumnIndex("BC_D_Close_Female"));
                                String beopenf = data.getString(data.getColumnIndex("BC_E_Open_Female"));
                                String beclosef = data.getString(data.getColumnIndex("BC_E_Close_Female"));
                                String scof = data.getString(data.getColumnIndex("SC_Open_Female"));
                                String sccf = data.getString(data.getColumnIndex("SC_Close_Female"));
                                String stof = data.getString(data.getColumnIndex("ST_Open_Female"));
                                String stcf = data.getString(data.getColumnIndex("ST_Close_Female"));


                                String branch = data.getString(data.getColumnIndex("Branch"));

                                System.out.println("you are right here");
String[] array=getResources().getStringArray(R.array.branch);
for(int f=0;f<array.length;f++){
    if(array[f].substring(0,3).contains(branch)){
        branches.add(array[f].substring(4));
        break;
    }
}

                               // branches.add(branch + " --");
                                ocopen.add(oopen);
                                occlose.add(oclose);
                                bcaopen.add(baopen);
                                bcaclose.add(baclose);
                                bcbopen.add(bbopen);
                                bcbclose.add(bbclose);
                                bccopen.add(bcopen);
                                bccclose.add(bcclose);
                                bcdopen.add(bdopen);
                                bcdclose.add(bdclose);
                                bceopen.add(beopen);
                                bceclose.add(beclose);
                                scopen.add(sco);
                                scclose.add(scc);
                                stopen.add(sto);
                                stclose.add(stc);
                                ocopenf.add(oopenf);
                                occlosef.add(oclosef);
                                bcaopenf.add(baopenf);
                                bcaclosef.add(baclosef);
                                bcbopenf.add(bbopenf);
                                bcbclosef.add(bbclosef);
                                bccopenf.add(bcopenf);
                                bccclosef.add(bcclosef);
                                bcdopenf.add(bdopenf);
                                bcdclosef.add(bdclosef);
                                bceopenf.add(beopenf);
                                bceclosef.add(beclosef);
                                scopenf.add(scof);
                                scclosef.add(sccf);
                                stopenf.add(stof);
                                stclosef.add(stcf);
                                //genders.add(gender);
                                // branches.add("Branch:"+branch);

                            } while (data.moveToNext());
                        }
                        System.out.println("249");

                    }
                } catch (Exception e) {

                }

                /*switch (CutOffData.getCounselling()){
                    case "counciling1":
                        counselling.setText("counselling-1");
                        break;
                    case "counciling2":
                        counselling.setText("counselling-2");
                        break;
                    case "counciling3":
                        counselling.setText("counselling-3");
                        break;
                }*/
                break;
        }





        int position = 0;

        adapter = new FullInformationClgAdapter(branches, ocopen, occlose, bcaopen, bcaclose, bcbopen, bcbclose, bccopen, bccclose, bcdopen, bcdclose, bceopen, bceclose, scopen, scclose, stopen, stclose, ocopenf, occlosef, bcaopenf, bcaclosef, bcbopenf, bcbclosef, bccopenf, bccclosef, bcdopenf, bcdclosef, bceopenf, bceclosef, scopenf, scclosef, stopenf, stclosef);

        System.out.println(branches+"  "+ocopen+" wow "+ "this is college in fragment");



recyclerView=v.findViewById(R.id.recycleallclg);
recyclerView.setHasFixedSize(true);
recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
recyclerView.setAdapter(adapter);

return v;
    }
}
