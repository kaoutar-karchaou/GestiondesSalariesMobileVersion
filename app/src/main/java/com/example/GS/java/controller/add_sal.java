package com.example.GS.java.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.slice.Slice;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    Button add;
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

        add=findViewById(R.id.add_sal_btn_save);

        add.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSource = new SalariesDataSource(getApplicationContext());

                Salaries salaries = new Salaries();

                salaries.setPrenom(prenom.getText().toString());
                salaries.setNom(nom.getText().toString());
                salaries.setCin(cin.getText().toString());
                salaries.setEmail(email.getText().toString());
                salaries.setAdresse(addresse.getText().toString());
                salaries.setTelephone(telephone.getText().toString());
                salaries.setDateNaissance(dateNaissance.getText().toString());
                salaries.setDepartement(departement.getText().toString());
                salaries.setEmploiOccupe(emploiOccupe.getText().toString());
                //pour  ancienneté et  salaire de base je reçoit une erreur ; de int à string
                //salaries.setAnciennete(anciennete.getText().toString());
                //salaries.setSalaireBase(salaireBase.getText().toString());


                        dataSource.insertSal(salaries);
            }
        }));
    }
}
