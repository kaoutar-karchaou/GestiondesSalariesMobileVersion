package com.example.GS.java.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class databaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="contacts.db";
    public static final String TABLE_SAL="salaries";
    public static final String TABLE_USER="users";

    public databaseHelper( Context context) {
        super(context, DATABASE_NAME, null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table "+TABLE_SAL+" (id INTEGER primary key autoincrement, nom TEXT, prenom TEXT, email TEXT, " +
                "telephone TEXT, cin TEXT , addresse TEXT, dateNaissance TEXT, departement TEXT , empoloiOccupe TEXT, anciennete INTEGER, salairebase INTEGER) ";

        String sqlite="create table "+TABLE_USER+" (login TEXT, password1 TEXT, password2 TEXT) ";
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
}
