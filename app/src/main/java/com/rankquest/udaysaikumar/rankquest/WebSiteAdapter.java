package com.rankquest.udaysaikumar.rankquest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.udaysaikumar.rankquest.MyAdapter;
import com.example.udaysaikumar.rankquest.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.Inflater;

import static android.support.v7.widget.RecyclerView.*;

/**
 * Created by udaysaikumar on 29/01/18.
 */

public class WebSiteAdapter extends RecyclerView.Adapter<WebSiteAdapter.ViewHolder>{
    public WebSiteAdapter(ArrayList<String> list,ArrayList<String> links) {
        this.list = list;
        this.links=links;
    }

   // String[] websites;
   private ArrayList<String> list=new ArrayList<>();
private ArrayList<String> links=new ArrayList<>();

    @Override
    public WebSiteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_web_site_card,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.web.setText(list.get(position));
        holder.links.setText(links.get(position));
        holder.web.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent web=new Intent(Intent.ACTION_VIEW, Uri.parse(links.get(position)));
                v.getContext().startActivity(web);
            }
        });
        holder.links.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent web=new Intent(Intent.ACTION_VIEW, Uri.parse(links.get(position)));
                v.getContext().startActivity(web);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView web,links;

        public ViewHolder(View itemView) {
            super(itemView);
            web=itemView.findViewById(R.id.websitecard);
            links=itemView.findViewById(R.id.links);
        }
    }

}
