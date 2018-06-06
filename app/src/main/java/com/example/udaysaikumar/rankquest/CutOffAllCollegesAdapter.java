package com.example.udaysaikumar.rankquest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by udaysaikumar on 27/01/18.
 */

public class CutOffAllCollegesAdapter extends RecyclerView.Adapter<CutOffAllCollegesAdapter.ViewHolder>  implements FastScrollRecyclerViewInterface{
    //private List<FilterModel> filterList;
    //private ArrayList<String> arrayList;
  //private final  SparseBooleanArray array=new SparseBooleanArray();
    //ArrayList<> numbers;
     ArrayList<CutOffAllCollegesAdapterData> listclg;
     HashMap<String,Integer> map;

    public CutOffAllCollegesAdapter(ArrayList<CutOffAllCollegesAdapterData> list,HashMap<String,Integer> map) {
        this.listclg = list;
        this.map=map;
        for(CutOffAllCollegesAdapterData i : list){
            System.out.println("you get it"+i);
        }
    }
   // ArrayList<String> list;

 /*public void filterList(ArrayList<String> list){
this.list=list;
notifyDataSetChanged();
    }*/
    //private List<CutOffAllCollegesAdapterData> list=new ArrayList<>();

  // private ArrayList<String> list=new ArrayList<>();

    @Override
    public CutOffAllCollegesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cut_off_row1,parent,false);
        ViewHolder hold=new ViewHolder(v);
        return hold;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
       //final String hello=list.get(position);
        holder.carddata.setText(listclg.get(position).getAllclg());
holder.checkBox.setChecked(listclg.get(position).isSelected());
holder.checkBox.setTag(listclg.get(position));
holder.checkBox.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        CheckBox box=(CheckBox)view;
        CutOffAllCollegesAdapterData ccd= (CutOffAllCollegesAdapterData) box.getTag();
        ccd.setSelected(box.isChecked());
        listclg.get(position).setSelected(box.isChecked());
        //Toast.makeText(view.getContext(),box.getText(),Toast.LENGTH_SHORT).show();

    }
});

/*if(array.get(position)){
    holder.checkBox.setChecked(true);
}
else {
    holder.checkBox.setChecked(false);
}*/
       // holder.checkBox.setOnCheckedChangeListener(null);

        //if true, your checkbox will be selected, else unselected
      /*  holder.checkBox.setChecked(numbers.get(position).isSelected());

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                numbers.get(holder.getAdapterPosition()).setSelected(isChecked);
            }
        });*/
//holder.checkBox.setOnCheckedChangeListener(null);



    }

    @Override
    public int getItemCount() {
        return listclg.size();
       // return list.size();
    }

    @Override
    public HashMap<String, Integer> getMapIndex() {
        return this.map;
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
TextView carddata;
CheckBox checkBox;
     public ViewHolder(final View itemView) {
         super(itemView);
         carddata=itemView.findViewById(R.id.carddata);
         checkBox=itemView.findViewById(R.id.allcollgebox);


        /* checkBox.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v){
                 array.put(getAdapterPosition(),true);
                 notifyDataSetChanged();

             }
         });*/
        // this.setIsRecyclable(false);
        /* checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                 Toast.makeText(itemView.getContext(),carddata.getText().toString(),Toast.LENGTH_SHORT).show();
             }
         });*/

     }



 }
    public ArrayList<CutOffAllCollegesAdapterData> getStudentist() {
        return listclg;
    }

}
