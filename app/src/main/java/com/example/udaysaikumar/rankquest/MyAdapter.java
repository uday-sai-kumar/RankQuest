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
 * Created by udaysaikumar on 13/01/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>  implements FastScrollRecyclerViewInterface{
    private ArrayList<String> mDataset;
    private ArrayList<String> mDataset1;
    private ArrayList<String> aff;
    private ArrayList<String> dist;
    private ArrayList<String> region;
    private ArrayList<String> code;
    private ArrayList<String> fee;
Context contexts;
    private HashMap<String, Integer> mMapIndex;
  //  int mExpandedPosition=-1;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView,text2,affl,di,reg,cod,fe;
        public ViewHolder(View v) {
            super(v);

            mTextView = v.findViewById(R.id.textView);
           // text2=v.findViewById(R.id.textView1);
           // affl=v.findViewById(R.id.affiliate);
           // di=v.findViewById(R.id.distname);
           // reg=v.findViewById(R.id.region);
           // cod=v.findViewById(R.id.coedu);
           // fe=v.findViewById(R.id.fee);

        }
    }

    //, ArrayList<String> Dataset1,ArrayList<String> maff, ArrayList<String> mdist,
   // ArrayList<String> mregion,ArrayList<String> mcode,ArrayList<String> mfee,
    public MyAdapter(ArrayList<String> myDataset ,HashMap<String,Integer> mapIndex) {
       this.mDataset = myDataset;
       // mDataset1=Dataset1;
        //aff=maff;
        //dist=mdist;
        //region=mregion;
        //code=mcode;
       // fee=mfee;
        this.mMapIndex = mapIndex;
        System.out.println("hello babes"+mapIndex);

    }
    public void filterList(ArrayList<String> list,HashMap<String,Integer> mapIndex){
        this.mDataset=list;
        this.mMapIndex=mapIndex;
        notifyDataSetChanged();

    }
    /*public MyAdapter(ArrayList<String> myDataset) {
        mDataset = myDataset;
        // mDataset1=Dataset1;
        //aff=maff;
        //dist=mdist;
        //region=mregion;
        //code=mcode;
        // fee=mfee;
       // mMapIndex = mapIndex;
    }
*/
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTextView.setText(mDataset.get(position));
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String clgname=mDataset.get(position);
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
      /*  holder.text2.setText(mDataset1.get(position));
        holder.affl.setText(aff.get(position));
        holder.di.setText(dist.get(position));
        holder.reg.setText(region.get(position));
        holder.cod.setText(code.get(position));
        holder.fe.setText(fee.get(position));

        final boolean isExpanded = position==mExpandedPosition;
        holder.text2.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.affl.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.di.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.reg.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.cod.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.fe.setVisibility(isExpanded?View.VISIBLE:View.GONE);

        holder.mTextView.setActivated(isExpanded);*/
        /*holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:position;
                notifyItemChanged(position);
            }
        });*/


    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public HashMap<String, Integer> getMapIndex() {
        return this.mMapIndex;
    }
}