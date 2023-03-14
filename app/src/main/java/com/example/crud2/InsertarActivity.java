package com.example.crud2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crud2.db.DbFutbolistas;

public class InsertarActivity extends AppCompatActivity {

    EditText TextoNombre, TextoEquipo, TextoEdad;
    Button btn_guardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        TextoNombre = findViewById(R.id.TextoNombre);
        TextoEquipo = findViewById(R.id.TextoEquipo);
        TextoEdad = findViewById(R.id.TextoEdad);

        btn_guardar = findViewById(R.id.btn_guardar);

        btn_guardar.setOnClickListener(new View.OnClickListener() {//detecta el evento cuando el usuario oprima el botón
            @Override //desde aqui se agrega la funcionalidad que se debe realizar
            public void onClick(View v) {
                DbFutbolistas dbFutbolistas = new DbFutbolistas(InsertarActivity.this);
                long id = dbFutbolistas.insertarFutbolista(TextoNombre.getText().toString(), TextoEquipo.getText().toString(), TextoEdad.getText().toString());

                if (id > 0) { //validar si el registro se ingresó de forma correcta
                    Toast.makeText(InsertarActivity.this, "Registro añadido de forma correcta", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(InsertarActivity.this, "El registro no se pudo añadir", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void limpiar(){ //para limpiar el formulario
        TextoEquipo.setText("");
        TextoNombre.setText("");
        TextoEdad.setText("");
    }
    }
