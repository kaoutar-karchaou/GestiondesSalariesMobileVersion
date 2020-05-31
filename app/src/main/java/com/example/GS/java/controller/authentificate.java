package com.example.GS.java.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.GS.R;
import com.example.GS.java.database.UserdataSource;

public class authentificate extends AppCompatActivity {
    EditText login,password;
    Button connect, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentificate);

        login=findViewById(R.id.login);
        password=findViewById(R.id.pswd);
        connect=findViewById(R.id.btn_connect);
        register=findViewById(R.id.btn_register);

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserdataSource userdataSource= new UserdataSource(authentificate.this);
                if (userdataSource.authentification(login.getText().toString(),password.getText().toString())==true){
                    Toast.makeText(getApplicationContext(),"success !", Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(getApplicationContext(),accueil.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(),"erreur !", Toast.LENGTH_LONG).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getApplicationContext(),Registration.class);
                startActivity(intent);
            }
        });

    }
}
