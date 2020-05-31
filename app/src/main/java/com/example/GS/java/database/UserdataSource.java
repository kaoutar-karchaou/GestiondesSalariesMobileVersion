package com.example.GS.java.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.GS.java.model.User;

public class UserdataSource {
    private databaseHelper mydb;
    private SQLiteDatabase db;

    public UserdataSource(Context c){

        this.mydb = new databaseHelper(c);
    }
    public long addUser(User u){

        db= mydb.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put("login",u.getLogin());
        values.put("password1",u.getPassword1());
        values.put("password2",u.getPassword2());

        long result = db.insert("users",null,values);
        return result;
    }

    public boolean authentification(String login, String pass) {
        db = mydb.getReadableDatabase();
        String query = "select * from user where login=? and password1=?";
        Cursor c = db.rawQuery(query, new String[]{login, pass});

        if (c.getCount() > 0) return true;
        else return false;
    }
}
