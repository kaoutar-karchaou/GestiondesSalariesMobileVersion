package com.example.GS.java.controller;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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
    Button btnview;
    String id, n, p, c, ad, dn, m, tel, em, d,
            s, a, pr;
    int aa, ss, prr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        prenom = findViewById(R.id.edit_sal_prenom);
        nom = findViewById(R.id.edit_sal_nom);
        cin = findViewById(R.id.edit_sal_cin);
        addresse = findViewById(R.id.edit_sal_addresse);
        telephone = findViewById(R.id.edit_sal_telephone);
        email = findViewById(R.id.edit_sal_mail);
        dateNaissance = findViewById(R.id.edit_sal_date);
        departement = findViewById(R.id.edit_sal_departement);
        emploiOccupe = findViewById(R.id.edit_sal_emploi);
        anciennete = findViewById(R.id.edit_sal_anciennete);
        salaireBase = findViewById(R.id.edit_sal_salaire);
        prime = findViewById(R.id.edit_sal_prime);

        btnEdit = findViewById(R.id.edit_sal_btn_add);
        btnExit = findViewById(R.id.edit_sal_btn_exit);
        btnview = findViewById(R.id.edit_sal_btn_infos);

        //we call this
        getIntentData();

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(id);
        }


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper mydb = new databaseHelper(update.this);
                n = nom.getText().toString().trim();
                p = prenom.getText().toString().trim();
                c = cin.getText().toString().trim();
                ad = addresse.getText().toString().trim();
                tel = telephone.getText().toString().trim();
                m = email.getText().toString().trim();
                em = emploiOccupe.getText().toString().trim();
                dn = dateNaissance.getText().toString().trim();
                d = departement.getText().toString().trim();
                aa = Integer.parseInt(anciennete.getText().toString().trim());
                ss = Integer.parseInt(salaireBase.getText().toString().trim());
                prr = Integer.parseInt(prime.getText().toString().trim());
                boolean res= mydb.updateData(id, n, p, c, ad, tel, m, dn, d, em, aa, ss, prr);
                if (res==false){
                    Toast.makeText(getApplicationContext(),"erreur de modif!!",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"modification réussie!!",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), accueil.class);
                    startActivity(intent);
                }

            }
        });

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getApplicationContext(),infos_salarie.class);
                String n = nom.getText().toString();
                String p = prenom.getText().toString();
                String c = cin.getText().toString();
                String a = addresse.getText().toString();
                String t = telephone.getText().toString();
                String e = email.getText().toString();
                String d = dateNaissance.getText().toString();
                String dpt = departement.getText().toString();
                String empl = emploiOccupe.getText().toString();
                /* int an =Integer.parseInt(*/ String an=anciennete.getText().toString();
                /*int sa = Integer.parseInt(*/String sa =salaireBase.getText().toString();
                /*int pr =Integer.parseInt(*/String pr = prime.getText().toString();


                int anc=Integer.parseInt(an);
                int salBase=Integer.parseInt(sa);
                double primeAnc;
                double cnss;
                double cimr;
                double impot;

                // calculer prime anciennete

                int prm=Integer.parseInt(pr);
                if(anc<2){
                    primeAnc=0;
                }
                else if(anc>2 & anc<5){
                    primeAnc=salBase * 0.05;
                }
                else if(anc>5 & anc<12){
                    primeAnc=salBase * 0.1;
                }
                else if(anc>12 & anc<20){
                    primeAnc=salBase * 0.15;
                }
                else if(anc>20 & anc<25){
                    primeAnc=salBase * 0.2;
                }
                else {
                    primeAnc=salBase * 0.25;
                }

                //SalaireBrut = SalaireBase + primeAnciennete + prime

                double salaireBrut = salBase + primeAnc + prm;

                // calculer prelevement cnss

                if(salaireBrut<=6000){
                    cnss =salaireBrut * 0.0429;
                }
                else {
                    cnss = 6000 * 0.0429;
                }

                //calculer prelevement cimr

                cimr = salaireBrut * 0.06;

                // calculer prelevemnt des impots

                if(salaireBrut <=2500){
                    impot= salaireBrut* 0;
                }
                else if( salaireBrut > 2500 & salaireBrut< 4167){
                    impot = salaireBrut * 0.1;
                }
                else if( salaireBrut > 4166 & salaireBrut< 5001){
                    impot = salaireBrut * 0.2;
                }

                else if( salaireBrut > 5000 & salaireBrut< 6667){
                    impot = salaireBrut * 0.3;
                }
                else if( salaireBrut > 6666 & salaireBrut< 15001){
                    impot = salaireBrut * 0.3;
                }
                else {
                    impot = salaireBrut * 0.38;
                }

                // calculer salaire net

                double salaireNet = salaireBrut - cnss -cimr - impot;

                //////////////////////////////////////////////////////

                    // intent = new Intent(add_sal.this,Intent intent= new Intent(getApplicationContext(),liste_Salaries.class);
                    intent.putExtra("keynom", n);
                    intent.putExtra("keyprenom", p);
                    intent.putExtra("keyc", c);
                    intent.putExtra("keya", a);
                    intent.putExtra("keyt", t);
                    intent.putExtra("keye", e);
                    intent.putExtra("keyd", d);
                    intent.putExtra("keydpt", dpt);
                    intent.putExtra("keyempl", empl);
                    intent.putExtra("keyan", an);
                    intent.putExtra("keysa", sa);
                    intent.putExtra("keypr", pr);
                    intent.putExtra("i", salaireNet);

                    startActivity(intent);
            }
        });


        btnExit.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           databaseHelper mydb = new databaseHelper(update.this);
                                         boolean res=  mydb.deleteOnerow(id);
                                           finish();
                                           if (res==false){
                                               Toast.makeText(getApplicationContext(),"erreur de suppression!!",Toast.LENGTH_LONG).show();
                                           }else {
                                               Toast.makeText(getApplicationContext(),"Utilisateur Supprimé!!",Toast.LENGTH_LONG).show();
                                               Intent intent = new Intent(getApplicationContext(), accueil.class);
                                               startActivity(intent);
                                           }
                                       }
                                   }
        );

    }

    public void getIntentData() {
        //getting data from intent
//             if(getIntent().hasExtra("id") && getIntent().hasExtra("n") &&
//                     getIntent().hasExtra("p") && getIntent().hasExtra("c") && getIntent().hasExtra("ad")&& getIntent().hasExtra("tel")
//                     && getIntent().hasExtra("m")&& getIntent().hasExtra("dn")&& getIntent().hasExtra("d")&& getIntent().hasExtra("em")
//                     && getIntent().hasExtra("a")&& getIntent().hasExtra("s")&& getIntent().hasExtra("pr")){
//
//             }
//             else{
//                 Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
//             }

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
        a = getIntent().getStringExtra("an");
        s = getIntent().getStringExtra("s");
        pr = getIntent().getStringExtra("pr");

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
        anciennete.setText(a);
        salaireBase.setText(s);
        prime.setText(pr);
    }


}
