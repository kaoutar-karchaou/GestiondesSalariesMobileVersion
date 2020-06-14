package com.example.GS.java.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class databaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="contacts.db";
    public static final String TABLE_SAL="Salaries";
    public static final String TABLE_USER="users";
    private String sql="create table salaries (id INTEGER primary key autoincrement, nom TEXT, prenom TEXT, email TEXT, " +
            "telephone TEXT, cin TEXT , addresse TEXT, dateNaissance TEXT, departement TEXT , emploiOccupe TEXT, anciennete INTEGER, salairebase INTEGER, prime INTEGER) ";

    private String sqlite="create table "+TABLE_USER+" (login TEXT, password1 TEXT, password2 TEXT) ";

    public databaseHelper(Context context) {
        super(context, DATABASE_NAME, null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sql);
        db.execSQL(sqlite);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    String sql ="DROP TABLE IF EXISTS "+TABLE_SAL;
    db.execSQL(sql);

    String sql1 ="DROP TABLE IF EXISTS "+TABLE_USER;
    db.execSQL(sql1);

    onCreate(db);
    }

    public boolean updateData(String row_id, String nom, String prenom, String cin, String adress, String tel ,String mail,String dn, String dpt,
                              String em, int a, int s, int pr ){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nom",nom);
        values.put("prenom",prenom);
        values.put("cin",cin);
        values.put("addresse",adress);
        values.put("telephone", tel);
        values.put("email",mail);
        values.put("dateNaissance", dn);
        values.put("departement",dpt);
        values.put("emploiOccupe", em);
        values.put("anciennete",a);
        values.put("salairebase",s);
        values.put("prime", pr);

        long result = db.update("salaries", values, "id=?", new String[]{row_id});
        if(result == -1){
            return false;
        }else {
            return true;
        }

    }

}
