package com.example.GS.java.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.slice.Slice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.GS.R;
import com.example.GS.java.database.SalariesDataSource;
import com.example.GS.java.model.Salaries;

public class add_sal extends AppCompatActivity {

    EditText prenom;
    EditText nom;
    EditText cin;
    EditText addresse;
    EditText telephone;
    EditText dateNaissance;
    EditText departement;
    EditText emploiOccupe;
    EditText anciennete;
    EditText salaireBase;
    EditText email;
    Button btnSaveSal;
    Button btnExit;
    SalariesDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sal);
        prenom=findViewById(R.id.add_sal_prenom);
        nom=findViewById(R.id.add_sal_nom);
        cin=findViewById(R.id.add_sal_cin);
        addresse=findViewById(R.id.add_sal_addresse);
        telephone=findViewById(R.id.add_sal_telephone);
        email=findViewById(R.id.add_sal_mail);
        dateNaissance=findViewById(R.id.add_sal_date);
        departement=findViewById(R.id.add_sal_departement);
        emploiOccupe=findViewById(R.id.add_sal_emploi);
        anciennete=findViewById(R.id.add_sal_anciennete);
        salaireBase=findViewById(R.id.add_sal_salaire);

        btnSaveSal=findViewById(R.id.add_sal_btn_save);
        btnExit=findViewById(R.id.add_sal_btn_exit);

        //si on clique sur enregistrer
        btnSaveSal.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSource = new SalariesDataSource(getApplicationContext());

                Salaries salaries = new Salaries();
                int anc =Integer.parseInt(anciennete.getText().toString());
                int salaire =Integer.parseInt(salaireBase.getText().toString());

                salaries.setPrenom(prenom.getText().toString());
                salaries.setNom(nom.getText().toString());
                salaries.setCin(cin.getText().toString());
                salaries.setEmail(email.getText().toString());
                salaries.setAdresse(addresse.getText().toString());
                salaries.setTelephone(telephone.getText().toString());
                salaries.setDateNaissance(dateNaissance.getText().toString());
                salaries.setDepartement(departement.getText().toString());
                salaries.setEmploiOccupe(emploiOccupe.getText().toString());

                salaries.setAnciennete(anc);
                salaries.setSalaireBase(salaire);

                 long res=      dataSource.insertSal(salaries);
                        if(res ==-1){
                                Toast.makeText(getApplicationContext(),"erreur!!",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"success!!",Toast.LENGTH_LONG).show();
                            Intent intent= new Intent(getApplicationContext(),liste_Salaries.class);
                            startActivity(intent);
                        }

            }
        }));

        //si on clique sur annuler
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),accueil.class);
                startActivity(intent);
            }
        });
    }
}
