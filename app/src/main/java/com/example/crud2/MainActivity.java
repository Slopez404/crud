package com.example.crud2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.crud2.adaptadores.ListaFutbolistasAdapter;
import com.example.crud2.db.BaseHelper;
import com.example.crud2.db.DbFutbolistas;
import com.example.crud2.entidades.Futbolistas;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_crear;
    //RecyclerView listaFutbolistas;
    //ArrayList<Futbolistas> listaArrayFutbolistas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_crear = findViewById(R.id.btn_crear);
        /*listaFutbolistas = findViewById(R.id.listaFutbolistas);
        listaFutbolistas.setLayoutManager(new LinearLayoutManager(this));

        DbFutbolistas dbFutbolistas = new DbFutbolistas(MainActivity.this);
        listaArrayFutbolistas = new ArrayList<>();

        ListaFutbolistasAdapter adapter = new ListaFutbolistasAdapter(dbFutbolistas.mostrarFutbolistas());
        listaFutbolistas.setAdapter(adapter);//enviar toda la informacion estructurada*/




        btn_crear.setOnClickListener(new View.OnClickListener(){



        @Override
        public void onClick (View view){
        BaseHelper baseHelper = new BaseHelper(MainActivity.this);
        SQLiteDatabase db = baseHelper.getWritableDatabase(); //Se indica que se va a escribir en la bd
        if (db != null) {//Validación


        } else
            Toast.makeText(MainActivity.this, "No se pudo crear la Base de Datos", Toast.LENGTH_LONG).show();
    }
    });
    }



    public boolean onCreateOptionsMenu(Menu menu){//Para mostra el menú

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {//evalaur
        switch (item.getItemId()) {
            case R.id.nuevo_menu:
                nuevoRegistro();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void nuevoRegistro(){//para pasar de una vista a otra
        Intent intent = new Intent(this, InsertarActivity.class);
        startActivity(intent);

    }
}