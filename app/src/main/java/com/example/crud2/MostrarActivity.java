package com.example.crud2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.crud2.adaptadores.ListaFutbolistasAdapter;
import com.example.crud2.db.DbFutbolistas;
import com.example.crud2.entidades.Futbolistas;

import java.util.ArrayList;

public class MostrarActivity extends AppCompatActivity {

    RecyclerView listaFutbolistas;
    ArrayList<Futbolistas> listaArrayFutbolistas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaFutbolistas = findViewById(R.id.listaFutbolistas);
        listaFutbolistas.setLayoutManager(new LinearLayoutManager(this));

        DbFutbolistas dbFutbolistas = new DbFutbolistas(MostrarActivity.this);
        listaArrayFutbolistas = new ArrayList<>();

        ListaFutbolistasAdapter adapter = new ListaFutbolistasAdapter(dbFutbolistas.mostrarFutbolistas());
        listaFutbolistas.setAdapter(adapter);//enviar toda la informacion estructurada
    }
}