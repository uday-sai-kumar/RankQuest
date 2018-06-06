package com.rankquest.eamcet;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.udaysaikumar.rankquest.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by udaysaikumar on 06/02/18.
 */

public class FullInformationClgAdapter extends RecyclerView.Adapter<FullInformationClgAdapter.ViewHolder>{

    private ArrayList<String> ocopenr,occlosr,branch,bao,bac,bbo,bbc,bco,bcc,bdo,bdc,beo,bec,so,sc,to,tcf,ocopenrf,occlosrf,branchf,baof,bacf,bbof,bbcf,bcof,bccf,bdof,bdcf,beof,becf,sof,scf,tof,tc;
    public FullInformationClgAdapter(ArrayList<String>branch,ArrayList<String> ocopenr,ArrayList<String> occlosr,ArrayList<String> bao,ArrayList<String> bac,ArrayList<String> bbo,ArrayList<String> bbc,ArrayList<String> bco,ArrayList<String> bcc,ArrayList<String> bdo,ArrayList<String> bdc,ArrayList<String> beo,ArrayList<String> bec,ArrayList<String> so,ArrayList<String> sc,ArrayList<String> to,ArrayList<String> tc,ArrayList<String> ocopenrf,ArrayList<String> occlosrf,ArrayList<String> baof,ArrayList<String> bacf,ArrayList<String> bbof,ArrayList<String> bbcf,ArrayList<String> bcof,ArrayList<String> bccf,ArrayList<String> bdof,ArrayList<String> bdcf,ArrayList<String> beof,ArrayList<String> becf,ArrayList<String> sof,ArrayList<String> scf,ArrayList<String> tof,ArrayList<String> tcf) {

        this.ocopenr=ocopenr;
        this.occlosr=occlosr;
        this.bao=bao;
        this.bac=bac;
        this.bbo=bbo;
        this.bbc=bbc;
        this.bco=bco;
        this.bcc=bcc;
        this.bdo=bdo;
        this.bdc=bdc;
        this.beo=beo;
        this.bec=bec;
        this.so=so;
        this.sc=sc;
        this.to=to;
        this.tc=tc;
        this.ocopenrf=ocopenrf;
        this.occlosrf=occlosrf;
        this.baof=baof;
        this.bacf=bacf;
        this.bbof=bbof;
        this.bbcf=bbcf;
        this.bcof=bcof;
        this.bccf=bccf;
        this.bdof=bdof;
        this.bdcf=bdcf;
        this.beof=beof;
        this.becf=becf;
        this.sof=sof;
        this.scf=scf;
        this.tof=tof;
        this.tcf=tcf;

        this.branch=branch;
        // this.gender=gender;
        System.out.println("48");



    }
    /*public FullInformationClgAdapter(ArrayList<String>branch,ArrayList<String> ocopenr,ArrayList<String> occlosr,ArrayList<String> bao,ArrayList<String> bac,ArrayList<String> bbo,ArrayList<String> bbc,ArrayList<String> bco,ArrayList<String> bcc,ArrayList<String> bdo,ArrayList<String> bdc,ArrayList<String> beo,ArrayList<String> bec,ArrayList<String> so,ArrayList<String> sc,ArrayList<String> to,ArrayList<String> tc,ArrayList<String> ocopenrf,ArrayList<String> occlosrf,ArrayList<String> baof,ArrayList<String> bacf,ArrayList<String> bbof,ArrayList<String> bbcf,ArrayList<String> bcof,ArrayList<String> bccf,ArrayList<String> bdof,ArrayList<String> bdcf,ArrayList<String> beof,ArrayList<String> becf,ArrayList<String> sof,ArrayList<String> scf,ArrayList<String> tof,ArrayList<String> tcf) {

        this.ocopenr=ocopenr;
        this.occlosr=occlosr;
        this.bao=bao;
        this.bac=bac;
        this.bbo=bbo;
        this.bbc=bbc;
        this.bco=bco;
        this.bcc=bcc;
        this.bdo=bdo;
        this.bdc=bdc;
        this.beo=beo;
        this.bec=bec;
        this.so=so;
        this.sc=sc;
        this.to=to;
        this.tc=tc;
        this.ocopenrf=ocopenrf;
        this.occlosrf=occlosrf;
        this.baof=baof;
        this.bacf=bacf;
        this.bbof=bbof;
        this.bbcf=bbcf;
        this.bcof=bcof;
        this.bccf=bccf;
        this.bdof=bdof;
        this.bdcf=bdcf;
        this.beof=beof;
        this.becf=becf;
        this.sof=sof;
        this.scf=scf;
        this.tof=tof;
        this.tcf=tcf;
        this.branch=branch;
       // this.gender=gender;
        System.out.println("reached here");



    }*/
    //String clgs=hi.get(0);

    @Override
    public FullInformationClgAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_full_information_clg_card,parent,false);
        ViewHolder holder=new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(FullInformationClgAdapter.ViewHolder holder, int position) {
        holder.branch.setText(branch.get(position));
        holder.oco1.setText(ocopenr.get(position));
        holder.occ1.setText(occlosr.get(position));
        holder.bcao1.setText(bao.get(position));
        holder.bcac1.setText(bac.get(position));
        holder.bcbo1.setText(bbo.get(position));
        holder.bcbc1.setText(bbc.get(position));
        holder.bcco1.setText(bco.get(position));
        holder.bccc1.setText(bcc.get(position));
        holder.bcdo1.setText(bdo.get(position));
        holder.bcdc1.setText(bdc.get(position));
        holder.bceo1.setText(beo.get(position));
        holder.bcec1.setText(bec.get(position));
        holder.sco1.setText(so.get(position));
        holder.scc1.setText(sc.get(position));
        holder.sto1.setText(to.get(position));
        holder.stc1.setText(tc.get(position));
        holder.oco1f.setText(ocopenrf.get(position));
        holder.occ1f.setText(occlosrf.get(position));
        holder.bcao1f.setText(baof.get(position));
        holder.bcac1f.setText(bacf.get(position));
        holder.bcbo1f.setText(bbof.get(position));
        holder.bcbc1f.setText(bbcf.get(position));
        holder.bcco1f.setText(bcof.get(position));
        holder.bccc1f.setText(bccf.get(position));
        holder.bcdo1f.setText(bdof.get(position));
        holder.bcdc1f.setText(bdcf.get(position));
        holder.bceo1f.setText(beof.get(position));
        holder.bcec1f.setText(becf.get(position));
        holder.sco1f.setText(sof.get(position));
        holder.scc1f.setText(scf.get(position));
        holder.sto1f.setText(tof.get(position));
        holder.stc1f.setText(tcf.get(position));

    }
    @Override
    public int getItemCount() {
        System.out.println(branch.size()+"here it is");
        return branch.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

TextView branch,oco1,occ1,bcao1,bcac1,bcbo1,bcbc1,bcco1,bccc1,bcdo1,bcdc1,bceo1,bcec1,sco1,scc1,sto1,stc1,genderbranch,oco1f,occ1f,bcao1f,bcac1f,bcbo1f,bcbc1f,bcco1f,bccc1f,bcdo1f,bcdc1f,bceo1f,bcec1f,sco1f,scc1f,sto1f,stc1f;
        public ViewHolder(View itemView) {
            super(itemView);
           oco1=itemView.findViewById(R.id.oco);
            occ1=itemView.findViewById(R.id.occ);
            bcao1=itemView.findViewById(R.id.bcao);
            bcac1=itemView.findViewById(R.id.bcac);
            bcbo1=itemView.findViewById(R.id.bcbo);
            bcbc1=itemView.findViewById(R.id.bcbc);
            bcco1=itemView.findViewById(R.id.bcco);
            bccc1=itemView.findViewById(R.id.bccc);
            bcdo1=itemView.findViewById(R.id.bcdo);
            bcdc1=itemView.findViewById(R.id.bcdc);
            bceo1=itemView.findViewById(R.id.bceo);
            bcec1=itemView.findViewById(R.id.bcec);
            sco1=itemView.findViewById(R.id.sco);
            scc1=itemView.findViewById(R.id.scc);
            sto1=itemView.findViewById(R.id.sto);
            stc1=itemView.findViewById(R.id.stc);
            oco1f=itemView.findViewById(R.id.ocof);
            occ1f=itemView.findViewById(R.id.occf);
            bcao1f=itemView.findViewById(R.id.bcaof);
            bcac1f=itemView.findViewById(R.id.bcacf);
            bcbo1f=itemView.findViewById(R.id.bcbof);
            bcbc1f=itemView.findViewById(R.id.bcbcf);
            bcco1f=itemView.findViewById(R.id.bccof);
            bccc1f=itemView.findViewById(R.id.bcccf);
            bcdo1f=itemView.findViewById(R.id.bcdof);
            bcdc1f=itemView.findViewById(R.id.bcdcf);
            bceo1f=itemView.findViewById(R.id.bceof);
            bcec1f=itemView.findViewById(R.id.bcecf);
            sco1f=itemView.findViewById(R.id.scof);
            scc1f=itemView.findViewById(R.id.sccf);
            sto1f=itemView.findViewById(R.id.stof);
            stc1f=itemView.findViewById(R.id.stcf);

            branch=itemView.findViewById(R.id.branch);


        }
    }
}

