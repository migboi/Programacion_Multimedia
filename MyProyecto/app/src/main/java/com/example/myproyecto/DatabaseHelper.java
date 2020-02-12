package com.example.myproyecto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    //creacion de la base de datos y sus tablas
    public static final String DATABASE_NAME="Students.db";
    public static final String TABLE_NAME="student_table";
    public static final String COL_ID_STUDENT="ID";
    public static final String COL_NAME_STUDENT="NAME";
    public static final String COL_SUR_STUDENT="SURNAME";
    public static final String COL_MARKS_STUDENT="MARKS";
    public static final String COL_SEXO_STUDENT="SEXO";


    public static final String TABLE_USER="user_table";
    public static final String COL_EMA_USER="EMAIL";
    public static final String COL_PAS_USER="PASS";



    public DatabaseHelper(Context context) {
        super(context,  "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table "+TABLE_USER+" (EMAIL TEXT PRIMARY KEY,PASS TEXT)");
        db.execSQL("create table "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS DOUBLE,SEXO TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);


    }

    //inserting

    public boolean insert(String email,String pass){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_EMA_USER,email);
        contentValues.put(COL_PAS_USER,pass);

        long result=  db.insert(TABLE_USER,null,contentValues);

        if(result== -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean insertData(String name,String surname,String marks,String sexo){

        //indicamos que la bas de datos es editable
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_NAME_STUDENT,name);
        contentValues.put(COL_SUR_STUDENT,surname);
        contentValues.put(COL_MARKS_STUDENT,marks);
        contentValues.put(COL_SEXO_STUDENT,sexo);


        long result=  db.insert(TABLE_NAME,null,contentValues);

        if(result== -1){
            return false;
        }else{
            return true;
        }

    }

    //metodo compruba email
    public boolean chkemail(String email){

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from user_table where email=?",new String[]{email});

        //Cursor cursor=db.rawQuery("select * from "+TABLE_USER+" where EMAIL =?",null);

        if(cursor.getCount()>0){
            return false;
        }else{
            return true;
        }
    }


    public Cursor getListar(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return res;


    }

    public Cursor getListarUser(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_USER,null);
       // System.out.println(res.getColumnCount() + " contenido: " + res.getInt(0));
        return res;

    }



    public boolean updateData(String id,String name,String surname,String marks,String sexo){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_ID_STUDENT,id);
        contentValues.put(COL_NAME_STUDENT,name);
        contentValues.put(COL_SUR_STUDENT,surname);
        contentValues.put(COL_MARKS_STUDENT,marks);
        contentValues.put(COL_SEXO_STUDENT,sexo);

        db.update(TABLE_NAME,contentValues,"ID = ?",new String[] { id });
        return true;

    }


    public Integer delete(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID = ?",new String[] {id});


    }


    public Cursor getSherch(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME+" where ID =?",null);
        return res;

    }

}
