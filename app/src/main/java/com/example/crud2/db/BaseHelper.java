package com.example.crud2.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseHelper extends SQLiteOpenHelper {

    private static  final int DATABASE_VERSION = 1;
    private static  final String DATABASE_NOMBRE = "futbolistas.db";
    public static  final String TABLE_FUTBOLISTA = "t_futbolistas.db";



    public BaseHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_FUTBOLISTA + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "equipo TEXT NOT NULL," +
                "edad INT NOT NULL)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_FUTBOLISTA);
        onCreate(sqLiteDatabase);

    }
}
