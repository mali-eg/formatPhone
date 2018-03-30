package com.personal.test.formatphone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Admin on 3/14/2018.
 */

public class DataBase extends SQLiteOpenHelper {
    private static final int DATABASES_VERSION = 3;
    private static final String DATABASES_NAME = "Data.db";
    public static final String TABLE_DATA = "MyData";

    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_EMAIL = "email";
    private static final String COL_PASS = "password";
    private final String CREATE_CUSTOMER = "create table "+TABLE_DATA+"("+COL_NAME+" TEXT, "+COL_EMAIL+" TEXT, "+COL_PASS+" TEXT)";

    public DataBase(Context context) {
        super(context, DATABASES_NAME, null, DATABASES_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CUSTOMER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String table, String name, String email,String password){
        ContentValues v = new ContentValues();
        v.put(COL_NAME, name);
        v.put(COL_EMAIL, email);
        v.put(COL_PASS, password);
        SQLiteDatabase data = this.getWritableDatabase();
        data.insert(table, null, v);
    }
    /*  public void delete(String table, String username){
          SQLiteDatabase data = this.getWritableDatabase();
          data.delete(table, "username = "+username, null);
      }

      public void update(String table, String username, String newUsername, String newPassword){
          SQLiteDatabase database = this.getWritableDatabase();
          ContentValues v = new ContentValues();
          v.put(USERNAME, newUsername);
          v.put(PASSWORD, newPassword);
          database.update(table, v, "username = "+username, null);
      }*/
   /* public String getPassword(String table, String email){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c = database.rawQuery("select password from "+table+" where email='"+email+"'", new String[]{COL_PASS});
        if(c != null && c.moveToFirst()){
            c.close();
            return c.getString(0);
        }
        return null;
    }*/
    public String verifyAccount(String email)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select email,password from MyData",null);
        String EMail;
        String PAss ="notfound";
        if (cursor.moveToFirst()){
            do {
                EMail = cursor.getString(0);
                if (EMail.equals(email)) {
                    PAss = cursor.getString(1);
                    break;
                }
            }while (cursor.moveToNext());
        }
        return PAss;
    }

}
