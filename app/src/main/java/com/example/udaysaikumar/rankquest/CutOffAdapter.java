package com.example.udaysaikumar.rankquest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rankquest.eamcet.FullInformationClg;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by udaysaikumar on 16/01/18.
 */

public class CutOffAdapter extends RecyclerView.Adapter<CutOffAdapter.ViewHolder> {
    private Context context,contexts;
    public CutOffAdapter(ArrayList<String> cutoffdata, ArrayList<String>branch, ArrayList<String>open, ArrayList<String>close,Context context) {
        this.cutoffdata = cutoffdata;
        this.branch=branch;
        this.open=open;
        this.close=close;
        this.hashMap=hashMap;
this.context=context;
        //this.cutoffdata1=cutoffdata1;
    }
   /* public CutOffAdapter(ArrayList<String> cutoffdata,Context context) {
        this.cutoffdata = cutoffdata;

        //this.branch=branch;
        //this.open=open;
        //this.close=close;
        //this.hashMap=hashMap;
        //this.context=context;
        //this.cutoffdata1=cutoffdata1;
    }
    public void filterList(ArrayList<String> list){
        this.cutoffdata=list;
        notifyDataSetChanged();
    }*/

    private ArrayList<String> cutoffdata;
    private ArrayList<String> branch;
    private ArrayList<String> open;
    private ArrayList<String> close;
    private HashMap<String,Integer> hashMap;
   // private ArrayList<String> cutoffdata1;
    public void filterlist(ArrayList<String> cutoffdata, ArrayList<String>branch, ArrayList<String>open, ArrayList<String>close){
this.cutoffdata=cutoffdata;
this.branch=branch;
this.open=open;
this.close=close;
notifyDataSetChanged();
    }

    @Override
    public CutOffAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cut_off_row,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CutOffAdapter.ViewHolder holder, final int position) {

        holder.cutoff.setText(cutoffdata.get(position));
        holder.branch.setText(branch.get(position));
        holder.open.setText(open.get(position));
        holder.close.setText(close.get(position));
        holder.cutoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String clgname=cutoffdata.get(position);
                contexts=view.getContext();
                System.out.println(clgname);
                 new CutOffData().setClgname(clgname);
              // new FullInformationClg(clgname);

                Intent intent=new Intent(view.getContext(), FullInformationClg.class);
                contexts.startActivity(intent);
               /* Toast.makeText(view.getContext(),"hi",Toast.LENGTH_SHORT).show();
                final Dialog dialog=new Dialog(view.getContext());
                dialog.setContentView(R.layout.fragdialog);
              //  dialog.setTitle(cutoffdata.get(position));
                dialog.show();*/
            }
        });
        holder.branch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String clgname=cutoffdata.get(position);
                contexts=view.getContext();
                System.out.println(clgname);
                new CutOffData().setClgname(clgname);
                // new FullInformationClg(clgname);

                Intent intent=new Intent(view.getContext(), FullInformationClg.class);
                //intent.putExtra("cut","cutoff");
                contexts.startActivity(intent);
               /* Toast.makeText(view.getContext(),"hi",Toast.LENGTH_SHORT).show();
                final Dialog dialog=new Dialog(view.getContext());
                dialog.setContentView(R.layout.fragdialog);
              //  dialog.setTitle(cutoffdata.get(position));
                dialog.show();*/
            }
        });
        holder.open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String clgname=cutoffdata.get(position);
                contexts=view.getContext();
                System.out.println(clgname);
                new CutOffData().setClgname(clgname);
                // new FullInformationClg(clgname);

                Intent intent=new Intent(view.getContext(), FullInformationClg.class);
                contexts.startActivity(intent);
               /* Toast.makeText(view.getContext(),"hi",Toast.LENGTH_SHORT).show();
                final Dialog dialog=new Dialog(view.getContext());
                dialog.setContentView(R.layout.fragdialog);
              //  dialog.setTitle(cutoffdata.get(position));
                dialog.show();*/
            }
        });holder.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String clgname=cutoffdata.get(position);
                contexts=view.getContext();
                System.out.println(clgname);
                new CutOffData().setClgname(clgname);
                // new FullInformationClg(clgname);
                System.out.println("bye bye ");
System.out.println("hello usk my god"+view.getContext().toString());

                Intent intent=new Intent(view.getContext(), FullInformationClg.class);
                contexts.startActivity(intent);
               /* Toast.makeText(view.getContext(),"hi",Toast.LENGTH_SHORT).show();
                final Dialog dialog=new Dialog(view.getContext());
                dialog.setContentView(R.layout.fragdialog);
              //  dialog.setTitle(cutoffdata.get(position));
                dialog.show();*/
            }
        });

        // holder.cutoff1.setText(cutoffdata1.get(position));
    }

    @Override
    public int getItemCount() {
        return cutoffdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView cutoff;
        TextView branch;
        TextView open;
        TextView close;
        public ViewHolder(View itemView) {
            super(itemView);
            cutoff=itemView.findViewById(R.id.cutoffrow);
            branch=itemView.findViewById(R.id.branch);
            open=itemView.findViewById(R.id.open);
            close=itemView.findViewById(R.id.close);



        }


    }

}
