package com.example.stwart.proyecto_2_paseos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseHelper extends SQLiteOpenHelper {

    String tabla = "CREATE TABLE Paseos(ID SERIAL, NOMBRE TEXT, FECHA TEXT, HORA TEXT," +
            "UBICACION TEXT, TIPO TEXT, DESCRIPCION TEXT)";
    public BaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table paseos");
        db.execSQL(tabla);
    }
}
