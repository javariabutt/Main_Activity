package com.example.main_activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Vholder> {
    Context context;
    ArrayList<Model> ar;

    public Adapter(Context context, ArrayList<Model> ar) {
        this.context= context;
        this.ar= ar;
        }

    @NonNull
    @Override
    public Vholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.texty,parent,false);
        return new Vholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.Vholder holder, int position) {
        holder.t1.setText(ar.get(position).getEdu_id());

    }

    @Override
    public int getItemCount() { return ar.size(); }
    public static  class Vholder extends RecyclerView.ViewHolder{
        TextView t1;
        public Vholder(@NonNull View itemView){
            super(itemView);

            t1=itemView.findViewById(R.id.t1);
        }
    }

}