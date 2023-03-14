package com.example.crud2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.crud2.entidades.Futbolistas;

import java.util.ArrayList;

public class DbFutbolistas extends BaseHelper { //Esta clase hara las transacciones a la tabla

    Context context;
    public DbFutbolistas(@Nullable Context context) {

        super(context);
        this.context = context;

    }

    public long insertarFutbolista(String nombre, String equipo, String edad){ //Recibe parametros para la tabla
        long id = 0;
        try {
            BaseHelper baseHelper = new BaseHelper(context);
            SQLiteDatabase db = baseHelper.getWritableDatabase();

            ContentValues values = new ContentValues();//agregar registro
            values.put("nombre", nombre);
            values.put("equipo", equipo);
            values.put("edad", edad);

            id = db.insert(TABLE_FUTBOLISTA, null, values);//insertar registro a la tabla

        }catch (Exception ex){
            ex.toString();
        }

        return id;
    }
    //----------------------------------------
    public ArrayList<Futbolistas> mostrarFutbolistas(){//se traerán los datos de la tabla

        BaseHelper baseHelper = new BaseHelper(context);
        SQLiteDatabase db = baseHelper.getWritableDatabase();

        ArrayList<Futbolistas> listaFutbolistas = new ArrayList<>();
        Futbolistas futbolistas = null;
        Cursor cursorFutbolistas = null;

        cursorFutbolistas = db.rawQuery("SELECT * FROM " + TABLE_FUTBOLISTA, null);//consulta a la tabla

        if(cursorFutbolistas.moveToFirst()){ //validación
             do{
                 futbolistas = new Futbolistas();
                 futbolistas.setId(cursorFutbolistas.getInt(0));
                 futbolistas.setNombre(cursorFutbolistas.getString(1));
                 futbolistas.setEquipo(cursorFutbolistas.getString(2));
                 futbolistas.setEdad(cursorFutbolistas.getString(3));
                 listaFutbolistas.add(futbolistas);
             } while (cursorFutbolistas.moveToNext());//envia al siguiente registro
        }

        cursorFutbolistas.close();
        return listaFutbolistas;
    }

}
