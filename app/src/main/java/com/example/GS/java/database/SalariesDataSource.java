package com.example.GS.java.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.GS.java.model.Salaries;

import java.util.ArrayList;
import java.util.List;

public class SalariesDataSource {

private  databaseHelper mydb;
private SQLiteDatabase db;

    public SalariesDataSource(Context context) {
        this.mydb = new databaseHelper(context);
    }


    //ajouter un Salarié
    public long insertSal (Salaries salarie){

        db=mydb.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put("prenom",salarie.getPrenom());
        values.put("nom",salarie.getNom());
        values.put("cin",salarie.getCin());
        values.put("addresse",salarie.getAdresse());
        values.put("mail",salarie.getEmail());
        values.put("telephone",salarie.getTelephone());
        values.put("departement",salarie.getDepartement());
        values.put("emploiOccupe", salarie.getEmploiOccupe());
        values.put("anciennete", salarie.getAnciennete());
        values.put("salairebase", salarie.getSalaireBase());
        values.put("dateNaissance", salarie.getDateNaissance());
        values.put("prime", salarie.getPrime());

        long result = db.insert("TABLE_SAL",null, values);

        return result;

    }

    //afficher liste des salariés

    public List<Salaries> getAllSalaries(){
        mydb.getReadableDatabase();
        List<Salaries> salaries= new ArrayList<Salaries>();
        Cursor cursor = db.rawQuery("SELECT * FROM salaries", null );
        cursor.moveToFirst();
        Salaries salarie = new Salaries();
        while (!cursor.isAfterLast()){
            salarie.setId(cursor.getInt(0));
            salarie.setPrenom(cursor.getString(1));
            salarie.setNom(cursor.getString(2));
            salarie.setEmail(cursor.getString(3));
            salarie.setTelephone(cursor.getString(4));
            salarie.setCin(cursor.getString(5));
            salarie.setAdresse(cursor.getString(6));
            salarie.setDateNaissance(cursor.getString(7));
            salarie.setDepartement(cursor.getString(8));
            salarie.setEmploiOccupe(cursor.getString(9));
            salarie.setAnciennete(cursor.getInt(10));
            salarie.setSalaireBase(cursor.getInt(11));
            salarie.setPrime(cursor.getInt(11));

            salaries.add(salarie);
            cursor.moveToNext();
        }
        cursor.close();
        return salaries;

    }
}
