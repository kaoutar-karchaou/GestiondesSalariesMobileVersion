package com.example.GS.java.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.GS.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList sal_id,sal_nom,sal_prenom,sal_cin,sal_ad,sal_tel,sal_mail,sal_empl,sal_dpt,sal_sal,sal_anc,sal_prime,sal_dn;
    int postion;
    CustomAdapter(Activity activity,Context context, ArrayList sal_id, ArrayList sal_nom, ArrayList sal_prenom,
                  ArrayList sal_ad,ArrayList sal_tel, ArrayList sal_mail, ArrayList sal_empl, ArrayList sal_dpt,
                  ArrayList sal_sal, ArrayList sal_anc, ArrayList sal_prime, ArrayList sal_cin,ArrayList sal_dn){
        this.context=context;
        this.sal_id=sal_id;
        this.sal_nom=sal_nom;
        this.sal_prenom=sal_prenom;
        this.activity=activity;
        this.sal_ad=sal_ad;this.sal_tel=sal_tel;this.sal_mail=sal_mail;this.sal_empl=sal_empl;
        this.sal_dpt=sal_dpt;this.sal_sal=sal_sal;this.sal_anc=sal_anc;this.sal_prime=sal_prime;
        this.sal_cin=sal_cin;this.sal_dn=sal_dn;

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
    this.postion=position;
    holder.updateActivity.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
         Intent intent = new Intent(context, update.class);
         intent.putExtra("id",String.valueOf(sal_id.get(position)));
         intent.putExtra("n",String.valueOf(sal_nom.get(position)));
         intent.putExtra("p",String.valueOf(sal_prenom.get(position)));
         intent.putExtra("c",String.valueOf(sal_cin.get(position)));
         intent.putExtra("ad",String.valueOf(sal_ad.get(position)));
         intent.putExtra("tel",String.valueOf(sal_tel.get(position)));
         intent.putExtra("m",String.valueOf(sal_mail.get(position)));
         intent.putExtra("dn",String.valueOf(sal_dn.get(position)));
         intent.putExtra("d",String.valueOf(sal_dpt.get(position)));
         intent.putExtra("em",String.valueOf(sal_empl.get(position)));
         intent.putExtra("a",Integer.valueOf((Integer)sal_anc.get(position)));
         intent.putExtra("s",Integer.valueOf((Integer)sal_sal.get(position)));
         intent.putExtra("pr", (Integer) sal_prime.get(position));
         activity.startActivityForResult(intent,1);
        }
    });

    }

    @Override
    public int getItemCount() {
        return sal_id.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView salId, salN, salP;
        LinearLayout updateActivity;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            salId= itemView.findViewById(R.id.sal_id);
            salN= itemView.findViewById(R.id.sal_n);
            salP= itemView.findViewById(R.id.sal_p);
            updateActivity=itemView.findViewById(R.id.updateActivity);
        }
    }
}
