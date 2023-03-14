package com.example.crud2.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crud2.R;
import com.example.crud2.entidades.Futbolistas;

import java.util.ArrayList;

public class ListaFutbolistasAdapter extends RecyclerView.Adapter<ListaFutbolistasAdapter.FutbolistaViewHolder> {

    ArrayList<Futbolistas> listaFutbolistas;

    public ListaFutbolistasAdapter(ArrayList<Futbolistas> listaFutbolistas){
        this.listaFutbolistas = listaFutbolistas;
    }

    @NonNull
    @Override
    public FutbolistaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//asignar cual sera el diseño que tendra cada elemento de la lista
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_futbolista, null, false);
        return new FutbolistaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FutbolistaViewHolder holder, int position) {//asignar que corresponde a cada dato
        holder.viewNombre.setText(listaFutbolistas.get(position).getNombre());
        holder.viewEquipo.setText(listaFutbolistas.get(position).getEquipo());
        holder.viewEdad.setText(listaFutbolistas.get(position).getEdad());


    }

    @Override
    public int getItemCount() {//mostrar tamaño de la lista
        return listaFutbolistas.size();
    }

    public class FutbolistaViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewEquipo, viewEdad;
        public FutbolistaViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewEquipo = itemView.findViewById(R.id.viewEquipo);
            viewEdad = itemView.findViewById(R.id.viewEdad);

        }
    }
}
