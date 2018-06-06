package com.example.udaysaikumar.rankquest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.client.utils.CloneUtils;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class CutOffAllColleges extends Activity {
    RecyclerView allcollegesrecycle;
    //EditText searchtext;
    Cursor data;
    String[] allclg;
    int count = 0;
    ArrayList<String> allcolleges = new ArrayList<>();
    ArrayList<CutOffAllCollegesAdapterData> dataclg;
    CutOffAllCollegesAdapter adapter;
    Button ok;
    CutOffData cod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cut_off_all_colleges);

        allcollegesrecycle = findViewById(R.id.allcollegesrecycle);
        // searchtext=findViewById(R.id.searchtext);
        ok = findViewById(R.id.ok);
        cod = new CutOffData();
        dataclg = new ArrayList<>();
        DatabaseHelper db = new DatabaseHelper(CutOffAllColleges.this);
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

        //ArrayList<String> branch1 = new ArrayList<>();
        //ArrayList<String> open1 = new ArrayList<>();
        //ArrayList<String> close1 = new ArrayList<>();


        try {

            data = db.allCollegesQuery();
            System.out.println("hey how are you raaa below query");

            if (data.getCount() == 0) {
                System.out.println("hey how are you raa a if");
                AlertDialog.Builder builder = new AlertDialog.Builder(CutOffAllColleges.this);
                builder.setTitle("Sorry buddy no data found");
                builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //dialogInterface.dismiss();
                        finish();
                        // finishActivity(Clg_Cutoff_list);
                        // finishActivity();
                        //Intent hello=new Intent(Clg_Cutoff_list.this,CutOff.class);
                        //startActivity(hello);
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

                // Toast.makeText(this, "no data found", Toast.LENGTH_LONG).show();


            } else {

               /* if(data.moveToFirst()){
                    do{
                        String code=data.getString(data.getColumnIndex("Branch"));
                        usk.add(code);
                    }while(data.moveToNext());
                }*/
                //CutOffData datas=new CutOffData();
                //System.out.println("234876556345676543765437654"+datas.getCast());
                if (data.moveToFirst()) {
                    do {
                        String code = data.getString(data.getColumnIndex("CollegeName"));
                        // String branch=data.getString(data.getColumnIndex("Branch"));
                        //String open=data.getString(data.getColumnIndex(datas.getOpen()));
                        //String close=data.getString(data.getColumnIndex(datas.getCast()));

                        // if(datas.getPrefrence().equals("Branch")) {
                        //String  branch = data.getString(data.getColumnIndex(datas.getPrefrence()));
                        //}
                        //else{
                        //  branch=data.getString(data.getColumnIndex(datas.getCast()));
                        //}

                        System.out.println("usk@uday" + code);
                        //System.out.println("234876556345676543765437654"+branch);

                        allcolleges.add(code);
                        // branch1.add(branch);
                        //open1.add("O: "+open);
                        //close1.add("C: "+close);
                        // cutoffdata1.add(branch);
                    } while (data.moveToNext());
                    for (String k : allcolleges) {
                        System.out.println("it is in " + k);
                    }
                    for (String k : allcolleges) {
                        CutOffAllCollegesAdapterData data = new CutOffAllCollegesAdapterData(k, false);
                        dataclg.add(data);
                    }
                }
            }
        } catch (Exception e) {

        }

       /* for(String k : allcolleges){
            System.out.println("hello usk 123 hello usk 123"+k);
        }*/
        HashMap<String, Integer> mapIndex = calculateIndexesForName(allcolleges);
        allcollegesrecycle.setHasFixedSize(true);
        allcollegesrecycle.setLayoutManager(new LinearLayoutManager(CutOffAllColleges.this));
        adapter = new CutOffAllCollegesAdapter(dataclg, mapIndex);
        allcollegesrecycle.setAdapter(adapter);
        FastScrollRecyclerViewItemDecoration decoration = new FastScrollRecyclerViewItemDecoration(this);
        allcollegesrecycle.addItemDecoration(decoration);
        allcollegesrecycle.setItemAnimator(new DefaultItemAnimator());
      /* searchtext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
            filter(searchtext.getText().toString());

            }
        });*/
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(CutOffAllColleges.this,"hi",Toast.LENGTH_SHORT).show();
                ArrayList<CutOffAllCollegesAdapterData> selected = adapter.getStudentist();
                allclg = new String[selected.size()];
                System.out.println("where are you all of u" + selected.size());
                for (int i = 0; i < selected.size(); i++) {
                    CutOffAllCollegesAdapterData selectedclg = selected.get(i);
                    System.out.println("in cutoff all colleges" + selectedclg);
                    if (selectedclg.isSelected() && selectedclg.getAllclg() != null) {
                        allclg[count] = selectedclg.getAllclg();
                        count++;

                        // Toast.makeText(CutOffAllColleges.this,selectedclg.getAllclg(),Toast.LENGTH_SHORT).show();
                    }
                }
                cod.setBranches1(allclg);
                cod.setLength1(count);
                finish();

            }
        });

    }

    private static final int time = 2000;
    private long counter;

    @Override
    public void onBackPressed() {
        if (time + counter > System.currentTimeMillis()) {

            //Toast.makeText(CutOffAllColleges.this,"hi",Toast.LENGTH_SHORT).show();
            ArrayList<CutOffAllCollegesAdapterData> selected = adapter.getStudentist();
            allclg = new String[selected.size()];
            System.out.println("where are you all of u" + selected.size());
            for (int i = 0; i < selected.size(); i++) {
                CutOffAllCollegesAdapterData selectedclg = selected.get(i);
                System.out.println("in cutoff all colleges" + selectedclg);
                if (selectedclg.isSelected() && selectedclg.getAllclg() != null) {
                    allclg[count] = selectedclg.getAllclg();
                    count++;

                    // Toast.makeText(CutOffAllColleges.this,selectedclg.getAllclg(),Toast.LENGTH_SHORT).show();
                }
            }
            cod.setBranches1(allclg);
            cod.setLength1(count);
            finish();

        }


        //super.onBackPressed();
        // finishActivity(0);
        //System.exit(0);

        else {
            Toast.makeText(CutOffAllColleges.this, "press again", Toast.LENGTH_SHORT).show();
        }
        counter = System.currentTimeMillis();

    }




   /* public void filter(String search) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String quest : allcolleges) {
            if (quest.toLowerCase().contains(search.toLowerCase())) {
                arrayList.add(quest);
            }

        }
        adapter.filterList(arrayList);

    }*/

private HashMap<String, Integer> calculateIndexesForName(ArrayList<String> items){
    CutOffData.setSize(1);
    HashMap<String, Integer> mapIndex = new LinkedHashMap<>();
    for (int i = 0; i<items.size(); i++){
        String name = items.get(i);
        System.out.println(name+"\n");
        String index = name.substring(0,1);
        System.out.println(index+"hello");
        index = index.toUpperCase();
        System.out.println("what in upper"+index);

        if (!mapIndex.containsKey(index)) {
            mapIndex.put(index, i);
        }
    }
    System.out.println(mapIndex+"in map index");
    return mapIndex;
}




}
