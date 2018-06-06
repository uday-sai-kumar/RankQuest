package com.example.udaysaikumar.rankquest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.zip.Inflater;

public class Clg_Cutoff_list extends AppCompatActivity {
    RecyclerView rv;
    Cursor data;
   int got;
    String rankcast;
    EditText searchtext;
    ListView clglist;
    // CutOffAdapter adapt;
    Context c;
    CutOffAdapter br;
    View v;
    ArrayList<String> cutoffdata = new ArrayList<>();
    ArrayList<String> branch1 = new ArrayList<>();
    ArrayList<String> open1 = new ArrayList<>();
    ArrayList<String> close1 = new ArrayList<>();
    int k = 0, t = 0;
    ArrayList<Integer> lists = new ArrayList<>();
    ArrayList<String> arrayList = new ArrayList<>();
    Spinner branchsearch;
String[] branchessea,bs;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clg__cutoff_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // clglist=findViewById(R.id.clglist);
        //clglist.setAdapter(new ClgListView(this));
        searchtext = findViewById(R.id.searchtext);
        branchsearch=findViewById(R.id.branchsearch);
        branchessea=new String[CutOffData.getBranches().length];
         branchessea=CutOffData.getBranches();
//bs=new String[branchessea.length];
  String hi=Arrays.toString(branchessea);
  hi="All,"+hi;
  hi=hi.replace(", null","");
  hi=hi.replace("[","");
  hi=hi.replace("]","");
  hi=hi.replace(", ",",");
  System.out.println(hi+"hi 81");
  bs=hi.split(",");
         //branchessea=new String[]{"1","2","3"};

        ArrayAdapter<String> adapter=new ArrayAdapter<>(Clg_Cutoff_list.this,R.layout.activity_cut_off_spinner,bs);
        adapter.setDropDownViewResource(R.layout.activity_cut_off_spinner);
        branchsearch.setAdapter(adapter);

       /* v=this.getCurrentFocus();
        if(v!=null){
            InputMethodManager manager= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
        }*/
        DatabaseHelpers db = new DatabaseHelpers(Clg_Cutoff_list.this);
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


        try {

            data = db.cutoffQuery();
            System.out.println("hey how are you raaa below query");

            if (data.getCount() == 0) {
                System.out.println("hey how are you raa a if");
                AlertDialog.Builder builder = new AlertDialog.Builder(Clg_Cutoff_list.this);
                builder.setCancelable(false);
                builder.setTitle("Sorry buddy no colleges found");
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
                CutOffData datas = new CutOffData();
                System.out.println("234876556345676543765437654" + datas.getCast());
                if (data.moveToFirst()) {
                    do {
                        String code = data.getString(data.getColumnIndex("CollegeName"));
                        String branch = data.getString(data.getColumnIndex("Branch"));
                        String open = data.getString(data.getColumnIndex(datas.getOpen()));
                        String close = data.getString(data.getColumnIndex(datas.getCast()));


                        // if(datas.getPrefrence().equals("Branch")) {
                        //String  branch = data.getString(data.getColumnIndex(datas.getPrefrence()));
                        //}
                        //else{
                        //  branch=data.getString(data.getColumnIndex(datas.getCast()));
                        //}

                        //   System.out.println("234876556345676543765437654" + code);
                        //System.out.println("234876556345676543765437654"+branch);

                        cutoffdata.add(code);
                        branch1.add(branch);
                        open1.add("O: " + open);
                        close1.add("C: " + close);
                        // cutoffdata1.add(branch);
                    } while (data.moveToNext());
                }
               /* int ii=0,pos=0,k=cutoffdata.size();
                String string="";
                for(;pos<k;){
                    System.out.println(pos);
                    System.out.println("in out state");

                    System.out.println("hey hi hey");
                    String a=cutoffdata.get(pos);
                    for(;;) {
                       // checkDB != null ? true : false;

                        System.out.println("going here");
                        if (a.equals(cutoffdata.get(ii))) {
                            string+=branch1.get(ii);
                            System.out.println("going here 1");
                            System.out.println(ii);

                            // arrayList.add(branch1.get(ii));
                        }
                        else{
System.out.println("in else state");
                            break;
                        }
                        arrayList.add(string);
                        System.out.println("going here 2");

                        System.out.println("good usk");
                        ii++;
                        pos=pos+ii;



                    }

                    //arrayList.add(string);
                    System.out.println("getting");

                }*/


            }
        } catch (Exception e) {

        }
        System.out.println("going here 3");

        for (String ks : arrayList) {
            System.out.println("going here 4");

            System.out.println("uss" + ks);
        }


        c = getApplicationContext();
        // HashMap<String, Integer> mapIndex = calculateIndexesForName(cutoffdata);
        rv = findViewById(R.id.cutoffrecycle);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        br = new CutOffAdapter(cutoffdata, branch1, open1, close1, c);
        //  CutOffAdapter br=new CutOffAdapter(cutoffdata,branch1,open1,close1,mapIndex);
        rv.setAdapter(br);
searchtext.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        branchsearch.setSelection(0);
    }
});
        searchtext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                lists.clear();
                k = -1;
                t = -1;
                filter(searchtext.getText().toString());


            }
        });
        branchsearch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(branchsearch.getSelectedItem().toString()+"spinner");
                lists.clear();
                k = -1;
                t = -1;
                filter(branchsearch.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    public void filter(String search) {
        String[] array;

         array = getResources().getStringArray(R.array.branches);
        for (int t = 0; t < array.length; t++) {
            if (search.toUpperCase().contains(array[t])){
                got=0;
                break;
             }
            else{
              got=1;
             }
            //int f = search.toUpperCase().contains(array[t]) ? (got = 0) : (got = 1);
        }
        switch (got) {

            case 0:
                ArrayList<String> arrayList = new ArrayList<>();
                ArrayList<String> branch = new ArrayList<>();
                ArrayList<String> open = new ArrayList<>();
                ArrayList<String> close = new ArrayList<>();
                for (String quest : branch1) {
                    t++;
                    if (quest.toLowerCase().contains(search.toLowerCase())) {
                        lists.add(k);
                        //  System.out.println("getting position "+t);
                        //  System.out.println(cutoffdata.get(t));
                        branch.add(quest);
                        arrayList.add(cutoffdata.get(t));
                        open.add(open1.get(t));
                        close.add(close1.get(t));
                        //  System.out.println("in array list"+arrayList.get(k));

                    }
                    br.filterlist(arrayList, branch, open, close);

                }
                break;
            case 1:
                ArrayList<String> arrayListss = new ArrayList<>();
                ArrayList<String> branchss = new ArrayList<>();
                ArrayList<String> openss = new ArrayList<>();
                ArrayList<String> closess= new ArrayList<>();
                if(search.contains("All")){
                    search="";
                }
                for (String quest : cutoffdata) {
                    k++;
                    if (quest.toLowerCase().contains(search.toLowerCase())) {
                        lists.add(k);
                        // System.out.println("getting position "+k);
                        //  System.out.println(cutoffdata.get(k));
                        arrayListss.add(quest);
                        branchss.add(branch1.get(k));
                        openss.add(open1.get(k));
                        closess.add(close1.get(k));
                        //  System.out.println("in array list"+arrayList.get(k));

                    }
                    //  if(arrayList.size()!=0) {
                    br.filterlist(arrayListss, branchss, openss, closess);
                    //  }

                }
                break;

        }
    }
}
         /*  for (String quest : branch1) {
                t++;
                if (quest.toLowerCase().contains(search.toLowerCase())) {
                    lists.add(k);
                  //  System.out.println("getting position "+t);
                  //  System.out.println(cutoffdata.get(t));
                    branch.add(quest);
                    arrayList.add(cutoffdata.get(t));
                    open.add(open1.get(t));
                    close.add(close1.get(t));
                    //  System.out.println("in array list"+arrayList.get(k));

                }
                br.filterlist(arrayList,branch,open,close);

            }*/

         /*  for (String quest : cutoffdata) {
                k++;
                if (quest.toLowerCase().contains(search.toLowerCase())) {
                    lists.add(k);
                   // System.out.println("getting position "+k);
                  //  System.out.println(cutoffdata.get(k));
                    arrayList.add(quest);
                    branch.add(branch1.get(k));
                    open.add(open1.get(k));
                    close.add(close1.get(k));
                  //  System.out.println("in array list"+arrayList.get(k));

                }
              //  if(arrayList.size()!=0) {
                    br.filterlist(arrayList, branch, open, close);
              //  }

            }*/
        /*   for(Integer i:lists){

                System.out.println("getting position in the "+i);

            }*/
           // rv.setLayoutManager(new LinearLayoutManager(this));
            //CutOffAdapter br = new CutOffAdapter(cutoffdata, branch1, open1, close1, getApplicationContext());
            //  CutOffAdapter br=new CutOffAdapter(cutoffdata,branch1,open1,close1,mapIndex);
            //rv.setAdapter(br);
            //br.notifyDataSetChanged();
            //adapt.filterList(arrayList);

            //  CutOffAdapter br=new CutOffAdapter(cutoffdata,branch1,open1,close1,mapIndex);






      /*  rv.setLayoutManager(new LinearLayoutManager(this));
        CutOffAdapter br = new CutOffAdapter(cutoffdata, branch1, open1, close1, getApplicationContext());
        //  CutOffAdapter br=new CutOffAdapter(cutoffdata,branch1,open1,close1,mapIndex);
        rv.setAdapter(br);
        br.notifyDataSetChanged();*/





    /*private HashMap<String, Integer> calculateIndexesForName(ArrayList<String> items){
        HashMap<String, Integer> mapIndex = new LinkedHashMap<String, Integer>();
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
    }*/

/*class SingleClg{
    String name;
    SingleClg(String clg){
        this.name=clg;
    }
}
class ClgListView extends BaseAdapter
{
   public Context context;
private ArrayList<SingleClg> listarray;
ClgListView(Context c){
   context=c;
    listarray=new ArrayList<SingleClg>();
    Resources resources=c.getResources();
   String[] Name=resources.getStringArray(R.array.clglist);
   for(int  i=0;i<3;i++){
       listarray.add(new SingleClg(Name[i]));
   }

}
    @Override
    public int getCount() {
        return listarray.size();
    }

    @Override
    public Object getItem(int i) {
        return listarray.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
  LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View v=inflater.inflate(R.layout.list_view_cutoff,viewGroup,false);
        TextView name=v.findViewById(R.id.textView6);
        SingleClg hi=listarray.get(i);
        name.setText(hi.name);

        return v;
    }
}*/
