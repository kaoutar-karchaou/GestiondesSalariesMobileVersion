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
    SalariesDataSource dataSource=new SalariesDataSource(liste_Salaries.this);
    ArrayList<String> sal_nom,sal_prenom,sal_id;
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

        displayData();
        customAdapter=new CustomAdapter(liste_Salaries.this,this,sal_id, sal_nom, sal_prenom);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(liste_Salaries.this));
    }

    void displayData(){
        Cursor cursor = dataSource.readSal();
        if (cursor.getCount()==0){
            Toast.makeText(this, "rien à afficher", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                sal_id.add(cursor.getString(0));
                sal_nom.add(cursor.getString(1));
                sal_prenom.add(cursor.getString(2));
            }
        }
    }
}
