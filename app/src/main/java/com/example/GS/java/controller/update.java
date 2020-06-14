package com.example.GS.java.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.GS.R;
import com.example.GS.java.database.SalariesDataSource;
import com.example.GS.java.database.databaseHelper;

public class update extends AppCompatActivity {
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
        EditText prime;
        Button btnEdit;
        Button btnExit;
        String id,n,p,c,ad,dn,m,tel,em,d;
             int  s, a,pr;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        prenom=findViewById(R.id.edit_sal_prenom);
        nom=findViewById(R.id.edit_sal_nom);
        cin=findViewById(R.id.edit_sal_cin);
        addresse=findViewById(R.id.edit_sal_addresse);
        telephone=findViewById(R.id.edit_sal_telephone);
        email=findViewById(R.id.edit_sal_mail);
        dateNaissance=findViewById(R.id.edit_sal_date);
        departement=findViewById(R.id.edit_sal_departement);
        emploiOccupe=findViewById(R.id.edit_sal_emploi);
        anciennete=findViewById(R.id.edit_sal_anciennete);
        salaireBase=findViewById(R.id.edit_sal_salaire);
        prime=findViewById(R.id.edit_sal_prime);

        btnEdit=findViewById(R.id.edit_sal_btn);
        btnExit=findViewById(R.id.edit_sal_btn_exit);




        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper mydb= new databaseHelper(update.this);
                mydb.updateData(id,n,p,c,ad,tel,m,dn,d,em,a,s,pr);
            }
        });

        getIntentData();
        }
         public void  getIntentData(){
    //getting data from intent
             if(getIntent().hasExtra("id") && getIntent().hasExtra("n") &&
                     getIntent().hasExtra("p") && getIntent().hasExtra("c") && getIntent().hasExtra("ad")&& getIntent().hasExtra("tel")
                     && getIntent().hasExtra("m")&& getIntent().hasExtra("dn")&& getIntent().hasExtra("d")&& getIntent().hasExtra("em")
                     && getIntent().hasExtra("a")&& getIntent().hasExtra("s")&& getIntent().hasExtra("pr")){
                 id = getIntent().getStringExtra("id");
                 n = getIntent().getStringExtra("n");
                 p = getIntent().getStringExtra("p");
                 c = getIntent().getStringExtra("c");
                 ad = getIntent().getStringExtra("ad");
                 tel = getIntent().getStringExtra("tel");
                 m = getIntent().getStringExtra("m");
                 dn = getIntent().getStringExtra("dn");
                 d = getIntent().getStringExtra("d");
                 em = getIntent().getStringExtra("em");
                 a = getIntent().getIntExtra("a", 0);
                 s = getIntent().getIntExtra("s", 0);
                 pr = getIntent().getIntExtra("pr", 0);

                 //setting itent data

                 nom.setText(n);
                 prenom.setText(p);
                 cin.setText(c);
                 addresse.setText(ad);
                 telephone.setText(tel);
                 email.setText(m);
                 dateNaissance.setText(dn);
                 departement.setText(d);
                 emploiOccupe.setText(em);
                 anciennete.setInputType(a);
                 salaireBase.setInputType(s);
                 prime.setInputType(pr);

             }
             else{
                 Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
             }
         }
        }
