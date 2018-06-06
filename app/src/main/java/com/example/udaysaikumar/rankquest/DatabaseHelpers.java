package com.example.udaysaikumar.rankquest;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * Created by udaysaikumar on 11/02/18.
 */

public class DatabaseHelpers extends SQLiteOpenHelper {

    String DB_PATH = null;
    String q,r;
    String dat;



    CutOffData cod=new CutOffData();
    String hi=cod.getCounselling();
    //private static String DB_NAME=CutOffData.getCounselling();
    //private static String DB_NAME = "counciling1";
    // private static String DB_NAME = "eamcetdb";
    SQLiteDatabase myDataBase;
    String collegesall,branch;
    private final Context myContext;



   /* @Override
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }*/

    public DatabaseHelpers(Context context) {
        super(context, CutOffData.getCounselling(), null, 10);
            /*switch (cod.getCounselling()){
                case "counselling 1":
                    DB_NAME="counciling1";
                    break;
                case "counselling 2":
                    DB_NAME="counciling2";
                    break;
                case "counselling 3":
                    DB_NAME="counciling3";
                    break;
                default:
                    DB_NAME="counciling3";
                    break;
            }*/
      //  System.out.println("this is the data base usk"+CutOffData.getCounselling());

        this.myContext = context;
        this.DB_PATH = "/data/data/" + context.getPackageName() + "/" + "databases/";
        Log.e("Path 1", DB_PATH);
    }


    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if (dbExist) {
        } else {
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + CutOffData.getCounselling();
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    private void copyDataBase() throws IOException {
        InputStream myInput = myContext.getAssets().open(CutOffData.getCounselling());
        String outFileName = DB_PATH + CutOffData.getCounselling();
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[10];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException {
        String myPath = DB_PATH + CutOffData.getCounselling();
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();

            }
    }
    public Cursor querycollege(){
        String clg=CutOffData.getClgname();
        // CutOffData.setClgname(null);
        System.out.println(clg+"this is also college 141");
        switch (CutOffData.getCounselling()){
            case "counciling1":
                dat="select * from Main1 where CollegeName=?;";
                break;
            case "counciling2":
                dat="select * from Main2 where CollegeName=?;";
                break;
            case "counciling3":
                dat="select * from Main3 where CollegeName=?;";
                break;
        }
        return myDataBase.rawQuery(dat,new String[]{clg});
    }
    public Cursor queryclgs(){
       String clg=CutOffData.getClgname();
        String branch=CutOffData.getFbranch();
        System.out.println(clg+"141");
        System.out.println(branch+"142");
        //String clg="S R K INST. OF TECHNOLOGY";
       // CutOffData.setClgname(null);
       // System.out.println(clg+"142");
        //System.out.println(clg+"this is also college");
        System.out.println(CutOffData.getCounselling()+"145");
        switch (CutOffData.getCounselling()){
            case "counciling1":
                 dat="select * from Main1 where CollegeName=? and Branch=?;";
                break;
            case "counciling2":
                dat="select * from Main2 where CollegeName=? and Branch=?;";
                break;
            case "counciling3":
                dat="select * from Main3 where CollegeName=? and Branch=?;";
                break;
        }
       // String q="select * from Main1 where CollegeName=? ;";
        return myDataBase.rawQuery(dat,new String[]{clg,branch});
    }
    public Cursor cutoffQuery() {
        System.out.println(" in this this is rank"+cod.getRank());
        String rank=cod.getRank();
        System.out.println(rank+"this is rank");
        String Gender=cod.getGender();
        String Branch=cod.getBranch();
        System.out.println(Branch);
        String cast=cod.getCast();
        String open=cod.getOpen();
        System.out.println(cast+"here it is cast");

        System.out.println("in cutoff query");
        cod.getBranch();

//CutOff cutOff=new CutOff();
//System.out.println("in clone babes");
        //    System.out.println(cutOff.CutOff()+"in Clone");

        System.out.println(cod.allBranchesget()+"in all branches get");
        String allbranches[]=cod.allBranchesget();
        String allb[]=new String[cod.getLength()];

        System.out.println(cod.getLength()+"in length in length in length ");
        for(int i=0;i<cod.getLength();i++){
            System.out.println(allbranches[i]+"In Database Helper");
            allbranches[i]=allbranches[i].replace(allbranches[i],"\""+allbranches[i]+"\"");
            allb[i]=allbranches[i];
            System.out.println(allbranches[i]+"In Database Helper its ggssfgs rgsgsgsggsggsgsgnew "+allb[i]);


        }
        branch= Arrays.toString(allb);

        //branch=branch.replace(", null","");
        branch=branch.replace("[","(");
        branch=branch.replace("]",")");
        System.out.println(branch+"this is the branch in database helper"+branch);

        System.out.println("no branch hello usksskskskskskskskskskskssks"+cod.getLength1());

        if(cod.getLength1()==0 ) {
            cod.setBranches1(null);
            cod.setLength1(0);

            System.out.println("no branch hello usksskskskskskskskskskskssks"+cod.getLength());
            // q="select collegeName from main where "+rank+" between "+open+" and "+cast+" and Gender=? and Branch in "+branch+" group by "+open+",collegeName;";
            switch (cod.getCounselling()){
                case "counciling1":
                     //q="select CollegeName,Branch,"+open+","+cast+" from Main1 where "+cast+">=? and Branch in "+branch+" order by CollegeName;";
                     q="select CollegeName,Branch,"+open+","+cast+" from Main1 where "+cast+">=? and Branch in "+branch+" order by "+open+";";
                    break;
                case "counciling2":
                    q="select CollegeName,Branch,"+open+","+cast+" from Main2 where "+cast+">=? and Branch in "+branch+" order by "+open+";";
                    break;
                case "counciling3":
                    q="select CollegeName,Branch,"+open+","+cast+" from Main3 where "+cast+">=? and Branch in "+branch+" order by "+open+";";
                    break;
            }

            //   q="select collegeName,Branch,"+open+","+cast+" from main where "+cast+">=? and Gender=? and Branch in "+branch+" order by "+open+";";
            //   q="select collegeName,Branch,BC_A_Open,BC_A_Close from main where BC_A_Close>=1 and Gender=? and Branch in "(\"CSE","ECE","EEE")"  order by BC_A_Open  asc;"

            return myDataBase.rawQuery(q,new String[]{rank});


        }
        else {
            String allcolleges[] = cod.allBranchesgeting();

            String allb1[] = new String[cod.getLength1()];
            System.out.println(cod.getLength1()+"size"+allb1.length);
            System.out.println(branch+"t 123his is the branch in database helper"+branch);
            int length=cod.getLength1();
            cod.setLength1(0);
            for(int f=0;f<length;f++) {
                System.out.println(allcolleges[f]);
            }
            for (int i = 0; i < length; i++) {

                //  System.out.println("1"+"here"+cod.getLength1());
                // System.out.println(allcolleges[i] + "In Database Helper");
                allcolleges[i] = allcolleges[i].replace(allcolleges[i], "\"" + allcolleges[i] + "\"");
                System.out.println(allcolleges[i]+"catched here");
                allb1[i] = allcolleges[i];
                System.out.println(allcolleges[i] + "In Database Helper its ggssfgs rgsgsgsggsggsgsgnew " + allb1[i]);
                System.out.println("1");



            }

            System.out.println("hello hello hello helllo hello helllllllo");
            collegesall = Arrays.toString(allb1);
            collegesall=collegesall.replace(", null","");
            collegesall = collegesall.replace("[", "(");
            collegesall = collegesall.replace("]", ")");
            System.out.println(collegesall);
            switch (CutOffData.getCounselling()){
                case "counciling1":
                    r="select CollegeName,Branch,"+open+","+cast+" from Main1 where "+cast+">=? and Branch in "+branch+"  and CollegeName in "+collegesall+" order by "+cast+";";
                    break;
                case "counciling2":
                    r="select CollegeName,Branch,"+open+","+cast+" from Main2 where "+cast+">=? and Branch in "+branch+"  and CollegeName in "+collegesall+" order by "+cast+";";
                    break;
                case "counciling3":
                    r="select CollegeName,Branch,"+open+","+cast+" from Main3 where "+cast+">=? and Branch in "+branch+"  and CollegeName in "+collegesall+" order by "+cast+";";
                    break;
            }


            return myDataBase.rawQuery(r,new String[]{rank});



        }




    }

}


