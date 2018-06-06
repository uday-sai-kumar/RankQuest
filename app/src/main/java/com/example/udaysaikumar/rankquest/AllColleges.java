package com.example.udaysaikumar.rankquest;

import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class AllColleges extends AppCompatActivity{
    AllColleges clg;
    public MyAdapter adapter;
    private RecyclerView mRecyclerView;
    public RecyclerView.Adapter mAdapter;


    private RecyclerView.LayoutManager mLayoutManager;
     EditText searchview;
    Cursor data=null;
    CutOffData datas=new CutOffData();
    public    ArrayList<String> hi = new ArrayList<String>();


    ListView l;
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_colleges);
        searchview=findViewById(R.id.searchview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CutOffData.setGot(1);
        CutOffData.setSize(1);
        DatabaseHelper db;

        //DatabaseHelper.databaseselect();
         db = new DatabaseHelper(AllColleges.this);
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


                        hi.add(code);


                    }while(data.moveToNext());
                    CutOffData data=new CutOffData();
                    data.setAll(hi);
                }

            }
        }

        catch (Exception e){

        }
      //  System.out.println("jkfdjkjdkfjdk in the all colleges"+hi);
        CutOffData cod=new CutOffData();
        cod.setAll(hi);


        mRecyclerView =findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<String> myDataset = new ArrayList<String>();


        myDataset=hi;


        //System.out.println(myDataset);

        searchview.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(searchview.getText().toString());

            }
        });


        HashMap<String, Integer> mapIndex = calculateIndexesForName(myDataset);
       // mAdapter = new MyAdapter(myDataset);

      mAdapter = new MyAdapter(myDataset,mapIndex);

       // mAdapter = new MyAdapter(myDataset,myDataset1,myDataset2,myDataset3,myDataset4,myDataset5,myDataset6,mapIndex);
        FastScrollRecyclerViewItemDecoration decoration = new FastScrollRecyclerViewItemDecoration(this);
        mRecyclerView.addItemDecoration(decoration);
         mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

    }

    private HashMap<String, Integer> calculateIndexesForName(ArrayList<String> items){
        HashMap<String, Integer> mapIndex = new LinkedHashMap<String, Integer>();
        for (int i = 0; i<items.size(); i++){
            String name = items.get(i);
            //System.out.println(name+"\n");
            String index = name.substring(0,1);
           // System.out.println(index+"hello");
            index = index.toUpperCase();
           // System.out.println("what in upper"+index);

            if (!mapIndex.containsKey(index)) {
                mapIndex.put(index, i);
            }
        }
       // System.out.println(mapIndex+"in map index");
        return mapIndex;
    }

    public void filter(String search) {
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap<String, Integer> mapIndex1 ;

        for (String quest : hi) {
         //   System.out.println("fun fun"+quest);
            if (quest.toLowerCase().contains(search.toLowerCase())) {
                arrayList.add(quest);
            }

        }
     mapIndex1 = calculateIndexesForName(arrayList);

        if(mapIndex1.size()<22) {
            CutOffData.setSize(0);
        }
        else{
           // System.out.println("god123");
           // System.out.println("going here");
            CutOffData.setSize(1);
        }
      // System.out.println("all is well "+mapIndex1);

       // System.out.println(arrayList);
        mAdapter = new MyAdapter(arrayList,mapIndex1);

        // mAdapter = new MyAdapter(myDataset,myDataset1,myDataset2,myDataset3,myDataset4,myDataset5,myDataset6,mapIndex);
        FastScrollRecyclerViewItemDecoration decoration = new FastScrollRecyclerViewItemDecoration(this);
        mRecyclerView.addItemDecoration(decoration);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

       // adapter.filterList(arrayList,mapIndex1);

    }

    public ArrayList<String> collegesreturn()
    {
        return hi;
    }

}
