package com.example.udaysaikumar.rankquest;

import java.util.ArrayList;

/**
 * Created by udaysaikumar on 15/01/18.
 */

public class CutOffData {
  /*  private  String Branch;
    private String Gender;
    private  String rank;
    private int length;
    private String[] branches;
    private  String Cast;

    public String getCast() {
        return Cast;
    }

    public void setCast(String cast) {
        Cast = cast;
    }


    public String[] getBranches() {
        return branches;
    }

    public void setBranches(String[] branches) {
        this.branches = branches;
    }


    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        this.Branch = branch;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    public String[] allBranchesget(){
        return branches.clone();
    }*/
private static String fbranch=null;
    private static    String Branch=null;
    private static String Gender=null;

    private static String counselling=null;
    private static String rank=null;
    private static   int length=0;
    private static   int length1=0;

    private static String[] allcollege;
    private static ArrayList<String> all;
    private static String[] colleges;

    private static String[] branches;
    private static String Cast;
    private static String[] branches1;

    public static int getGot() {
        return got;
    }

    public static void setGot(int got) {
        CutOffData.got = got;
    }

    private static int got;

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        CutOffData.size = size;
    }

    static  int size;

    public static String getFbranch() {
        return fbranch;
    }

    public static void setFbranch(String fbranch) {
        System.out.println(fbranch+"pageradapter cod 111");
        CutOffData.fbranch = fbranch;
    }

    public static String getCounselling() {
        System.out.println("109"+counselling);
        return counselling;
    }

    public void setCounselling(String counsel) {
        System.out.println("113"+counsel);
        switch (counsel){
            case "Counselling-1":
                counselling="counciling1";
                break;
            case "Counselling-2":
                counselling="counciling2";
                break;
            case "Counselling-3":
                counselling="counciling3";
                break;

        }
    }

    public static String getClgname() {
        return clgname;
    }

    public static void setClgname(String clgname) {
        CutOffData.clgname = clgname;
    }

    private static String clgname;

    public  String getOpen() {
        return open;
    }

    public  void setOpen(String open) {
        CutOffData.open = open;
    }

    private static String open;



    public int getLength1() {
        return length1;
    }

    public  void setLength1(int length1) {
        CutOffData.length1 = length1;
        for(int i=0;i<length1;i++){
            System.out.println(branches1[i]+"in setter branches usk usk usk usk");
        }
    }

    public  static String[] getBranches1() {
        return branches1;
    }

    public static void setBranches1(String[] branches) {
        System.out.println("in set branches 1");
        CutOffData.branches1 = branches;

    }
    public static String[] getColleges() {
        return colleges;
    }

    public static void setColleges(String[] colleges) {
        CutOffData.colleges = colleges;
    }

    public static ArrayList<String> getAll() {
        return all;
    }

    public static void setAll(ArrayList<String> all) {
        System.out.println("in cutoffdata"+all);
        CutOffData.all = all;
    }

    public  int getLength() {
        return length;
    }

    public  void setLength(int length) {
        CutOffData.length = length;
        for(int i=0;i<length;i++){
            System.out.println(branches[i]+"in setter branches usk");
        }
    }

    public static String[] getAllcollege() {
        return allcollege;
    }

    public static void setAllcollege(String[] allcollege) {
        System.out.println("setting all the colleges "+allcollege);
        CutOffData.allcollege = allcollege;
    }

    // private static String collegeName;
    // private static String BC_A_Close;
    //private   static String BC_A_Open;
    public  static String[] getBranches() {
        return branches;
    }

    public static void setBranches(String[] branches) {
        System.out.println("hello hello gello"+branches);
        CutOffData.branches = branches;

    }
    public String[] allBranchesget(){
        System.out.println("in all branches get");
        return branches.clone();
    }
    public String[] allBranchesgeting(){
        return branches1.clone();
    }

    public  String getCast() {
        return Cast;
    }

    public  void setCast(String cast) {
        Cast = cast;
    }

    public  String getRank() {
        return rank;
    }

    public  void setRank(String rank) {
        CutOffData.rank = rank;
    }


    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public String getGender() {
        System.out.println(Gender+"in get gender");
        return Gender;
    }

    public void setGender(String gender) {
        System.out.println(gender+"in gender set");
        Gender = gender;
    }







}
