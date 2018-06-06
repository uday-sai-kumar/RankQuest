package com.example.udaysaikumar.rankquest;

/**
 * Created by udaysaikumar on 08/01/18.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * Created by Bharadwaj on 07-01-2018.
 */



public class DatabaseHelper extends SQLiteOpenHelper {

    String DB_PATH = null;
    String q,r;

Bundle bundle;

    CutOffData cod=new CutOffData();
    String hi=cod.getCounselling();
    private static String DB_NAME="counciling3";
    //private static String DB_NAME = "counciling1";
    // private static String DB_NAME = "eamcetdb";
    SQLiteDatabase myDataBase;
    String collegesall,branch;
    private final Context myContext;


   /* @Override
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }*/

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 10);
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
System.out.println("this is the data base"+DB_NAME);

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
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    private void copyDataBase() throws IOException {
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
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
        String myPath = DB_PATH + DB_NAME;
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


    public Cursor query() {
        //  String q="select  collegeName,Place,Dist.Name,Region,Co-Educ,Affil-to,Fee from main group by collegeName;";
        String q="select CollegeName from Main3 group by CollegeName;";
        //System.out.println("this is clg in all clg"+q);

      //  String q="select collegeName,Place,Dist_Name,Region,Co_Educ,Code,fee from main group by collegeName;";
        return myDataBase.rawQuery(q,null);



    }
    public Cursor queryclg(){
        String clg=CutOffData.getClgname();
       // CutOffData.setClgname(null);
        System.out.println(clg+"this is also college");
        String q="select * from Main3 where CollegeName=?;";
        return myDataBase.rawQuery(q,new String[]{clg});
    }
    public Cursor querybranch(){
        String clg=CutOffData.getClgname();
       // System.out.println(clg+"pageradapter 164");
        String branch=CutOffData.getFbranch();
       // System.out.println(branch+"pageradapter 166");
        // CutOffData.setClgname(null);
        System.out.println(clg+"this is also college");
        String q="select * from Main3 where CollegeName=? and Branch=?;";
        return myDataBase.rawQuery(q,new String[]{clg,branch});
    }
    CutOffData cdata;
    int data=123;
    //String hi=String.valueOf(data);
    // private String[] datas={String.valueOf(data)};
    public Cursor queryBranch() {

        String q="select Branch from Main3 group by Branch;";
        return myDataBase.rawQuery(q,null);



    }
    public Cursor allCollegesQuery(){
        String q="select CollegeName from Main3 group by CollegeName order by CollegeName;";
        return myDataBase.rawQuery(q,null);

    }
    //private String rank,Gender,Branch,BC_A_Close;
    //CutOffData cod=new CutOffData();


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
                case "counselling 1":
                     q="select CollegeName,Branch,"+open+","+cast+" from Main1 where "+cast+">=? and Branch in "+branch+" order by CollegeName;";
                    // q="select CollegeName,Branch,"+open+","+cast+" from Main1 where "+cast+">=? and Branch in "+branch+" group by CollegeName order by "+open+";";
                    break;
                    case "counselling 2":
                        q="select CollegeName,Branch,"+open+","+cast+" from Main2 where "+cast+">=? and Branch in "+branch+" order by "+open+";";
                        break;
                case "counselling 3":
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
           // String r="select collegeName from main where "+cast+">=? and Gender=? and Branch in "+branch+"  and collegeName in "+collegesall+"group by collegeName order by "+cast+";";
           // String r="select collegeName,Branch,"+open+","+cast+" from main where "+cast+">=? and Gender=? and Branch in "+branch+"  and collegeName in "+collegesall+" order by "+cast+";";
            switch (cod.getCounselling()){
                case "counselling 1":
                    r="select CollegeName,Branch,"+open+","+cast+" from Main1 where "+cast+">=? and Branch in "+branch+"  and CollegeName in "+collegesall+" order by "+cast+";";
                    break;
                case "counselling 2":
                     r="select CollegeName,Branch,"+open+","+cast+" from Main2 where "+cast+">=? and Branch in "+branch+"  and CollegeName in "+collegesall+" order by "+cast+";";
                    break;
                case "counselling 3":
                     r="select CollegeName,Branch,"+open+","+cast+" from Main3 where "+cast+">=? and Branch in "+branch+"  and CollegeName in "+collegesall+" order by "+cast+";";
                    break;
            }


            return myDataBase.rawQuery(r,new String[]{rank});



        }
        //System.out.println("this is the branch in database helper"+collegesall);
        // String q="select collegeName from main where "+cast+">=? and Gender=? and Branch in "+branch+" and collegeName in "+collegesall+" group by collegeName order by "+cast+";";

        // String q="select collegeName from main where "+cast+">=? and Gender=? and Branch in "+branch+" group by collegeName order by "+cast+";";
        // String q="select collegeName from main where BC_A_Close>=\"8905\" and Gender=\"Male\"  group by collegeName;";
        //   String q="select collegeName from main where BC_A_Close>=? and Gender=?  group by collegeName;";
        //String q="select Branch from eamcet group by Branch;";
        //return myDataBase.rawQuery(q,new String[]{rank,Gender});



    }

}


