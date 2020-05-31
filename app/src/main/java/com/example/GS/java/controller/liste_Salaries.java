package com.example.GS.java.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.GS.R;

public class liste_Salaries extends AppCompatActivity {

    Button btnAddSal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste__salaries);

        btnAddSal=findViewById(R.id.liste_sal_btn_add);

        btnAddSal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),add_sal.class);
            }
        });

    }
}
