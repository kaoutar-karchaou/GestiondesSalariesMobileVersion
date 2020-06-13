package com.example.GS.java.controller;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.GS.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList sal_id,sal_nom,sal_prenom;
    CustomAdapter(Activity activity,Context context, ArrayList sal_id, ArrayList sal_nom, ArrayList sal_prenom){
        this.context=context;
        this.sal_id=sal_id;
        this.sal_nom=sal_nom;
        this.sal_prenom=sal_prenom;
        this.activity=activity;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.myrow,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder,final int position) {
    holder.salId.setText(String.valueOf(sal_id.get(position)));
    holder.salP.setText(String.valueOf(sal_prenom.get(position)));
    holder.salN.setText(String.valueOf(sal_nom.get(position)));

    }

    @Override
    public int getItemCount() {
        return sal_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView salId, salN, salP;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            salId= itemView.findViewById(R.id.sal_id);
            salN= itemView.findViewById(R.id.sal_n);
            salP= itemView.findViewById(R.id.sal_p);
        }
    }
}
