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
import com.example.GS.java.model.User;

public class Registration extends AppCompatActivity {

    EditText login,pswd1,pswd2;
    Button validate, cancel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        login=findViewById(R.id.reg_log);
        pswd1=findViewById(R.id.reg_pswd1);
        pswd2=findViewById(R.id.reg_pswd2);
        validate=findViewById(R.id.btn_register_validate);
        cancel=findViewById(R.id.btn_register_cancel);

        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user=new User();
                user.setLogin(login.getText().toString());
                user.setPassword1(pswd1.getText().toString());
                user.setPassword2(pswd2.getText().toString());

                //on instancie UserdataSource
                UserdataSource userdataSource = new UserdataSource(getApplicationContext());
                long result = userdataSource.addUser(user);
                if (result==-1){

                    Toast.makeText(getApplicationContext(),"Erreur d'inscription !! ", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Inscription réussite !! ", Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(getApplicationContext(),authentificate.class);
                    startActivity(intent);
                }

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),authentificate.class);
                startActivity(intent);
            }
        });
    }
}
