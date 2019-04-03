package com.example.timelymobileapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Random;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME  = "timely.db";
    public static final String TABLE_NAME = "user";
    public static final String COL1 = "UID";
    public static final String COL2 = "FIRSTNAME";
    public static final String COL3 = "LASTNAME";
    public static final String COL4 = "EMAIL";
    public static final String COL5 = "PASSWORD";
    Random ran = new Random();

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (FirstName STRING (30, 0) NOT NULL, LastName  STRING (30, 0) NOT NULL, Email STRING (30, 0) NOT NULL UNIQUE, Password  STRING (30, 0) NOT NULL)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String firstName, String lastName, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(COL1, ran.nextInt(3));
        contentValues.put(COL2, firstName);
        contentValues.put(COL3, lastName);
        contentValues.put(COL4, email);
        contentValues.put(COL5, password);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        }
        else {
            return true;
        }
    }
}
