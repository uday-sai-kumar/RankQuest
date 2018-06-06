package com.rankquest.udaysaikumar.rankquest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.udaysaikumar.rankquest.R;

import java.util.zip.Inflater;

/**
 * Created by udaysaikumar on 09/02/18.
 */

public class ReportingCentersAdapter extends RecyclerView.Adapter<ReportingCentersAdapter.ViewHolder> {
    public ReportingCentersAdapter(String[] strings) {
        this.strings = strings;
        System.out.println(strings[0]);

    }
private String[] strings;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_reporting_centers_card,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ReportingCentersAdapter.ViewHolder holder, int position) {
        holder.textView.setText(strings[position]);

    }

    @Override
    public int getItemCount() {
        return strings.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
          textView=itemView.findViewById(R.id.centers);
        }
    }
}
