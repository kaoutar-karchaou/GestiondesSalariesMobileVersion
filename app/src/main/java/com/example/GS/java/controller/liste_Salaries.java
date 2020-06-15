package com.example.GS.java.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.GS.R;
import com.example.GS.java.database.SalariesDataSource;
import com.example.GS.java.database.databaseHelper;
import com.example.GS.java.model.Salaries;

import java.util.ArrayList;
import java.util.List;

public class liste_Salaries extends AppCompatActivity {

    //Button btnAddSal;
   // ListView listeSal;
    RecyclerView recyclerView;
    databaseHelper mydb= new databaseHelper(liste_Salaries.this);
    ArrayList<String> sal_nom,sal_prenom,sal_id,sal_ad,sal_tel,sal_mail,sal_empl,sal_dpt,sal_sal,sal_anc,sal_prime,sal_cin,sal_dn;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste__salaries);
        recyclerView = findViewById(R.id.recyclerView);
        //listeSal=findViewById(R.id.liste_sal);
        //recuperer la liste des salaries
        //List<Salaries> s=new ArrayList<Salaries>();
      //  s=dataSource.getAllSalaries();
        // ajouter un adapteur
       // ArrayAdapter<Salaries> adapter=new ArrayAdapter<Salaries>(liste_Salaries.this, android.R.layout.simple_list_item_1, s);
        //listeSal.setAdapter(adapter);

        sal_nom = new ArrayList<>();
        sal_prenom = new ArrayList<>();
        sal_id = new ArrayList<>();
        sal_ad= new ArrayList<>();
        sal_tel= new ArrayList<>();
        sal_mail= new ArrayList<>();
        sal_empl= new ArrayList<>();
        sal_dpt= new ArrayList<>();
        sal_sal= new ArrayList<>();
        sal_anc= new ArrayList<>();
        sal_prime= new ArrayList<>();
        sal_dn=new ArrayList<>();
        sal_cin=new ArrayList<>();

        displayData();
        customAdapter=new CustomAdapter(liste_Salaries.this,this,sal_id,sal_nom, sal_prenom,sal_cin,sal_ad, sal_tel,sal_mail,sal_dn,sal_dpt,sal_empl,sal_anc,sal_sal,sal_prime);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(liste_Salaries.this));
    }

    void displayData(){
        Cursor cursor = mydb.readSal();
        if (cursor.getCount()==0){
            Toast.makeText(this, "rien à afficher", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                sal_id.add(cursor.getString(0));
                sal_nom.add(cursor.getString(1));
                sal_prenom.add(cursor.getString(2));
                sal_cin.add(cursor.getString(3));
                sal_ad.add(cursor.getString(4));
                sal_tel.add(cursor.getString(5));
                sal_mail.add(cursor.getString(6));
                sal_dn.add(cursor.getString(7));
                sal_dpt.add(cursor.getString(8));
                sal_empl.add(cursor.getString(9));
                sal_anc.add(cursor.getString(10));
                sal_sal.add(cursor.getString(11));
                sal_prime.add(cursor.getString(12));
            }
        }
    }
}
