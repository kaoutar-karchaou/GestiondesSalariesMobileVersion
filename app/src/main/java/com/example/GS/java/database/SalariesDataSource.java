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
        mydb = new databaseHelper(context);
    }


    //ajouter un Salarié
    public boolean insertSal (Salaries salarie){

        db=mydb.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put("nom",salarie.getNom());
        values.put("prenom",salarie.getPrenom());
        values.put("cin",salarie.getCin());
        values.put("addresse",salarie.getAdresse());
        values.put("telephone",salarie.getTelephone());
        values.put("email",salarie.getEmail());
        values.put("dateNaissance", salarie.getDateNaissance());
        values.put("departement",salarie.getDepartement());
        values.put("emploiOccupe", salarie.getEmploiOccupe());
        values.put("anciennete", salarie.getAnciennete());
        values.put("salairebase", salarie.getSalaireBase());
        values.put("prime", salarie.getPrime());

        long result = db.insert("salaries",null, values);

        if (result==-1) return false;
        else return true;

    }

    //afficher liste des salariés

    public List<Salaries> getAllSalaries(){

        db=mydb.getReadableDatabase();
        List<Salaries> salaries= new ArrayList<Salaries>();
        Cursor cursor = db.rawQuery("SELECT * FROM Salaries", null );
        cursor.moveToFirst();

        Salaries salarie = new Salaries();

        while (!cursor.isAfterLast()){
            //salarie.setId(cursor.getInt(0));
            salarie.setNom(cursor.getString(1));
            salarie.setPrenom(cursor.getString(2));
            salarie.setCin(cursor.getString(3));
            salarie.setAdresse(cursor.getString(4));
            salarie.setTelephone(cursor.getString(5));
            salarie.setEmail(cursor.getString(6));
            salarie.setDateNaissance(cursor.getString(7));
            salarie.setDepartement(cursor.getString(8));
            salarie.setEmploiOccupe(cursor.getString(9));
            salarie.setAnciennete(cursor.getInt(10));
            salarie.setSalaireBase(cursor.getInt(12));
            salarie.setPrime(cursor.getInt(12));

            salaries.add(salarie);
            cursor.moveToNext();
        }
        cursor.close();
        return salaries;

    }
}
