package com.example.GS.java.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.GS.R;
import com.example.GS.java.database.SalariesDataSource;
import com.example.GS.java.model.Salaries;

import java.util.ArrayList;
import java.util.List;

public class liste_Salaries extends AppCompatActivity {

    Button btnAddSal;
    ListView listeSal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste__salaries);

        btnAddSal=findViewById(R.id.liste_sal_btn_add);
        listeSal=findViewById(R.id.liste_sal);

        SalariesDataSource dataSource=new SalariesDataSource(getApplicationContext());
        //recuperer la liste des salaries
        List<Salaries> salaries=new ArrayList<Salaries>();
        salaries=dataSource.getAllSalaries();
        // ajouter un adapteur
        ArrayAdapter<Salaries> adapter=new ArrayAdapter<Salaries>(getApplicationContext(), android.R.layout.simple_list_item_1, salaries);
        listeSal.setAdapter(adapter);


        btnAddSal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),add_sal.class);
            }
        });

    }
}
