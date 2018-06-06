package com.example.udaysaikumar.rankquest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by udaysaikumar on 13/01/18.
 */

public class BranchesAdapter extends RecyclerView.Adapter<BranchesAdapter.ViewHolder> {
private String[] branch,sf,sa,percent;

    public BranchesAdapter(String[] branch, String[] sf, String[] sa, String[] percent) {
        this.branch = branch;
        this.sf = sf;
        this.sa = sa;
        this.percent = percent;
    }
/* public BranchesAdapter(ArrayList<String> mDataset) {
        this.branchdata = mDataset;
    }*/

    @Override
    public BranchesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.activity_branches_row,parent,false);

        ViewHolder hold=new ViewHolder(v);
        return hold;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
holder.branches.setText(branch[position]);
holder.sa.setText("SA: "+sa[position]);
holder.sf.setText("SF: "+sf[position]);
holder.percent.setText("PER: "+percent[position]);

    }

    @Override
    public int getItemCount() {
        return branch.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView branches,sf,sa,percent;
        public ViewHolder(View itemView) {
            super(itemView);
            branches=itemView.findViewById(R.id.branches);
            sf=itemView.findViewById(R.id.sf);
            sa=itemView.findViewById(R.id.sa);
            percent=itemView.findViewById(R.id.percent);

        }

    }

}
